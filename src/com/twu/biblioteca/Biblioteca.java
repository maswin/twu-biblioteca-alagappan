package com.twu.biblioteca;

import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Biblioteca {
    private List<Book> books;
    private Map<Integer, String> menuOptions;
    private BibliotecaView bibliotecaView;
    private MenuView menuView;

    public Biblioteca(List<Book> books, Map<Integer, String> menuOptions, BibliotecaView bibliotecaView, MenuView menuView) {
        this.books = books;
        this.menuOptions = menuOptions;
        this.bibliotecaView = bibliotecaView;
        this.menuView = menuView;
    }


    public void start() {
        printWelcomeMessage();
        int option;
        do {
            menuView.displayMenu(menuOptions);
            option = menuView.getMenuOption();
            performOperation(option);
        } while (option != 2);
    }

    private void performOperation(int option) {
        switch (option) {
            case 1 : bibliotecaView.printBooks(books);
                break;
            case 2 :
                break;
            case 3 : checkOutBook();
                break;
            default : menuView.displayInvalidOption();
                break;
        }
    }

    private void checkOutBook() {
        int bookId = bibliotecaView.getBookId();

        Optional<Book> foundBook = books.stream().filter(b -> b.isSameBookId(bookId)).findFirst();

        if(foundBook.isPresent()) {
            books.remove(foundBook.get());
            bibliotecaView.printSuccessfulCheckoutMessage();
        } else {
            bibliotecaView.printUnSuccessfulCheckoutMessage();
        }

    }

    private void printWelcomeMessage() {
        bibliotecaView.printWelcomeMessage();
    }
}
