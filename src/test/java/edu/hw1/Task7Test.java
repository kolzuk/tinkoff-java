package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Right bit shift test")
    public void RightBitShiftTest() {
        assertThat(Task7.rotateRight(8, 1))
                .isEqualTo(4);
        assertThat(Task7.rotateRight(2, 2))
                .isEqualTo(2);
        assertThat(Task7.rotateRight(7, 100))
                .isEqualTo(7);
        assertThat(Task7.rotateRight(64, 2))
                .isEqualTo(16);
        assertThat(Task7.rotateRight(0, 100))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("Left bit shift test")
    public void LeftBitShiftTest() {
        assertThat(Task7.rotateLeft(16, 1))
                .isEqualTo(1);
        assertThat(Task7.rotateLeft(17, 2))
                .isEqualTo(6);
        assertThat(Task7.rotateLeft(15, 100))
                .isEqualTo(15);
        assertThat(Task7.rotateLeft(0, 100))
                .isEqualTo(0);
    }
}
