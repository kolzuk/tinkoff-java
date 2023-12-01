package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class Task4Test {
    static Arguments[] wordsSource() {
        return new Arguments[]{
                Arguments.of("", false),
                Arguments.of("asd!asd", true),
                Arguments.of("asd1@", true),
                Arguments.of("dddd", false),
                Arguments.of("~", true)
        };
    };


    @ParameterizedTest
    @MethodSource("wordsSource")
    public void BasicTest(String input, boolean ans) {
        assertThat(Task4.IsValidPassword(input))
                .isEqualTo(ans);
    }
}
