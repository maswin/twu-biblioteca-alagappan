package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void shouldReturnListOfMenuOptions() {
        Map<Integer, String> menuOptions = new HashMap<>();
        Menu menu = new Menu(menuOptions);
        assertEquals(menuOptions, menu.getMenuOptions());
    }


}
