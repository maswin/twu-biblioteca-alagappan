package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    private Map<Integer, String> menuOptions;

    @Before
    public void setUp() throws Exception {
        menuOptions = new HashMap<>();
        menuOptions.put(1, "List Books");
        menuOptions.put(2, "Quit");
    }

    @Test
    public void shouldReturnListOfMenuOptions() {
        Menu menu = new Menu(menuOptions);
        assertEquals(menuOptions, menu.getMenuOptions());
    }

//    @Test
//    public void shouldReturnCommandBasedOnInput() {
//        Menu menu = new Menu(menuOptions);
//        MenuCommand menuCommand = menu.createCommand(1);
//    }

}
