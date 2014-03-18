package dojo.concordance;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author arkangelofkaos
 */
public class Occurances {

    private final Word word;
    private final SortedSet<Line> lines;

    public Occurances(Word word, Line... lines) {
        this.word = word;
        this.lines = new TreeSet<>(asList(lines));
    }

    public Word getWord() {
        return word;
    }

    public Stream<Line> lines() {
        return lines.stream();
    }

    public Occurances merge(Occurances otherOccurances) {
        if (!this.equals(otherOccurances) && this.word.equals(otherOccurances.word)) {
            lines.addAll(otherOccurances.lines);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Occurances{" +
                "word=" + word +
                ", lines=" + lines +
                '}';
    }
}
