package com.twu.biblioteca.Menu;

import com.twu.biblioteca.command.menu.InvalidCommand;
import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MenuView;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {

    private Map<String, String> menuOptions;
    private Map<String, MenuCommand> menuCommands;
    private MenuView menuView;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = mock(User.class);
        menuView = mock(MenuView.class);

        menuOptions = new HashMap<>();
        menuOptions.put("1", "List Books");
        menuOptions.put("2", "Quit");

        menuCommands = new HashMap<>();
        MenuCommand menuCommand1 = mock(MenuCommand.class);
        menuCommands.put("1", menuCommand1);
        when(menuCommand1.isAuthorized(user)).thenReturn(true);
        MenuCommand menuCommand2 = mock(MenuCommand.class);
        menuCommands.put("2", menuCommand2);
    }

    @Test
    public void shouldReturnListOfMenuOptionsAvailableForThatUser() {
        Menu menu = new Menu(menuOptions, menuCommands, menuView);

        when(user.getRole()).thenReturn(Role.MEMBER);
        Map<String, String> thisUserMenuOptions;
        thisUserMenuOptions = menu.getMenuOptions(user);
        assertEquals("List Books", thisUserMenuOptions.get("1"));
    }

    @Test
    public void shouldReturnInvalidCommandIfCommandIsUnAvailable() throws Exception {
        Menu menu = new Menu(menuOptions, menuCommands, menuView);
        MenuCommand menuCommand = menu.getCommand("invalid");
        assertTrue(menuCommand instanceof InvalidCommand);
    }
}
