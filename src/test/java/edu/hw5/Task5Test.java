package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    static Arguments[] wordsSource() {
        return new Arguments[]{
                Arguments.of("А123ВЕ777", true),
                Arguments.of("О777ОО177", true),
                Arguments.of("123АВЕ777", false),
                Arguments.of("А123ВГ77", false),
                Arguments.of("А123ВЕ7777", false)
        };
    };


    @ParameterizedTest
    @MethodSource("wordsSource")
    public void BasicTest(String input, boolean ans) {
        assertThat(Task5.IsValidSign(input))
                .isEqualTo(ans);
    }
}
