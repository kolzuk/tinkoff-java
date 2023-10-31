package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    static Arguments[] testSource() {
        return new Arguments[]{
                Arguments.of(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                        "ASC",
                        new Object[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"}),

                Arguments.of(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
                        "DESC",
                        new Object[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"}),

                Arguments.of(new String[] {},
                        "DESC",
                        new Object[] {}),

                Arguments.of(null,
                        "DESC",
                        new Object[] {})
        };
    };

    @ParameterizedTest
    @MethodSource("testSource")
    public void BasicTest(String[] contacts, String orderInstruction, Object[] ans) {
        assertThat(Task5.parseContacts(contacts, orderInstruction))
                .isEqualTo(ans);
    }
}
