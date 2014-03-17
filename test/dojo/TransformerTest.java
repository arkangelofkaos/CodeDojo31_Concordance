package dojo;

import dojo.concordance.Word;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static dojo.concordance.Word.word;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * @author arkangelofkaos
 */
public class TransformerTest {

    private static final String FOO = "foo";
    private Transformer transformer;

    @BeforeMethod
    public void setUp() throws Exception {
        transformer = new Transformer();
    }

    @Test
    public void givenFooReturnsSetWithFoo() throws Exception {
        assertThat(transformer.convert(FOO), contains(word(FOO)));
    }

    @Test
    public void givenFooBarReturnsSetWithBar() throws Exception {
        Set<Word> convert = transformer.convert("foo bar");
        assertThat(convert, contains(word(FOO), word("bar")));
    }

}
