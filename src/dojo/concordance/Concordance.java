package dojo.concordance;

import dojo.concordance.io.FileReadingException;

import java.util.List;
import java.util.Map;

import static dojo.concordance.io.FileToLinesReader.readLinesFromFile;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author arkangelofkaos
 */
public class Concordance {

    private static final List<Occurances> EMPTY_LIST = asList();

    private final Map<Word, List<Occurances>> wordToOccurranceMap;

    public Concordance(String fileName) throws FileReadingException {
        this.wordToOccurranceMap = readLinesFromFile(fileName).stream()
                .flatMap(line -> toOccurances(line).stream())
                .collect(groupingBy(Occurances::getWord));
    }

    private List<Occurances> toOccurances(Line line) {
        return asList(line.getText().split(" ")).stream()
                .map(Word::word)
                .distinct()
                .map(word -> new Occurances(word, line))
                .collect(toList());
    }

    public Occurances occurancesOf(Word word) {
        return wordToOccurranceMap.getOrDefault(word, EMPTY_LIST)
                                  .stream()
                                  .reduce(Occurances::merge)
                                  .orElseGet(() -> new Occurances(word));
    }
}
