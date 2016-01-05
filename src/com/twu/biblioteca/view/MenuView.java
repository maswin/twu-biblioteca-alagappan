package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.OutputWriter;

public class MenuView {
    private OutputWriter outputWriter;

    public MenuView(OutputWriter outputWriter) {

        this.outputWriter = outputWriter;
    }

    public void displayMenu() {
        outputWriter.println("Menu Options :");
        outputWriter.println("1. List Books");
    }
}
