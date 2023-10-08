package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Count digits test")
    void DigitsCounterTest() {
        assertThat(Task2.countDigits(10))
                .isEqualTo(2);

        assertThat(Task2.countDigits(0))
                .isEqualTo(1);


        assertThat(Task2.countDigits(-299))
                .isEqualTo(3);


        assertThat(Task2.countDigits(11111))
                .isEqualTo(5);
    }
}
