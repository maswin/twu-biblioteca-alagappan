package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;

public class MenuView {
    private OutputWriter outputWriter;
    private InputReader inputReader;

    public MenuView(OutputWriter outputWriter, InputReader inputReader) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void displayMenu() {
        outputWriter.println("Menu Options :");
        outputWriter.println("1. List Books");
    }

    public int getMenuOption() {
        return Integer.parseInt(inputReader.read());
    }

    public void displayInvalidOption() {
        outputWriter.println("Select a valid option!");
    }
}
