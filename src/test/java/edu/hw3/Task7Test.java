package edu.hw3;

import edu.hw3.task7.MyComparator;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    public void BasicTest() {
        Map<String, String> tree = new TreeMap<>(new MyComparator<String>());

        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();

    }
}
