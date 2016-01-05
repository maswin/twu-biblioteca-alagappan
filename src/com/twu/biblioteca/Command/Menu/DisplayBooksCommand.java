package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.view.BibliotecaView;

import java.util.List;

public class DisplayBooksCommand implements MenuCommand {

    private final BibliotecaView bibliotecaView;
    private final List<Book> books;

    public DisplayBooksCommand(BibliotecaView bibliotecaView, List<Book> books) {
        this.bibliotecaView = bibliotecaView;
        this.books = books;
    }

    @Override
    public void performCommand() {
        bibliotecaView.printBooks(books);
    }
}
