package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;

import java.util.Map;

public class MenuView {
    private OutputWriter outputWriter;
    private InputReader inputReader;

    public MenuView(OutputWriter outputWriter, InputReader inputReader) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void displayMenu(Map<String, String> menuOptions) {
        outputWriter.println("Menu Options :");
        outputWriter.println(String.format("%-10s %s", "Command","Description"));
        for(Map.Entry<String, String> menuOption : menuOptions.entrySet()){
            outputWriter.println(String.format("%-10s %s", menuOption.getKey(), menuOption.getValue()));
        }
    }

    public String getMenuOption() {
        outputWriter.println("Enter Menu Option :");
        return inputReader.read();
    }

    public void displayInvalidOption() {
        outputWriter.println("Select a valid option!");
    }
}
