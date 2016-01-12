package com.twu.biblioteca.controller;

import com.twu.biblioteca.Menu;
import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;

public class BibliotecaController {
    private Menu menu;
    private ConsoleView consoleView;
    private MenuView menuView;

    public BibliotecaController(Menu menu, MenuView menuView, ConsoleView consoleView) {
        this.menu = menu;
        this.consoleView = consoleView;
        this.menuView = menuView;
    }

    public void start() {
        printWelcomeMessage();
        MenuCommand command;
        do {
            menuView.displayMenu(menu.getMenuOptions());
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
