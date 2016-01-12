package com.twu.biblioteca.controller;

import com.twu.biblioteca.Menu;
import com.twu.biblioteca.command.menu.QuitCommand;
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

public class BibliotecaControllerTest {

    private BookView bookView;
    private MenuView menuView;
    private Menu menu;
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
        menu = Mockito.mock(Menu.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        BibliotecaController bibliotecaController = new BibliotecaController(menu, menuView, consoleView);
        when(menuView.getMenuOption()).thenReturn(new QuitCommand());
        bibliotecaController.start();
        verify(consoleView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        when(menuView.getMenuOption()).thenReturn(new QuitCommand());
        BibliotecaController bibliotecaController = new BibliotecaController(menu, menuView, consoleView);
        bibliotecaController.start();
        verify(consoleView).printWelcomeMessage();
        verify(menuView).displayMenu(menuOptions);
    }

}
