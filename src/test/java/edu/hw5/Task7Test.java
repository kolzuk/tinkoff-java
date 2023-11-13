package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class Task7Test {
    @Test
    public void firstPatternTest() {
        assertThat(Task7.firstMatch("1101"))
                .isTrue();
        assertThat(Task7.firstMatch("11012"))
                .isFalse();
        assertThat(Task7.firstMatch("10"))
                .isFalse();
        assertThat(Task7.firstMatch(""))
                .isFalse();
    }

    @Test
    public void secondPatternTest() {
        assertThat(Task7.secondMatch("10101010101"))
                .isTrue();
        assertThat(Task7.secondMatch("000110"))
                .isTrue();
        assertThat(Task7.secondMatch("1"))
                .isTrue();
        assertThat(Task7.secondMatch("10010"))
                .isFalse();
        assertThat(Task7.secondMatch(""))
                .isFalse();
    }

    @Test
    public void thirdPatternTest() {
        assertThat(Task7.thirdMatch("1"))
                .isTrue();
        assertThat(Task7.thirdMatch("011"))
                .isTrue();
        assertThat(Task7.thirdMatch("11"))
                .isTrue();
        assertThat(Task7.thirdMatch("111111"))
                .isFalse();
        assertThat(Task7.thirdMatch(""))
                .isFalse();
    }
}
