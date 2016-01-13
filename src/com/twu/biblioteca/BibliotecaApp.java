package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.command.menu.*;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movies.Movie;
import com.twu.biblioteca.model.Users.Member;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.model.Users.Users;
import com.twu.biblioteca.view.BookView;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.MovieView;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        OutputWriter outputWriter = new OutputWriter(System.out);
        InputReader inputReader = new InputReader(System.in);
        BookView bookView = new BookView(outputWriter, inputReader);
        MovieView movieView = new MovieView(outputWriter, inputReader);
        ConsoleView consoleView = new ConsoleView(outputWriter, inputReader);

        Map<Integer, String> menuOptions = new HashMap<>();
        menuOptions.put(1, "List of Books");
        menuOptions.put(2, "CheckOut Book");
        menuOptions.put(3, "CheckIn Book");
        menuOptions.put(4, "List of Movies");
        menuOptions.put(5, "CheckOut Movie");
        menuOptions.put(6, "User Information");
        menuOptions.put(7, "Quit");

        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter", "J.K.Rowling", 2005,
                new HashSet<>(Arrays.asList(new Copy(1234, null)))));
        books.add(new Book(2, "2 States", "Chetan Bhagat", 2010,
                new HashSet<>(Arrays.asList(new Copy(2345, null), new Copy(6789, null)))));
        books.add(new Book(3, "Half Girl Friend", "Chetan Bhagat", 2014,
                new HashSet<>(Arrays.asList(new Copy(3457, null), new Copy(7890, null)))));


        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(11, "Jurassic park", "Steven Speilberg", 1994, 7,
                new HashSet<>(Arrays.asList(new Copy(5234, null))), "genre"));
        movies.add(new Movie(12, "Prestige", "Nolan", 2008, null,
                new HashSet<>(Arrays.asList(new Copy(5345, null), new Copy(5789, null))), "genre"));
        movies.add(new Movie(13, "Endhiran", "Shankar", 2012, 10,
                new HashSet<>(Arrays.asList(new Copy(5457, null), new Copy(5890, null))), "genre"));

        Library library = new Library(books, movies);


        Map<Integer, MenuCommand> menuCommands = new HashMap<>();
        menuCommands.put(1, new DisplayBooksCommand(bookView, library));
        menuCommands.put(2, new CheckOutBookCommand(bookView, library));
        menuCommands.put(3, new CheckInBookCommand(bookView, library));
        menuCommands.put(4, new DisplayMoviesCommand(movieView, library));
        menuCommands.put(5, new CheckOutMovieCommand(movieView, library));
        menuCommands.put(6, new PrintUserInformationCommand(consoleView));
        menuCommands.put(7, new QuitCommand());

        List<User> users = new ArrayList<>();
        users.add(new Member("123-4567", "password", "name", "abc@xyz.com", "12345678"));

        Users authenticator = new Users(users);

        Menu menu = new Menu(menuOptions, menuCommands);
        MenuView menuView = new MenuView(menu, outputWriter, inputReader);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, authenticator, menuView, consoleView);
        bibliotecaController.start();
    }

}
