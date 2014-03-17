package dojo;

import dojo.concordance.Word;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * @author arkangelofkaos
 */
public class WordSetToOccurranceMapTransformer {

    @Test
    public void flipMapOfLineNumberToWords() throws Exception {
        Map<Long, Set<Word>> wordSetMap = new HashMap<>();
        wordSetMap.put(10L, new HashSet<>(asList(new Word("foo"), new Word("bar"))));

        Map<Word, List<Long>> map = flipMap(wordSetMap);
        assertThat(map.get(new Word("foo")), contains(10L));
    }

    private Map<Word, List<Long>> flipMap(Map<Long, Set<Word>> wordSetMap) {
        SortedMap<Word, List<Long>> wordToLineNumberMap = new TreeMap<>();

        for (Map.Entry<Long, Set<Word>> lineNumberToWords : wordSetMap.entrySet()) {
            for (Word word : lineNumberToWords.getValue()) {
                List<Long> list = wordToLineNumberMap.getOrDefault(word, new LinkedList<>());
                list.add(lineNumberToWords.getKey());

                wordToLineNumberMap.put(word, list);
            }
        }

        return wordToLineNumberMap;
    }
}
