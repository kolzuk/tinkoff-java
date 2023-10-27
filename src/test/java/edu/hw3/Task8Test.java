package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    public void BasicTest() {
        var myOwnIterator = new BackwardIterator<>(List.of(1, 2, 3));

        assertThat(myOwnIterator.hasNext()).isTrue();
        assertThat(myOwnIterator.next()).isEqualTo(3);

        assertThat(myOwnIterator.hasNext()).isTrue();
        assertThat(myOwnIterator.next()).isEqualTo(2);

        assertThat(myOwnIterator.hasNext()).isTrue();
        assertThat(myOwnIterator.next()).isEqualTo(1);

        assertThat(myOwnIterator.hasNext()).isFalse();
    }
}
