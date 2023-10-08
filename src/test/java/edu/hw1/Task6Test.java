package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("")
    public void KaprekarTest() {
        assertThat(Task6.countK(8991))
                .isEqualTo(3);
        assertThat(Task6.countK(3524))
                .isEqualTo(3);
        assertThat(Task6.countK(6621))
                .isEqualTo(5);
        assertThat(Task6.countK(6554))
                .isEqualTo(4);
        assertThat(Task6.countK(1234))
                .isEqualTo(3);
    }
}
