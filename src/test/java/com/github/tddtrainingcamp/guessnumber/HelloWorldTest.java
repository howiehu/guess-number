package com.github.tddtrainingcamp.guessnumber;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class HelloWorldTest {

    @Test
    public void demo_test() {
        assertThat("Hello World", equalTo("Hello World"));
    }

    @Test
    public void should_be_mock() {
        HelloWorld helloWorld = mock(HelloWorld.class);
        when(helloWorld.beenCalled()).thenReturn("Hello World");

        assertThat(helloWorld.beenCalled(), equalTo("Hello World"));
    }
}
