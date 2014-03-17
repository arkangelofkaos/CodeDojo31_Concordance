package dojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arkangelofkaos
 */
public class Transformer {
    public static final String SEPARATOR_REGEX = " ";

    Set<Word> convert(String input) {
        HashSet<Word> words = new HashSet<>();
        String[] split = input.split(SEPARATOR_REGEX);
        for (String word : split) {
            words.add(new Word(word));
        }
        return words;
    }
}
