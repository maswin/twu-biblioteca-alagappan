package com.twu.biblioteca;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.command.menu.*;
import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;

import java.util.*;

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
        Map<Book, Set<Integer>> borrowedBooks = new HashMap<>();
        bookList.add(new Book(1, "Harry Potter", "J.K.Rowling", 2005, new HashSet<>(Arrays.asList(1234))));
        bookList.add(new Book(2, "2 States", "Chetan Bhagat", 2010, new HashSet<>(Arrays.asList(2345, 6789))));
        bookList.add(new Book(3, "Half Girl Friend", "Chetan Bhagat", 2014, new HashSet<>(Arrays.asList(3457, 7890))));
        Library library = new Library(bookList, borrowedBooks);


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
