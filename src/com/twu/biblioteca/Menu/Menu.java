package com.twu.biblioteca.Menu;

import com.twu.biblioteca.command.menu.InvalidCommand;
import com.twu.biblioteca.command.menu.MenuCommand;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Menu {
    private Map<String, String> menuOptions;
    private Map<String, MenuCommand> menuCommands;

    public Menu(Map<String, String> menuOptions, Map<String, MenuCommand> menuCommands) {
        this.menuOptions = menuOptions;
        this.menuCommands = menuCommands;
    }

    public Map<String, String> getMenuOptions(User user) {
        Map<String, String> menuOptionsAvailableToThisUser = new HashMap<>();
        menuCommands.entrySet().stream().filter(commandEntry -> commandEntry.getValue().isAuthorized(user)).
                forEach(commandEntry -> {
            menuOptionsAvailableToThisUser.put(commandEntry.getKey(), menuOptions.get(commandEntry.getKey()));
        });
        return menuOptionsAvailableToThisUser;
    }

    public MenuCommand getCommand(String menuOptionId) {
        if(!menuCommands.containsKey(menuOptionId))
            return menuCommands.get("invalid");
        return menuCommands.get(menuOptionId);
    }
}
