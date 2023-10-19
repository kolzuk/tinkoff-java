package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Is nestable tests")
    void isNestableTests() {
        assertThat(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}))
                .isTrue();

        assertThat(Task3.isNestable(new int[]{3, 1}, new int[]{4, 0}))
                .isTrue();

        assertThat(Task3.isNestable(new int[]{9, 9, 8}, new int[]{8, 9}))
                .isFalse();

        assertThat(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}))
                .isFalse();

        assertThat(Task3.isNestable(new int[]{}, new int[]{}))
                .isFalse();

        assertThat(Task3.isNestable(new int[]{1}, new int[]{}))
                .isFalse();

        assertThat(Task3.isNestable(new int[]{}, new int[]{1}))
                .isFalse();

        assertThat(Task3.isNestable(new int[]{1}, new int[]{1}))
                .isFalse();
    }
}
