package dojo.concordance;

import org.testng.annotations.Test;

import static dojo.concordance.Word.word;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author arkangelofkaos
 */
public class WordTest {

    @Test
    public void wordForPlainString_HasValueLowerCased() throws Exception {
        assertThat(word("Foo").getValue(), is("foo"));
    }

    @Test
    public void wordForStringWithPunctation_HasValueWithoutPunctation() throws Exception {
        String wordForStringWithPuncationValue = word(",Foo!").getValue();
        assertThat(wordForStringWithPuncationValue, not(containsString("!")));
        assertThat(wordForStringWithPuncationValue, not(containsString(",")));
    }
}
