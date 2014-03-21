package dojo.concordance;

import dojo.concordance.io.FileReadingException;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static dojo.concordance.io.FileToLinesReader.readLinesFromFile;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * @author arkangelofkaos
 */
public class Concordance {

    private final Map<Word, Occurances> wordToOccurranceMap;

    public Concordance(String fileName) throws FileReadingException {
        this.wordToOccurranceMap =
                readLinesFromFile(fileName)
                        .stream()
                        .flatMap(line -> toOccurances(line))
                        .collect(occurancesByWord());
    }

    private Stream<Occurances> toOccurances(Line line) {
        return line.words().distinct().map(word -> new Occurances(word, line));
    }

    private Collector<Occurances, ?, Map<Word, Occurances>> occurancesByWord() {
        return groupingBy(Occurances::getWord, reducing(null, Occurances::merge));
    }

    public Occurances occurancesOf(Word word) {
        return wordToOccurranceMap.getOrDefault(word, new Occurances(word));
    }
}
