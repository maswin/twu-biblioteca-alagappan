package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MenuView;

import java.util.Set;

public class InvalidCommand extends MenuCommand {

    private MenuView menuView;

    public InvalidCommand(MenuView menuView, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.menuView = menuView;
    }

    @Override
    public void performCommand(User user) throws Exception {
        menuView.displayInvalidOption();
    }
}
