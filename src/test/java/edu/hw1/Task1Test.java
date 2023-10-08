package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Video Length Function Right Tests")
    void videoLengthRightTests() {
        assertThat(Task1.minutesToSeconds("10:10"))
                .isEqualTo(610);

        assertThat(Task1.minutesToSeconds("05:02"))
                .isEqualTo(302);

        assertThat(Task1.minutesToSeconds("00:01"))
                .isEqualTo(1);

        assertThat((Task1.minutesToSeconds("00:00")))
                .isEqualTo(0);

        assertThat((Task1.minutesToSeconds("100:59")))
                .isEqualTo(6059);
    }

    @Test
    @DisplayName("Video Length Function Wrong Tests")
    void VideoLengthWrongTests() {
        assertThat(Task1.minutesToSeconds("10:99"))
                .isEqualTo(-1);

        assertThat(Task1.minutesToSeconds("05:60"))
                .isEqualTo(-1);
    }
}
