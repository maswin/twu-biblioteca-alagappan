package com.twu.biblioteca.Menu;

import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.model.Users.User;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, String> menuOptions;
    private Map<Integer, MenuCommand> menuCommands;

    public Menu(Map<Integer, String> menuOptions, Map<Integer, MenuCommand> menuCommands) {
        this.menuOptions = menuOptions;
        this.menuCommands = menuCommands;
    }

    public Map<Integer, String> getMenuOptions(User user) {
        Map<Integer, String> menuOptionsAvailableToThisUser = new HashMap<>();
        menuCommands.entrySet().stream().filter(commandEntry -> commandEntry.getValue().isAuthorized(user)).forEach(commandEntry -> {
            menuOptionsAvailableToThisUser.put(commandEntry.getKey(), menuOptions.get(commandEntry.getKey()));
        });
        return menuOptionsAvailableToThisUser;
    }

    public MenuCommand getCommand(int menuOptionId) {
        return menuCommands.get(menuOptionId);
    }

    public boolean containsCommand(int menuOptionId) {
        return menuCommands.containsKey(menuOptionId);
    }
}
