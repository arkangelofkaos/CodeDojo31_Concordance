package dojo.concordance;

/**
 * @author arkangelofkaos
 */
public final class Line implements Comparable<Line> {
    private final long number;
    private final String text;

    public Line(long number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getText() {
        return text;
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
