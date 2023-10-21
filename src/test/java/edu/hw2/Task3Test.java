package edu.hw2;

import edu.hw2.task2.*;
import edu.hw2.task3.FaultyConnection;
import edu.hw2.task3.FaultyConnectionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void Test1() {
        FaultyConnectionManager faultyConnectionManager = new FaultyConnectionManager();
        assertThat(faultyConnectionManager.getConnection().getClass())
                .isEqualTo(FaultyConnection.class);
    }
}
