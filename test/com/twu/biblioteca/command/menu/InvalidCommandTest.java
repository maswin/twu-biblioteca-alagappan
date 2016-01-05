package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.view.MenuView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class InvalidCommandTest {

    @Test
    public void shouldCallInvalidInput() throws Exception {
        MenuView menuView = Mockito.mock(MenuView.class);
        MenuCommand menuCommand = new InvalidCommand(menuView);
        menuCommand.performCommand();
        verify(menuView).displayInvalidOption();
    }
}
