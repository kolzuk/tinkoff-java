package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    static Arguments[] wordsSource() {
        return new Arguments[]{
                Arguments.of("2020-10-10", LocalDate.of(2020, 10, 10)),
                Arguments.of("2020-12-2", LocalDate.of(2020, 12, 2)),
                Arguments.of("1/3/1976", LocalDate.of(1976, 3, 1)),
                Arguments.of("1/3/20", LocalDate.of(20, 3, 1)),
                Arguments.of("tomorrow", LocalDate.now().plusDays(1)),
                Arguments.of("today", LocalDate.now()),
                Arguments.of("yesterday", LocalDate.now().minusDays(1)),
                Arguments.of("1 day ago", LocalDate.now().minusDays(1)),
                Arguments.of("2234 day ago", LocalDate.now().minusDays(2234)),
        };
    };


    @ParameterizedTest
    @MethodSource("wordsSource")
    public void BasicTest(String input, LocalDate ans) {
        assertThat(Task3.parseDate(input).get())
                .isEqualTo(ans);
    }
}
