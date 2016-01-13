package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MenuView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InvalidCommandTest {

    @Test
    public void shouldCallInvalidInput() throws Exception {
        MenuView menuView = Mockito.mock(MenuView.class);
        MenuCommand menuCommand = new InvalidCommand(menuView, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);
        verify(menuView).displayInvalidOption();
    }
}
