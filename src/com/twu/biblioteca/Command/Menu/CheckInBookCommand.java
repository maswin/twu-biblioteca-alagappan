package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookView;

public class CheckInBookCommand implements MenuCommand {
    private final BookView bookView;
    private Library library;

    public CheckInBookCommand(BookView bookView, Library library) {
        this.bookView = bookView;
        this.library = library;
    }

    private void checkInBook(int bookId) throws LibraryItemProcessingException {
        try {
            library.checkInBookCopy(bookId);
            bookView.printSuccessfulBookCheckInMessage();
        } catch (LibraryItemProcessingException exception) {
            bookView.printUnSuccessfulBookCheckInMessage();
        }
    }

    @Override
    public void performCommand() throws Exception {
        int bookId = bookView.getBookId();
        checkInBook(bookId);
    }
}
