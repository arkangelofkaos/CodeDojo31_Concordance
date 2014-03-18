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
        String concordanceFile = Thread.currentThread().getContextClassLoader()
                                       .getResource("concordance_test.txt").getPath();
        List<Line> lines = fileReader.read(concordanceFile);
        assertThat(lines.size(), is(7));
    }
}
