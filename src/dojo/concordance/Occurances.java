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

    @Override
    public String toString() {
        return "Occurances{" +
                "word=" + word +
                ", lines=" + lines +
                '}';
    }

    public static Occurances merge(Occurances o1, Occurances o2) {
        if (o1 == null) {
            return o2;
        }
        if (o2 != null && !o1.equals(o2) && o1.word.equals(o2.word)) {
            o1.lines.addAll(o2.lines);
        }
        return o1;
    }
}
