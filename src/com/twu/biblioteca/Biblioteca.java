package com.twu.biblioteca;

import com.twu.biblioteca.view.BibliotecaView;

import java.util.List;

public class Biblioteca {
    private List<Book> books;
    private BibliotecaView bibliotecaView;

    public Biblioteca(List<Book> books, BibliotecaView bibliotecaView) {
        this.books = books;
        this.bibliotecaView = bibliotecaView;
    }

    public void start() {
        printWelcomeMessage();
        displayBooks();
    }

    private void displayBooks() {
        bibliotecaView.printBooks(books);
    }

    private void printWelcomeMessage() {
        bibliotecaView.printWelcomeMessage();
    }
}
