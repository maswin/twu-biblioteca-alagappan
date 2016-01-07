package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.view.BibliotecaView;

public class CheckInBookCommand implements MenuCommand {
    private final BibliotecaView bibliotecaView;
    private Library library;

    public CheckInBookCommand(BibliotecaView bibliotecaView, Library library) {
        this.bibliotecaView = bibliotecaView;
        this.library = library;
    }

    private void checkInBook(int bookId) {
        if(library.isBorrowedBookCopy(bookId)) {
            library.checkInBookCopy(bookId);
        }
    }

    @Override
    public void performCommand() {
        int bookId = bibliotecaView.getBookId();
        checkInBook(bookId);
    }
}
