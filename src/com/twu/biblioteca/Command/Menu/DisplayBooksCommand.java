package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaView;

public class DisplayBooksCommand implements MenuCommand {

    private final BibliotecaView bibliotecaView;
    private final Library library;

    public DisplayBooksCommand(BibliotecaView bibliotecaView, Library library) {
        this.bibliotecaView = bibliotecaView;
        this.library = library;
    }

    @Override
    public void performCommand() throws Exception {
        bibliotecaView.printBooks(library.getListOfAvailableBookDTO());
    }
}
