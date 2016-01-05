package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;

import java.util.List;

public class MenuView {
    private OutputWriter outputWriter;
    private InputReader inputReader;

    public MenuView(OutputWriter outputWriter, InputReader inputReader) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void displayMenu(List<String> menuOptions) {
        outputWriter.println("Menu Options :");
        for(String menuOption : menuOptions){
            outputWriter.println(menuOption);
        }
    }

    public int getMenuOption() {
        return Integer.parseInt(inputReader.read());
    }

    public void displayInvalidOption() {
        outputWriter.println("Select a valid option!");
    }
}
