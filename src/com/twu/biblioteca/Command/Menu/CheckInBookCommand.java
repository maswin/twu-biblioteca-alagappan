package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;

import java.util.Set;

public class CheckInBookCommand extends MenuCommand {
    private final BookView bookView;
    private Library library;

    public CheckInBookCommand(BookView bookView, Library library, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.bookView = bookView;
        this.library = library;
    }

    private void checkInBook(int bookId, User user) throws LibraryItemProcessingException {
        try {
            library.checkInBookCopy(bookId, user);
            bookView.printSuccessfulBookCheckInMessage();
        } catch (LibraryItemProcessingException exception) {
            bookView.printUnSuccessfulBookCheckInMessage();
        }
    }

    @Override
    public void performCommand(User user) throws Exception {
        int bookId = bookView.getBookId();
        checkInBook(bookId, user);
    }
}
