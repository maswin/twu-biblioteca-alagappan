package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;

import java.util.Set;

public class CheckOutBookCommand extends MenuCommand {

    private final BookView bookView;
    private final Library library;

    public CheckOutBookCommand(BookView bookView, Library library, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.bookView = bookView;
        this.library = library;
    }

    private void checkOutBook(int bookId, User user) {
        try {
            library.checkOutBookCopy(bookId, user);
            bookView.printSuccessfulBookCheckoutMessage();
        } catch (LibraryItemProcessingException e) {
            bookView.printUnSuccessfulBookCheckoutMessage();
        }
    }

    @Override
    public void performCommand(User user) throws Exception {
        int bookId = bookView.getBookId();
        checkOutBook(bookId, user);
    }
}
