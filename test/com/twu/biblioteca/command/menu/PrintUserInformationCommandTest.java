package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.ConsoleView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintUserInformationCommandTest {


    @Test
    public void shouldDisplayMovies() throws Exception {
        ConsoleView consoleView = Mockito.mock(ConsoleView.class);
        MenuCommand menuCommand = new PrintUserInformationCommand(consoleView);
        User user = mock(User.class);
        menuCommand.performCommand(user);

        verify(consoleView).printUserInformation(user);
    }
}
