package edu.hw2;

import edu.hw2.task1.*;
import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Base Test")
    void BaseTest() {
        var callingInfo = Task4.callingInfo();

        assertThat(callingInfo.className())
                .isEqualTo("Task4Test");
        assertThat(callingInfo.methodName())
                .isEqualTo("BaseTest");
    }
}
