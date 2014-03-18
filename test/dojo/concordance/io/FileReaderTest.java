package dojo.concordance.io;

import dojo.concordance.Line;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author arkangelofkaos
 */
public class FileReaderTest {

    @Test(groups = "unit")
    public void readingConcordanceFile_returnsSevenLines() throws Exception {
        FileReader fileReader = new FileReader();
        List<Line> lines = fileReader.read("concordance_test.txt");
        assertThat(lines.size(), is(7));
    }

    @Test(groups = "unit", expectedExceptions = FileReadingException.class)
    public void readingNonExistentConcordanceFile_throwsMissingFileException() throws Exception {
        new FileReader().read("nonExistentFile.foo");
    }

}
