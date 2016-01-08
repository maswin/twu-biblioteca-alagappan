package com.twu.biblioteca.controller;

import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookView;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTest {

    private BookView bookView;
    private MenuView menuView;
    private ConsoleView consoleView;
    private Library library;
    private Map<Integer, String> menuOptions;

    @Before
    public void setUp() throws Exception {
        bookView = Mockito.mock(BookView.class);
        menuView = Mockito.mock(MenuView.class);
        consoleView = Mockito.mock(ConsoleView.class);
        menuOptions = new HashMap<>();
        library = Mockito.mock(Library.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        Biblioteca biblioteca = new Biblioteca(menuOptions, menuView, consoleView);
        when(menuView.getMenuOption()).thenReturn(new QuitCommand());
        biblioteca.start();
        verify(consoleView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        when(menuView.getMenuOption()).thenReturn(new QuitCommand());
        Biblioteca biblioteca = new Biblioteca(menuOptions, menuView, consoleView);
        biblioteca.start();
        verify(consoleView).printWelcomeMessage();
        verify(menuView).displayMenu(menuOptions);
    }

}
