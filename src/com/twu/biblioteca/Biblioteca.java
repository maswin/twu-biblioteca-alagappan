package com.twu.biblioteca;

import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;

import java.util.Map;

public class Biblioteca {
    private Library library;
    private Map<Integer, String> menuOptions;
    private BibliotecaView bibliotecaView;
    private MenuView menuView;

    public Biblioteca(Library library, Map<Integer, String> menuOptions, BibliotecaView bibliotecaView, MenuView menuView) {
        this.library = library;
        this.menuOptions = menuOptions;
        this.bibliotecaView = bibliotecaView;
        this.menuView = menuView;
    }


    public void start() {
        printWelcomeMessage();
        MenuCommand command;
        do {
            menuView.displayMenu(menuOptions);
            command = menuView.getMenuOption();
            command.performCommand();
        } while (!(command instanceof QuitCommand));
    }

    private void printWelcomeMessage() {
        bibliotecaView.printWelcomeMessage();
    }
}
