package com.twu.biblioteca.controller;

import com.twu.biblioteca.Exception.UserOperationException;
import com.twu.biblioteca.Menu;
import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;

public class BibliotecaController {
    private Menu menu;
    private Authenticator authenticator;
    private ConsoleView consoleView;
    private MenuView menuView;

    public BibliotecaController(Menu menu, Authenticator authenticator, MenuView menuView, ConsoleView consoleView) {
        this.menu = menu;
        this.authenticator = authenticator;
        this.consoleView = consoleView;
        this.menuView = menuView;
    }

    public void start() {
        printWelcomeMessage();
        try {
            User loggedInUser = performLoginOperation();
            startUserInteraction(loggedInUser);
        } catch (UserOperationException e) {
            consoleView.printInvalidLoginMessage();
        }
    }

    private User performLoginOperation() {
        String libraryNumber = consoleView.getLibraryNumber();
        String password = consoleView.getPassword();
        return authenticator.authenticate(libraryNumber, password);
    }

    private void startUserInteraction(User user) {
        MenuCommand command;
        do {
            menuView.displayMenu(menu.getMenuOptions());
            command = menuView.getMenuOption();
            try {
                command.performCommand(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!(command instanceof QuitCommand));
    }

    private void printWelcomeMessage() {
        consoleView.printWelcomeMessage();
    }
}
