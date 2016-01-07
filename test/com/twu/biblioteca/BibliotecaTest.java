package com.twu.biblioteca;

import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaView;
import com.twu.biblioteca.view.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTest {

    private BibliotecaView bibliotecaView;
    private MenuView menuView;
    private Library library;
    private Map<Integer, String> menuOptions;

    @Before
    public void setUp() throws Exception {
        bibliotecaView = Mockito.mock(BibliotecaView.class);
        menuView = Mockito.mock(MenuView.class);
        menuOptions = new HashMap<>();
        //List<Book> bookList = new ArrayList<>();
        library = Mockito.mock(Library.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        Biblioteca biblioteca = new Biblioteca(library, menuOptions, bibliotecaView, menuView);
        when(menuView.getMenuOption()).thenReturn(new QuitCommand());
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        when(menuView.getMenuOption()).thenReturn(new QuitCommand());
        Biblioteca biblioteca = new Biblioteca(library, menuOptions, bibliotecaView, menuView);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
        verify(menuView).displayMenu(menuOptions);
    }

}
