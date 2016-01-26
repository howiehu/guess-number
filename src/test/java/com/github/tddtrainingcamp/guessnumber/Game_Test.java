package com.github.tddtrainingcamp.guessnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Game_Test {

    @Mock
    private BufferedReader reader;

    @Mock
    private PrintStream out;

    @Test
    public void welcome_when_start() throws IOException {

        when(reader.readLine()).thenReturn("1234");

        game().start();

        verifyInOrder();
    }

    @Test
    public void congratulations_when_match_at_1st_run() throws IOException {

        when(reader.readLine()).thenReturn("1234");

        game().start();

        InOrder inOrder = verifyInOrder();
        inOrder.verify(out).println("Congratulations!");
    }

    private Game game() {
        return new Game(reader, out);
    }

    private InOrder verifyInOrder() {
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println();
        inOrder.verify(out).println("Please input your number(6):");
        return inOrder;
    }
}
