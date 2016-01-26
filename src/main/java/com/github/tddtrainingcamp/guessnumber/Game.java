package com.github.tddtrainingcamp.guessnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {

    private BufferedReader reader;
    private PrintStream out;

    public Game(BufferedReader reader, PrintStream out) {

        this.reader = reader;
        this.out = out;
    }

    public void start() throws IOException {
        out.println("Welcome!");
        out.println();
        out.println("Please input your number(6):");
    }
}
