package com.twu.biblioteca;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static void main(String[] args) {
        OutputWriter outputWriter = new OutputWriter(System.out);
        InputReader inputReader = new InputReader(System.in);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to Biblioteca !!",outputWriter, inputReader);
        MenuView menuView = new MenuView(outputWriter, inputReader);
        Map<Integer, String> menuOptions = new HashMap<>();

        menuOptions.put(1, "List of Books");
        menuOptions.put(2, "Quit");
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(0, "Harry Potter", "J.K.Rowling", 2005, true));
        bookList.add(new Book(0, "2 States", "Chetan Bhagat", 2010, true));
        Books books = new Books(bookList);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
    }
}
