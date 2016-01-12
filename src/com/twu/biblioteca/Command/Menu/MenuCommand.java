package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Users.User;

public interface MenuCommand {

    void performCommand(User user) throws Exception;
}
