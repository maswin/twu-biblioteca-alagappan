package com.twu.biblioteca;

import com.twu.biblioteca.command.menu.MenuCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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

}
