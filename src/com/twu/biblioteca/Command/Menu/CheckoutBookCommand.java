package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;

public class CheckOutBookCommand implements MenuCommand {

    private final BookView bookView;
    private final Library library;

    public CheckOutBookCommand(BookView bookView, Library library) {
        this.bookView = bookView;
        this.library = library;
    }

    private void checkOutBook(int bookId) {
        try {
            library.checkOutBookCopy(bookId);
            bookView.printSuccessfulBookCheckoutMessage();
        } catch (LibraryItemProcessingException e) {
            bookView.printUnSuccessfulBookCheckoutMessage();
        }
    }

    @Override
    public void performCommand(User user) throws Exception {
        int bookId = bookView.getBookId();
        checkOutBook(bookId);
    }
}
