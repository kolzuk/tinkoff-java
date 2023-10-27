package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    static Arguments[] wordsSource() {
        return new Arguments[]{
                Arguments.of(new String[] {"a", "bb", "a", "bb"},
                        Map.of("bb", 2, "a", 2)),

                Arguments.of(new String[] {"this", "and", "that", "and"},
                        Map.of("that", 1, "and", 2, "this", 1))
        };
    };


    @ParameterizedTest
    @MethodSource("wordsSource")
    public void BasicTest(String[] input, Map<String, Integer> ans) {
        assertThat(Task3.freqDict(input))
                .isEqualTo(ans);
    }
}
