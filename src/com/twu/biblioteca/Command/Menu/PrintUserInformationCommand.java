package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.ConsoleView;

public class PrintUserInformationCommand implements MenuCommand {
    private ConsoleView consoleView;

    public PrintUserInformationCommand(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    @Override
    public void performCommand(User user) throws Exception {
        consoleView.printUserInformation(user);
    }
}
