package dojo.concordance;

import dojo.concordance.io.FileReadingException;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static dojo.concordance.io.FileToLinesReader.readLinesFromFile;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author arkangelofkaos
 */
public class Concordance {

    private final SortedMap<Word, Occurances> wordToOccurranceMap;

    public Concordance(String fileName) throws FileReadingException {
        this.wordToOccurranceMap = new TreeMap<>();
        readLinesFromFile(fileName).stream()
                .map(this::toOccurances)
                .flatMap(occurances -> occurances.stream())
                .forEach(occurance -> {
                    Word word = occurance.getWord();
                    Occurances mappedOccurance = wordToOccurranceMap.getOrDefault(word, occurance);

                    wordToOccurranceMap.put(word, mappedOccurance.merge(occurance));
                });
    }

    public List<Occurances> toOccurances(Line line) {
        return asList(line.getText().split(" ")).stream()
                .map(Word::word)
                .distinct()
                .map(word -> new Occurances(word, line))
                .collect(toList());
    }

    public Occurances occurancesOf(Word word) {
        return wordToOccurranceMap.get(word);
    }
}
