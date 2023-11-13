package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    static Arguments[] wordsSource() {
        return new Arguments[]{
                Arguments.of("abc", "achfdbaabgabcaabg", true),
                Arguments.of("aytal", "baaaaatttaally", false)
        };
    };


    @ParameterizedTest
    @MethodSource("wordsSource")
    public void BasicTest(String S, String T, boolean ans) {
        assertThat(Task6.isSubSequence(S, T))
                .isEqualTo(ans);
    }
}
