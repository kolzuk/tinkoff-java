package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    static Arguments[] numberSource() {
        return new Arguments[]{
                Arguments.of(5, "V"),
                Arguments.of(1999, "MCMXCIX"),
                Arguments.of(25, "XXV"),
                Arguments.of(994, "CMXCIV"),
                Arguments.of(2, "II"),
                Arguments.of(12, "XII"),
                Arguments.of(16, "XVI"),
        };
    };


    @ParameterizedTest
    @MethodSource("numberSource")
    public void BasicTest(int num, String ans) {
        assertThat(Task4.convertToRoman(num))
                .isEqualTo(ans);
    }
}
