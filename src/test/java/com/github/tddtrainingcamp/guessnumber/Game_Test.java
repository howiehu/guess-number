package com.github.tddtrainingcamp.guessnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Game_Test {

    @Mock
    private BufferedReader reader;

    @Mock
    private PrintStream out;

    @Mock
    private AnswerGenerator answer;

    @Mock
    Guess guess;


    @Test
    public void welcome_when_start() throws IOException {

        when(answer.generate()).thenReturn("1234");

        when(reader.readLine()).thenReturn("1234");

        when(guess.compare("1234", "1234")).thenReturn("4A0B");

        game().start();

        verifyInOrder();
    }

    @Test
    public void congratulations_when_match_in_1st_turn() throws IOException {

        when(answer.generate()).thenReturn("1234");

        when(reader.readLine()).thenReturn("1234");

        when(guess.compare("1234", "1234")).thenReturn("4A0B");

        game().start();

        InOrder inOrder = verifyInOrder();
        inOrder.verify(out).println("Congratulations!");
    }

    @Test
    public void congratulations_when_match_in_round() throws IOException {

        when(answer.generate()).thenReturn("1234");

        when(reader.readLine())
                .thenReturn("5678")
                .thenReturn("1234");

        when(guess.compare("1234", "5678")).thenReturn("0A0B");
        when(guess.compare("1234", "1234")).thenReturn("4A0B");

        game().start();

        InOrder inOrder = verifyInOrder();
        inOrder.verify(out).println("0A0B");
        inOrder.verify(out).println("Please input your number(5):");
        inOrder.verify(out).println("Congratulations!");
    }

    @Test
    public void congratulations_when_match_in_end() throws IOException {

        when(answer.generate()).thenReturn("1234");

        when(reader.readLine())
                .thenReturn("5678")
                .thenReturn("1678")
                .thenReturn("1278")
                .thenReturn("1248")
                .thenReturn("1243")
                .thenReturn("1234");

        when(guess.compare("1234", "5678")).thenReturn("0A0B");
        when(guess.compare("1234", "1678")).thenReturn("1A0B");
        when(guess.compare("1234", "1278")).thenReturn("2A0B");
        when(guess.compare("1234", "1248")).thenReturn("2A1B");
        when(guess.compare("1234", "1243")).thenReturn("2A2B");
        when(guess.compare("1234", "1234")).thenReturn("4A0B");

        game().start();

        InOrder inOrder = verifyInOrder();
        inOrder.verify(out).println("0A0B");
        inOrder.verify(out).println("Please input your number(5):");
        inOrder.verify(out).println("1A0B");
        inOrder.verify(out).println("Please input your number(4):");
        inOrder.verify(out).println("2A0B");
        inOrder.verify(out).println("Please input your number(3):");
        inOrder.verify(out).println("2A1B");
        inOrder.verify(out).println("Please input your number(2):");
        inOrder.verify(out).println("2A2B");
        inOrder.verify(out).println("Please input your number(1):");
        inOrder.verify(out).println("Congratulations!");
    }

    @Test
    public void game_over_when_not_match_in_end() throws IOException {

        when(answer.generate()).thenReturn("1234");

        when(reader.readLine())
                .thenReturn("5678")
                .thenReturn("1678")
                .thenReturn("1278")
                .thenReturn("1248")
                .thenReturn("1243")
                .thenReturn("1245");

        when(guess.compare("1234", "5678")).thenReturn("0A0B");
        when(guess.compare("1234", "1678")).thenReturn("1A0B");
        when(guess.compare("1234", "1278")).thenReturn("2A0B");
        when(guess.compare("1234", "1248")).thenReturn("2A1B");
        when(guess.compare("1234", "1243")).thenReturn("2A2B");
        when(guess.compare("1234", "1245")).thenReturn("2A1B");

        game().start();

        InOrder inOrder = verifyInOrder();
        inOrder.verify(out).println("0A0B");
        inOrder.verify(out).println("Please input your number(5):");
        inOrder.verify(out).println("1A0B");
        inOrder.verify(out).println("Please input your number(4):");
        inOrder.verify(out).println("2A0B");
        inOrder.verify(out).println("Please input your number(3):");
        inOrder.verify(out).println("2A1B");
        inOrder.verify(out).println("Please input your number(2):");
        inOrder.verify(out).println("2A2B");
        inOrder.verify(out).println("Please input your number(1):");
        inOrder.verify(out).println("Game Over");
    }

    private Game game() {
        return new Game(reader, out, answer, guess);
    }

    private InOrder verifyInOrder() {
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
        return inOrder;
    }
}
