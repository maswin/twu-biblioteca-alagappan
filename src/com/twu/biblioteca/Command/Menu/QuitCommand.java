package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;

import java.util.Set;

public class QuitCommand extends MenuCommand {

    public QuitCommand(Set<Role> authorizedRoles) {
        super(authorizedRoles);
    }

    @Override
    public void performCommand(User user) throws Exception {

    }

    @Override
    public boolean isAuthorized(User user) {
        return true;
    }
}
