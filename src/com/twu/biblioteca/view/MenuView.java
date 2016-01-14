package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.command.menu.InvalidCommand;
import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.model.Role;

import java.util.HashSet;
import java.util.Map;

public class MenuView {
    private Menu menu;
    private OutputWriter outputWriter;
    private InputReader inputReader;

    public MenuView(Menu menu, OutputWriter outputWriter, InputReader inputReader) {
        this.menu = menu;
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

    public MenuCommand getMenuOption() {
        String menuOptionId = inputReader.read();
        if(menu.containsCommand(menuOptionId)) {
            return menu.getCommand(menuOptionId);
        } else {
            return new InvalidCommand(this, new HashSet<Role>());
        }
    }

    public void displayInvalidOption() {
        outputWriter.println("Select a valid option!");
    }
}
