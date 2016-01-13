package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;

public class CheckBookStatusCommand implements MenuCommand {

    private final Library library;
    private final BookView bookView;

    public CheckBookStatusCommand(Library library, BookView bookView) {
        this.library = library;
        this.bookView = bookView;
    }

    @Override
    public void performCommand(User user) throws Exception {
        int isbn = bookView.getBookId();
        try {
            Copy copy = library.findBookCopyByIsbn(isbn);
            bookView.printBookCopy(copy);
        } catch (LibraryItemProcessingException e) {
            bookView.printBookCopyNotFound();
        }
    }
}
