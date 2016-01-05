package com.twu.biblioteca;

import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTest {

    private BibliotecaView bibliotecaView;
    private MenuView menuView;

    @Before
    public void setUp() throws Exception {
        bibliotecaView = Mockito.mock(BibliotecaView.class);
        menuView = Mockito.mock(MenuView.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        Biblioteca biblioteca = new Biblioteca(new ArrayList<Book>(), bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        List<Book> books = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(books, bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
        verify(menuView).displayMenu();
    }

    @Test
    public void shouldDisplayListOfBooksAfterChoosingMenuOptionOne() {
        List<Book> books = new ArrayList<>();
        when(menuView.getMenuOption()).thenReturn(1);
        Biblioteca biblioteca = new Biblioteca(books, bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printBooks(books);
    }

}
