package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;

import java.util.Set;

public class CheckBookStatusCommand extends MenuCommand {

    private final Library library;
    private final BookView bookView;

    public CheckBookStatusCommand(Library library, BookView bookView, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.library = library;
        this.bookView = bookView;
    }

    @Override
    protected void performCommand(User user) throws Exception {
        int isbn = bookView.getBookId();
        try {
            Copy copy = library.findBookCopyByIsbn(isbn);
            bookView.printBookCopy(copy);
        } catch (LibraryItemProcessingException e) {
            bookView.printBookCopyNotFound();
        }
    }
}
