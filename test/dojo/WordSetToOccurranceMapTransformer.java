package dojo;

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
    public void givenLine10_andWordSetFooBar_returnMapKeysFooAndBarToValues10() throws Exception {
        Map<Long, Set<Word>> wordSetMap = new HashMap<>();
        wordSetMap.put(10L, new HashSet<>(asList(new Word("foo"), new Word("bar"))));

        Map<Word, List<Long>> map = transform(wordSetMap);
        assertThat(map.get(new Word("foo")), contains(10L));
    }

    private Map<Word, List<Long>> transform(Map<Long, Set<Word>> wordSetMap) {
        SortedMap<Word, List<Long>> result = new TreeMap<>();

        for (Map.Entry<Long, Set<Word>> longSetEntry : wordSetMap.entrySet()) {
            for (Word word : longSetEntry.getValue()) {
                List<Long> list = result.getOrDefault(word, new LinkedList<>());
                list.add(longSetEntry.getKey());
                result.put(word, list);
            }
        }

        return result;
    }
}
