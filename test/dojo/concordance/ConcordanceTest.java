package dojo.concordance;

import org.testng.annotations.Test;

import static dojo.concordance.Word.word;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author arkangelofkaos
 */
public class ConcordanceTest {

    @Test
    public void givenPathToText_shouldBuildCondordanceWhichMaps_WordSimple_To_LineSix() throws Exception {
        Concordance concordance = new Concordance("concordance_test.txt");
        assertThat(concordance.occurancesOf(word("simple")).lines().anyMatch(
                new Line(6, "Simple sentence.")::equals
        ), is(true));
    }
}
