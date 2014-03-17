package dojo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static dojo.Word.wordFor;
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
        assertThat(transformer.convert(FOO), contains(wordFor(FOO)));
    }

    @Test
    public void givenFooBarReturnsSetWithBar() throws Exception {
        Set<Word> convert = transformer.convert("foo bar");
        assertThat(convert, contains(wordFor(FOO), wordFor("bar")));
    }

}
