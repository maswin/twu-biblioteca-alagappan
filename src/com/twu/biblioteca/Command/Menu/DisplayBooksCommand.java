package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;

import java.util.Set;

public class DisplayBooksCommand extends MenuCommand {

    private final BookView bookView;
    private final Library library;

    public DisplayBooksCommand(BookView bookView, Library library, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.bookView = bookView;
        this.library = library;
    }

    @Override
    public void performCommand(User user) throws Exception {
        bookView.printBooks(library.getListOfAvailableBookDTO());
    }
}
