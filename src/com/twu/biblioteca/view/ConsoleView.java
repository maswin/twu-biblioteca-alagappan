package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;

public class ConsoleView {
    private final OutputWriter outputWriter;
    private InputReader inputReader;

    public ConsoleView(OutputWriter outputWriter, InputReader inputReader) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void printWelcomeMessage() {
        outputWriter.println("Welcome to Bibilioteca App !!");
    }

    public String getLibraryNumber() {
        outputWriter.println("Enter Your Library Number");
        return inputReader.read();
    }

    public String getPassword() {
        outputWriter.println("Enter Your Password");
        return inputReader.read();
    }

    public void printInvalidLoginMessage() {
        outputWriter.println("Invalid Login Credentials !!");
    }
}
