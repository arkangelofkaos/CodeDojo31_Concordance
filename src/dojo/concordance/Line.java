package dojo.concordance;

/**
 * @author arkangelofkaos
 */
public class Line {
    private final long lineNumber;

    private Line(long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public static Line line(long lineNumber) {
        return new Line(lineNumber);
    }
}
