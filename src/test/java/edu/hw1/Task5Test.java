package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("PalindromeDescendantCheckerTest")
    void PalindromeDescendantCheckerTests() {
        assertThat(Task5.isPalindromeDescendant(11211230))
                .isTrue();

        assertThat(Task5.isPalindromeDescendant(13001120))
                .isTrue();

        assertThat(Task5.isPalindromeDescendant(23336014))
                .isTrue();

        assertThat(Task5.isPalindromeDescendant(11))
                .isTrue();
    }
}
