package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task1Test {
    static Arguments[] sessionTimeSource() {
        return new Arguments[] {
                Arguments.of(
                        new String[]
                                {"2022-04-01, 21:30 - 2022-04-02, 01:20",
                                        "2022-03-12, 20:20 - 2022-03-12, 23:50"},
                        13200)
        };
    }


    @ParameterizedTest
    @MethodSource("sessionTimeSource")
    public void BasicTest(String[] input, long averageTimeInSeconds) {
        assertThat(Task1.getAverageTimeOfSession(input).getSeconds())
                .isEqualTo(averageTimeInSeconds);
    }
}
