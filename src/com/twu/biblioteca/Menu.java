package com.twu.biblioteca;

import com.twu.biblioteca.command.menu.MenuCommand;

import java.util.Map;

public class Menu {
    private Map<Integer, String> menuOptions;
    private Map<Integer, MenuCommand> menuCommands;

    public Menu(Map<Integer, String> menuOptions, Map<Integer, MenuCommand> menuCommands) {
        this.menuOptions = menuOptions;
        this.menuCommands = menuCommands;
    }

    public Map<Integer, String> getMenuOptions() {
        return menuOptions;
    }

    public MenuCommand getCommand(int menuOptionId) {
        return menuCommands.get(menuOptionId);
    }
    public boolean containsCommand(int menuOptionId) {
        return menuCommands.containsKey(menuOptionId);
    }
}
