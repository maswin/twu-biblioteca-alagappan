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

    public void displayMenu(Map<Integer, String> menuOptions) {
        outputWriter.println("menu Options :");
        for(Map.Entry<Integer, String> menuOption : menuOptions.entrySet()){
            outputWriter.println(menuOption.getKey()+" "+menuOption.getValue());
        }
    }

    public int getMenuOption() {
        return Integer.parseInt(inputReader.read());
    }

    public void displayInvalidOption() {
        outputWriter.println("Select a valid option!");
    }
}
