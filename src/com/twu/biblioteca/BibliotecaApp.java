package com.twu.biblioteca;

import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.model.Books.Copy;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.command.menu.*;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookView;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        OutputWriter outputWriter = new OutputWriter(System.out);
        InputReader inputReader = new InputReader(System.in);
        BookView bookView = new BookView(outputWriter, inputReader);

        Map<Integer, String> menuOptions = new HashMap<>();
        menuOptions.put(1, "List of Books");
        menuOptions.put(2, "Checkout Book");
        menuOptions.put(3, "CheckIn Book");
        menuOptions.put(4, "Quit");

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Harry Potter", "J.K.Rowling", 2005,
                new HashSet<>(Arrays.asList(new Copy(1234, false)))));
        bookList.add(new Book(2, "2 States", "Chetan Bhagat", 2010,
                new HashSet<>(Arrays.asList(new Copy(2345, false), new Copy(6789, false)))));
        bookList.add(new Book(3, "Half Girl Friend", "Chetan Bhagat", 2014,
                new HashSet<>(Arrays.asList(new Copy(3457, false), new Copy(7890, false)))));
        Library library = new Library(bookList);


        Map<Integer, MenuCommand> menuCommands = new HashMap<>();
        menuCommands.put(1, new DisplayBooksCommand(bookView, library));
        menuCommands.put(2, new CheckOutBookCommand(bookView, library));
        menuCommands.put(3, new CheckInBookCommand(bookView, library));
        menuCommands.put(4, new QuitCommand());


        Menu menu = new Menu(menuOptions, menuCommands);
        MenuView menuView = new MenuView(menu, outputWriter, inputReader);
        Biblioteca biblioteca = new Biblioteca(menuOptions, menuView, new ConsoleView("Welcome to Bibilioteca !!", outputWriter, inputReader));
        biblioteca.start();
    }

}
