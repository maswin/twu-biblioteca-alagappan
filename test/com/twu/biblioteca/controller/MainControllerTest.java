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

public class MainControllerTest {

    private MenuView menuView;
    private Menu menu;
    private ConsoleView consoleView;
    private Map<String, String> menuOptions;
    private Users users;

    @Before
    public void setUp() throws Exception {
        menuView = mock(MenuView.class);
        when(menuView.getMenuOption()).thenReturn("quit");
        consoleView = mock(ConsoleView.class);
        menuOptions = new HashMap<>();
        menu = mock(Menu.class);
        when(menu.getCommand("quit")).thenReturn(new QuitCommand(new HashSet<Role>(){{
            add(Role.MEMBER);
        }}));
        users = mock(Users.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        MainController mainController = new MainController(menu, users, menuView, consoleView);
        mainController.start();
        verify(consoleView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuOnlyAfterWelcomeMessageAndSuccessfulLogin() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);

        when(users.findUserByLibraryNumberAndPassword(libraryNumber, password)).thenReturn(user);
        when(menuView.getMenuOption()).thenReturn("quit");
        when(consoleView.getLibraryNumber()).thenReturn(libraryNumber);
        when(consoleView.getPassword()).thenReturn(password);

        MainController mainController = new MainController(menu, users, menuView, consoleView);
        mainController.start();

        verify(consoleView).printWelcomeMessage();
        verify(menuView).displayMenu(menuOptions);
    }

    @Test
    public void shouldPromptLoginUntilCorrectCredentialsAreObtained() {
        String libraryNumber = "123-4567";
        String password = "password";

        doThrow(new UserOperationException("User not found")).when(users).findUserByLibraryNumberAndPassword("123", "xyz");
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);

        when(users.findUserByLibraryNumberAndPassword(libraryNumber, password)).thenReturn(user);
        when(consoleView.getLibraryNumber()).thenReturn("123", libraryNumber);
        when(consoleView.getPassword()).thenReturn("xyz", password);

        MainController mainController = new MainController(menu, users, menuView, consoleView);
        mainController.start();

        verify(consoleView).printWelcomeMessage();
        verify(consoleView).printInvalidLoginMessage();
    }

    @Test
    public void shouldPrintExceptionMessageWhenExceptionIsThrown() throws Exception {
        String libraryNumber = "123-4567";
        String password = "password";

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);

        when(users.findUserByLibraryNumberAndPassword(libraryNumber, password)).thenReturn(user);
        MenuCommand menuCommand = mock(MenuCommand.class);

        when(menuView.getMenuOption()).thenReturn("1", "quit");
        when(menu.getCommand("1")).thenReturn(menuCommand);
        when(menu.getCommand("quit")).thenReturn(new QuitCommand(new HashSet<Role>(){{
            add(Role.MEMBER);
        }}));

        Exception exception = mock(Exception.class);
        doThrow(exception).when(menuCommand).execute(user);

        when(consoleView.getLibraryNumber()).thenReturn(libraryNumber);
        when(consoleView.getPassword()).thenReturn(password);

        MainController mainController = new MainController(menu, users, menuView, consoleView);
        mainController.start();

        verify(consoleView).printWelcomeMessage();
        verify(consoleView).printMessage(exception.getMessage());
    }


}
