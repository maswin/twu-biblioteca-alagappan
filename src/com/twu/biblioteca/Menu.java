package com.twu.biblioteca;

import java.util.Map;

public class Menu {
    private Map<Integer, String> menuOptions;

    public Menu(Map<Integer, String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public Map<Integer, String> getMenuOptions() {
        return menuOptions;
    }
}
