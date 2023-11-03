package edu.project2;

import edu.project2.generators.EllerGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SampleTest {
    @Test
    public void basicThrowsTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Maze(-3, 5, new EllerGenerator()));


        assertThrows(
                IllegalArgumentException.class,
                () -> new Maze(3, -5, new EllerGenerator()));
    }
}
