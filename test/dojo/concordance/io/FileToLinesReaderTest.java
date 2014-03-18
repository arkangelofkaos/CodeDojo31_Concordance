package dojo.concordance.io;

import dojo.concordance.Line;
import org.testng.annotations.Test;

import java.util.List;

import static dojo.concordance.io.FileToLinesReader.readLinesFromFile;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author arkangelofkaos
 */
public class FileToLinesReaderTest {

    @Test
    public void readingConcordanceFile_returnsSevenLines() throws Exception {
        List<Line> lines = readLinesFromFile("concordance_test.txt");
        assertThat(lines.size(), is(7));
    }

    @Test
    public void readingConcordanceFile_hasLineSixWithTextSimpleSentence() throws Exception {
        List<Line> lines = readLinesFromFile("concordance_test.txt");
        assertThat(lines, hasItem(new Line(6, "Simple sentence.")));
    }

    @Test(expectedExceptions = FileReadingException.class)
    public void readingNonExistentConcordanceFile_throwsMissingFileException() throws Exception {
        readLinesFromFile("nonExistentFile.foo");
    }

}
