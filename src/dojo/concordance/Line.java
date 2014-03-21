package dojo.concordance;

import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author arkangelofkaos
 */
public final class Line implements Comparable<Line> {
    private static final String WHITESPACE = "\\s";
    private final long number;
    private final String text;

    public Line(long number, String text) {
        this.number = number;
        this.text = text;
    }

    public Stream<Word> words() {
        return asList(text.split(WHITESPACE)).stream().map(Word::word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (number != line.number) return false;
        if (!text.equals(line.text)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (number ^ (number >>> 32));
        result = 31 * result + text.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "number=" + number +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public int compareTo(Line o) {
        int compare = Long.compare(number, o.number);
        return compare != 0 ? compare : text.compareTo(o.toString());
    }
}
