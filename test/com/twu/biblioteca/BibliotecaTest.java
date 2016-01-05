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
    private Books books;
    private Map<Integer, String> menuOptions;

    @Before
    public void setUp() throws Exception {
        bibliotecaView = Mockito.mock(BibliotecaView.class);
        menuView = Mockito.mock(MenuView.class);
        menuOptions = new HashMap<>();
        //List<Book> bookList = new ArrayList<>();
        books = Mockito.mock(Books.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        when(menuView.getMenuOption()).thenReturn(2);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        when(menuView.getMenuOption()).thenReturn(2);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
        verify(menuView).displayMenu(menuOptions);
    }

    @Test
    public void shouldDisplayListOfBooksAfterChoosingMenuOptionOne() {
        when(menuView.getMenuOption()).thenReturn(1,2);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printBooks(books.getAvailableBookList());
    }

    @Test
    public void displayInvalidMenuOptionWhenOptionNotInListIsGivenAsInput() {
        when(menuView.getMenuOption()).thenReturn(13,2);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        verify(menuView).displayInvalidOption();
    }

    @Test
    public void checkoutAvailableBookAndDisplaySuccessMessage() {
        when(menuView.getMenuOption()).thenReturn(3,2);
        when(bibliotecaView.getBookId()).thenReturn(3);
        when(books.findBookById(3)).thenReturn(new Book(1, "a", "b", 2011, true));

        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);
        biblioteca.start();

        verify(books).checkOut(3);
        verify(bibliotecaView).printSuccessfulCheckoutMessage();
    }

    @Test
    public void showFailureMessageOnTryingToCheckoutUnAvailableBook() {
        when(menuView.getMenuOption()).thenReturn(3,2);
        when(bibliotecaView.getBookId()).thenReturn(3);
        when(books.findBookById(3)).thenReturn(null);
        Biblioteca biblioteca = new Biblioteca(books, menuOptions, bibliotecaView, menuView);

        biblioteca.start();

        verify(bibliotecaView).printUnSuccessfulCheckoutMessage();
    }
}
