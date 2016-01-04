package com.twu.biblioteca;

import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.view.BibliotecaView;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        OutputWriter outputWriter = new OutputWriter(System.out);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to Biblioteca !!",outputWriter);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K.Rowling", 2005));
        books.add(new Book("2 States", "Chetan Bhagat", 2010));
        Biblioteca biblioteca = new Biblioteca(books, bibliotecaView);
        biblioteca.start();
    }
}
