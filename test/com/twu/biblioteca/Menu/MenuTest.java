package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.command.menu.MenuCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    private Map<Integer, String> menuOptions;
    private Map<Integer, MenuCommand> menuCommands;

    @Before
    public void setUp() throws Exception {
        menuOptions = new HashMap<>();
        menuOptions.put(1, "List Books");
        menuOptions.put(2, "Quit");

        menuCommands = new HashMap<>();
    }

    @Test
    public void shouldReturnListOfMenuOptions() {
        Menu menu = new Menu(menuOptions, menuCommands);
        assertEquals(menuOptions, menu.getMenuOptions());
    }

    @Test
    public void shouldReturnTrueIfCommandIsAvailable() throws Exception {
        MenuCommand menuCommand = Mockito.mock(MenuCommand.class);
        menuCommands.put(1, menuCommand);
        Menu menu = new Menu(menuOptions, menuCommands);
        assertTrue(menu.containsCommand(1));
    }
}
