package edu.hw3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] parenthesesSource() {
        return new Arguments[]{
                Arguments.of("()", new String[] {"()"}),
                Arguments.of("()()()"
                        , new String[] {"()", "()", "()"}),
                Arguments.of("((()))(())()()(()())"
                        , new String[] {"((()))", "(())", "()", "()", "(()())"}),
                Arguments.of("((())())(()(()()))"
                        , new String[] {"((())())", "(()(()()))"})
        };
    }


    @ParameterizedTest
    @MethodSource("parenthesesSource")
    public void BasicTest(String input, String[] ans) {
        assertThat(Task2.clusterize(input))
                .isEqualTo(ans);
    }
}
