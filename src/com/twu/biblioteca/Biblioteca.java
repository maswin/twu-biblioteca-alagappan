package com.twu.biblioteca;

import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookView;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;

import java.util.Map;

public class Biblioteca {
    private Library library;
    private Map<Integer, String> menuOptions;
    private ConsoleView consoleView;
    private BookView bookView;
    private MenuView menuView;

    public Biblioteca(Library library, Map<Integer, String> menuOptions, BookView bookView, MenuView menuView, ConsoleView consoleView) {
        this.library = library;
        this.menuOptions = menuOptions;
        this.consoleView = consoleView;
        this.bookView = bookView;
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
