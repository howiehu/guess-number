package com.github.tddtrainingcamp.guessnumber;

import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class Game_Test {

    @Test
    public void welcome_when_start() throws IOException {

        BufferedReader reader = mock(BufferedReader.class);
        PrintStream out = mock(PrintStream.class);
        Game game = new Game(reader, out);

        game.start();

        InOrder inOrder = inOrder(out);

        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println();
        inOrder.verify(out).println("Please input your number(6):");
    }
}
