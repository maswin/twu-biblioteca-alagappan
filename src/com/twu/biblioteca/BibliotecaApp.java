package com.twu.biblioteca;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.command.menu.*;
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

        Map<Integer, String> menuOptions = new HashMap<>();
        menuOptions.put(1, "List of Books");
        menuOptions.put(2, "Checkout Book");
        menuOptions.put(3, "CheckIn Book");
        menuOptions.put(4, "Quit");

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Harry Potter", "J.K.Rowling", 2005, new ArrayList<Integer>()));
        bookList.add(new Book(2, "2 States", "Chetan Bhagat", 2010, new ArrayList<Integer>()));
        bookList.add(new Book(3, "2 States", "Chetan Bhagat", 2010, new ArrayList<Integer>()));
        Library library = new Library(bookList, bookList);


        Map<Integer, MenuCommand> menuCommands = new HashMap<>();
        menuCommands.put(1, new DisplayBooksCommand(bibliotecaView, library));
        menuCommands.put(2, new CheckOutBookCommand(bibliotecaView, library));
        menuCommands.put(3, new CheckInBookCommand(bibliotecaView, library));
        menuCommands.put(4, new QuitCommand());


        Menu menu = new Menu(menuOptions, menuCommands);
        MenuView menuView = new MenuView(menu, outputWriter, inputReader);
        Biblioteca biblioteca = new Biblioteca(library, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
    }

}
