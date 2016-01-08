package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;

public class ConsoleView {
    private final String welcomeMessage;
    private final OutputWriter outputWriter;
    private InputReader inputReader;

    public ConsoleView(String welcomeMessage, OutputWriter outputWriter, InputReader inputReader) {
        this.welcomeMessage = welcomeMessage;
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void printWelcomeMessage() {
        outputWriter.println(welcomeMessage);
    }
}
