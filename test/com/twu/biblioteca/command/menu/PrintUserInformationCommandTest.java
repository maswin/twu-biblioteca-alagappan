package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.ConsoleView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PrintUserInformationCommandTest {


    @Test
    public void shouldDisplayMovies() throws Exception {
        ConsoleView consoleView = Mockito.mock(ConsoleView.class);
        MenuCommand menuCommand = new PrintUserInformationCommand(consoleView, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(consoleView).printUserInformation(user);
    }
}
