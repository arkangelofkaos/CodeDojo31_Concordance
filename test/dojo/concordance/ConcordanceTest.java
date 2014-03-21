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
    public void givenTextFile_shouldBuildCondordanceWithOccuranceOf_simple_On_LineSix() throws Exception {
        Concordance concordance = new Concordance("concordance_test.txt");
        assertThat(concordance.occurancesOf(word("simple")).lines().anyMatch(
                new Line(6, "Simple sentence.")::equals
        ), is(true));
    }

    @Test
    public void givenTextField_shouldBuildConcordanceWithoutOccuranceOf_missingWord() throws Exception {
        Concordance concordance = new Concordance("concordance_test.txt");
        assertThat(concordance.occurancesOf(word("missingWord")).lines().count(), is(0L));
    }

    @Test
    public void givenMagnaCarta_shouldBuildCondordanceWithTwelveOccurancesOf_lands() throws Exception {
        Concordance concordance = new Concordance("magna_carta.txt");
        assertThat(concordance.occurancesOf(word("lands")).lines().count(), is(12L));
    }
}
