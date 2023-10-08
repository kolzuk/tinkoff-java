package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Fix String Test")
    void fixStringTest() {
        assertThat(Task4.fixString("123456"))
                .isEqualTo("214365");

        assertThat(Task4.fixString("hTsii  s aimex dpus rtni.g"))
                .isEqualTo("This is a mixed up string.");

        assertThat(Task4.fixString("badce"))
                .isEqualTo("abcde");

        assertThat(Task4.fixString("s"))
                .isEqualTo("s");

        assertThat(Task4.fixString("abc"))
                .isEqualTo("bac");
    }
}
