package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.view.MenuView;

public class InvalidCommand implements MenuCommand {

    private MenuView menuView;

    public InvalidCommand(MenuView menuView) {
        this.menuView = menuView;
    }

    @Override
    public void performCommand() {
        menuView.displayInvalidOption();
    }
}
