package com.twu.biblioteca.controller;

import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;

import java.util.Map;

public class BibliotecaController {
    private Map<Integer, String> menuOptions;
    private ConsoleView consoleView;
    private MenuView menuView;

    public BibliotecaController(Map<Integer, String> menuOptions, MenuView menuView, ConsoleView consoleView) {
        this.menuOptions = menuOptions;
        this.consoleView = consoleView;
        this.menuView = menuView;
    }

    public void start() {
        printWelcomeMessage();
        MenuCommand command;
        do {
            menuView.displayMenu(menuOptions);
            command = menuView.getMenuOption();
            try {
                command.performCommand();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!(command instanceof QuitCommand));
    }

    private void printWelcomeMessage() {
        consoleView.printWelcomeMessage();
    }
}
