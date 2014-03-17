package dojo.concordance;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.contains;

/**
 * @author arkangelofkaos
 */
public class ConcordanceTest {

    @Test(groups = "integration")
    public void givenPathToText_shouldBuildCondordanceWhichMaps_WordSimple_To_LineSix() throws Exception {
        Concordance condorance = new Concordance("/dojo/concordance/concordance_test.txt");
        Occurances occurancesOfSimple = condorance.occurancesFor("simple");
        assertThat(occurancesOfSimple, contains(new Line(6)));
    }
}
