package com.twu.biblioteca;

import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTest {

    private BibliotecaView bibliotecaView;
    private MenuView menuView;
    private Map<Integer, String> menuOptions;

    @Before
    public void setUp() throws Exception {
        bibliotecaView = Mockito.mock(BibliotecaView.class);
        menuView = Mockito.mock(MenuView.class);
        menuOptions = new HashMap<>();
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        Biblioteca biblioteca = new Biblioteca(new ArrayList<Book>(), menuOptions, bibliotecaView, menuView);
        when(menuView.getMenuOption()).thenReturn(2);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        List<Book> books = new ArrayList<>();
        when(menuView.getMenuOption()).thenReturn(2);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
        verify(menuView).displayMenu(menuOptions);
    }

    @Test
    public void shouldDisplayListOfBooksAfterChoosingMenuOptionOne() {
        List<Book> books = new ArrayList<>();
        when(menuView.getMenuOption()).thenReturn(1,2);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printBooks(books);
    }

    @Test
    public void displayInvalidMenuOptionWhenOptionNotInListIsGivenAsInput() {
        List<Book> books = new ArrayList<>();
        when(menuView.getMenuOption()).thenReturn(13,2);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        verify(menuView).displayInvalidOption();
    }

    @Test
    public void checkoutAvailableBookAndDisplaySuccessMessage() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(0, "book1", "author1", 1234, true));
        when(menuView.getMenuOption()).thenReturn(3,2);

        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        assertEquals(0, books.size());
        verify(bibliotecaView).printSuccessfulCheckoutMessage();
    }

    @Test
    public void showFailureMessageOnTryingToCheckoutUnAvailableBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "book1", "author1", 1234, true));
        when(menuView.getMenuOption()).thenReturn(3,2);

        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        assertEquals(1, books.size());
        verify(bibliotecaView).printUnSuccessfulCheckoutMessage();
    }
}
