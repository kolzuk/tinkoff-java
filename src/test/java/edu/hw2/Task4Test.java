package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Nested test")
    void NestedTest() {
        class A {
            public CallingInfo callingInfo;
            public void Foo() {
                class B {
                    public void Foo1() {
                        callingInfo = Task4.callingInfo();
                    }
                }
                B b = new B();
                b.Foo1();
            }
        }

        A a = new A();

        a.Foo();

        assertThat(a.callingInfo.className())
                .isEqualTo("B");
        assertThat(a.callingInfo.methodName())
                .isEqualTo("Foo1");
    }
}
