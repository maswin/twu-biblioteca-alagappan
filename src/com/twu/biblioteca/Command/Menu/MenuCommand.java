package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.InvaliOperationException;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;

import java.util.Set;

public abstract class MenuCommand {

    private Set<Role> authorizedRoles;

    MenuCommand(Set<Role> authorizedRoles) {
        this.authorizedRoles = authorizedRoles;
    }

    public void execute(User user) throws Exception {
        if(!isAuthorized(user))
            throw new InvaliOperationException("Not Authorized to Perform this command!!");
        performCommand(user);
    }

    protected abstract void performCommand(User user) throws Exception;

    public boolean isAuthorized(User user){
        return authorizedRoles.contains(user.getRole());
    }
}
