package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.view.MenuView;

public class InvalidCommand implements MenuCommand {

    private MenuView menuView;

    public InvalidCommand(MenuView menuView) {
        this.menuView = menuView;
    }

    public InvalidCommand() {

    }

    @Override
    public void performCommand() throws Exception {
        menuView.displayInvalidOption();
    }
}
