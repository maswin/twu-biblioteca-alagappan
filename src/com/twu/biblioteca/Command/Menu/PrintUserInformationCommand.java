package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.ConsoleView;

import java.util.Set;

public class PrintUserInformationCommand extends MenuCommand {
    private ConsoleView consoleView;

    public PrintUserInformationCommand(ConsoleView consoleView, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.consoleView = consoleView;
    }

    @Override
    public void performCommand(User user) throws Exception {
        consoleView.printUserInformation(user);
    }
}
