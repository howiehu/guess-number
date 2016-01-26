package com.github.tddtrainingcamp.guessnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {

    private BufferedReader reader;
    private PrintStream out;
    private Guess guess;
    private String answer;
    private int remain = 6;

    public Game(BufferedReader reader, PrintStream out, AnswerGenerator answer, Guess guess) {

        this.reader = reader;
        this.out = out;
        this.guess = guess;
        this.answer = answer.generate();
    }

    public void start() throws IOException {
        out.println("Welcome!");
        newTurn();
    }

    private void run() throws IOException {
        String input = reader.readLine();

        String result = guess.compare(answer, input);

        if (remain == 0) {
            out.println("Game Over");
        } else if (result.equals("4A0B")) {
            out.println("Congratulations!");
        } else {
            remain--;
            out.println(result);
            newTurn();
        }
    }

    private void newTurn() throws IOException {
        out.println("Please input your number(" + remain + "):");
        run();
    }
}
