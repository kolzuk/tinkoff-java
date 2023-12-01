package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    public void Test1() {
        LocalDate[] testDate = Task2.findAll13Fridays(1925);

        assertThat(testDate).contains(
                LocalDate.of(1925, 2, 13),
                LocalDate.of(1925, 3, 13),
                LocalDate.of(1925, 11, 13));
    }

    @Test
    public void Test2() {
        LocalDate[] testDate = Task2.findAll13Fridays(2024);

        assertThat(testDate).contains(
                LocalDate.of(2024, 9, 13),
                LocalDate.of(2024, 12, 13));
    }

    @Test
    public void NextFridayTest() {
        LocalDate testDate = LocalDate.of(2024, 8, 10);
        assertThat(Task2.findNext13Friday(testDate))
                .isEqualTo(LocalDate.of(2024, 9, 13));
    }
}
