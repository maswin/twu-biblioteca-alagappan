package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;

public class DisplayBooksCommand implements MenuCommand {

    private final BookView bookView;
    private final Library library;

    public DisplayBooksCommand(BookView bookView, Library library) {
        this.bookView = bookView;
        this.library = library;
    }

    @Override
    public void performCommand(User user) throws Exception {
        bookView.printBooks(library.getListOfAvailableBookDTO());
    }
}
