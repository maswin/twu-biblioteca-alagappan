package com.twu.biblioteca.controller;

import com.twu.biblioteca.Exception.UserOperationException;
import com.twu.biblioteca.Menu;
import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.model.Users.Users;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;

public class BibliotecaController {
    private Menu menu;
    private Users users;
    private ConsoleView consoleView;
    private MenuView menuView;

    public BibliotecaController(Menu menu, Users users, MenuView menuView, ConsoleView consoleView) {
        this.menu = menu;
        this.users = users;
        this.consoleView = consoleView;
        this.menuView = menuView;
    }

    public void start() {
        printWelcomeMessage();
        User loggedInUser = performLoginOperation();
        if(loggedInUser != null) {
            startUserInteraction(loggedInUser);
        } else {
            consoleView.printInvalidLoginMessage();
        }
    }

    private User performLoginOperation() {
        String libraryNumber = consoleView.getLibraryNumber();
        String password = consoleView.getPassword();
        try {
            return users.findUserByLibraryNumberAndPassword(libraryNumber, password);
        } catch (UserOperationException e) {
            return null;
        }
    }

    private void startUserInteraction(User user) {
        MenuCommand command;
        do {
            menuView.displayMenu(menu.getMenuOptions());
            command = menuView.getMenuOption();
            try {
                command.performCommand(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!(command instanceof QuitCommand));
    }

    private void printWelcomeMessage() {
        consoleView.printWelcomeMessage();
    }
}