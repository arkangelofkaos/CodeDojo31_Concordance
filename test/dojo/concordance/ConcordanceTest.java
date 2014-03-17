package dojo.concordance;

import org.testng.annotations.Test;

import static dojo.concordance.Line.line;
import static dojo.concordance.Word.word;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * @author arkangelofkaos
 */
public class ConcordanceTest {

    @Test(groups = "integration")
    public void givenPathToText_shouldBuildCondordanceWhichMaps_WordSimple_To_LineSix() throws Exception {
        Concordance condorance = new Concordance("/dojo/concordance/concordance_test.txt");
        assertThat(condorance.occurancesOf(word("simple")), contains(line(6)));
    }
}
