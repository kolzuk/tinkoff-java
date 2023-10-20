package edu.hw2;

import edu.hw2.task1.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private static Stream<Arguments> provideParametersForSum() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(100, 5, 105),
                Arguments.of(-1, 5, 4)
        );
    }

    private static Stream<Arguments> provideParametersForMult() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(100, 5, 500),
                Arguments.of(-1, 5, -5)
        );
    }

    private static Stream<Arguments> provideParametersForExp() {
        return Stream.of(
                Arguments.of(2, 3, 8),
                Arguments.of(10, 5, 100000),
                Arguments.of(-1, 5, -1)
        );
    }

    private static Stream<Arguments> provideParametersForNegate() {
        return Stream.of(
                Arguments.of(2, -2),
                Arguments.of(0, 0),
                Arguments.of(-1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForSum")
    void SumTest(int a, int b, int ans) {
        var first = new Constant(a);
        var second = new Constant(b);

        var sum = new Addition(first, second);

        assertThat(sum.evaluate())
                .isEqualTo(ans);
    }

    @ParameterizedTest
    @MethodSource("provideParametersForMult")
    void MultTest(int a, int b, int ans) {
        var first = new Constant(a);
        var second = new Constant(b);

        var sum = new Multiplication(first, second);

        assertThat(sum.evaluate())
                .isEqualTo(ans);
    }

    @ParameterizedTest
    @MethodSource("provideParametersForExp")
    void ExponentTest(int a, int b, int ans) {
        var first = new Constant(a);
        var second = new Constant(b);

        var sum = new Exponent(first, second);

        assertThat(sum.evaluate())
                .isEqualTo(ans);
    }

    @ParameterizedTest
    @MethodSource("provideParametersForNegate")
    void NegateTest(int a, int ans) {
        var value = new Constant(a);

        var negateValue = new Negate(value);

        assertThat(negateValue.evaluate())
                .isEqualTo(ans);
    }
}
