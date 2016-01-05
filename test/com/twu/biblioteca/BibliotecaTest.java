package com.twu.biblioteca;

import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

//    @Test
//    public void shouldDisplayListOfBooksAfterWelcomeMessage() {
//        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
//        List<Book> books = new ArrayList<>();
//        Biblioteca biblioteca = new Biblioteca(books, bibliotecaView);
//        biblioteca.start();
//        verify(bibliotecaView).printBooks(books);
//    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        List<Book> books = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(books, bibliotecaView, menuView);
        biblioteca.start();
        verify(menuView).displayMenu();
    }
}
