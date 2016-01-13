package com.twu.biblioteca.controller;

import com.twu.biblioteca.Exception.UserOperationException;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.command.menu.QuitCommand;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.model.Users.Users;
import com.twu.biblioteca.view.ConsoleView;
import com.twu.biblioteca.view.MenuView;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.Mockito.*;

public class BibliotecaControllerTest {

    private MenuView menuView;
    private Menu menu;
    private ConsoleView consoleView;
    private Map<Integer, String> menuOptions;
    private Users users;

    @Before
    public void setUp() throws Exception {
        menuView = mock(MenuView.class);
        consoleView = mock(ConsoleView.class);
        menuOptions = new HashMap<>();
        menu = mock(Menu.class);
        users = mock(Users.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        BibliotecaController bibliotecaController = new BibliotecaController(menu, users, menuView, consoleView);
        MenuCommand menuCommand = mock(QuitCommand.class);
        when(menuView.getMenuOption()).thenReturn(menuCommand);
        bibliotecaController.start();
        verify(consoleView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuOnlyAfterWelcomeMessageAndSuccessfulLogin() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);

        when(users.findUserByLibraryNumberAndPassword(libraryNumber, password)).thenReturn(user);
        when(menuView.getMenuOption()).thenReturn(new QuitCommand(new HashSet<Role>(){{
            add(Role.MEMBER);
        }}));
        when(consoleView.getLibraryNumber()).thenReturn(libraryNumber);
        when(consoleView.getPassword()).thenReturn(password);

        BibliotecaController bibliotecaController = new BibliotecaController(menu, users, menuView, consoleView);
        bibliotecaController.start();

        verify(consoleView).printWelcomeMessage();
        verify(menuView).displayMenu(menuOptions);
    }

    @Test
    public void shouldNotDisplayMenuAfterUnSuccessfulLogin() {
        String libraryNumber = "123-4567";
        String password = "password";

        doThrow(new UserOperationException("User not found")).when(users).findUserByLibraryNumberAndPassword(libraryNumber, password);
        when(menuView.getMenuOption()).thenReturn(new QuitCommand(new HashSet<Role>(){{
            add(Role.MEMBER);
        }}));
        when(consoleView.getLibraryNumber()).thenReturn(libraryNumber);
        when(consoleView.getPassword()).thenReturn(password);

        BibliotecaController bibliotecaController = new BibliotecaController(menu, users, menuView, consoleView);
        bibliotecaController.start();

        verify(consoleView).printWelcomeMessage();
        verify(menuView, never()).displayMenu(menuOptions);
        verify(consoleView).printInvalidLoginMessage();
    }
}
