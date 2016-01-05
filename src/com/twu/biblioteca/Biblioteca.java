package com.twu.biblioteca;

import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;

import java.util.List;

public class Biblioteca {
    private List<Book> books;
    private BibliotecaView bibliotecaView;
    private MenuView menuView;

    public Biblioteca(List<Book> books, BibliotecaView bibliotecaView, MenuView menuView) {
        this.books = books;
        this.bibliotecaView = bibliotecaView;
        this.menuView = menuView;
    }


    public void start() {
        printWelcomeMessage();
        menuView.displayMenu();
        int option = menuView.getMenuOption();
        performOperation(option);
    }

    private void performOperation(int option) {
        switch (option) {
            case 1 : bibliotecaView.printBooks(books);
                break;
        }
    }

    private void printWelcomeMessage() {
        bibliotecaView.printWelcomeMessage();
    }
}
