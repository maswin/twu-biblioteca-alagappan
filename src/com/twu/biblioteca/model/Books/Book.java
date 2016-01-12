package com.twu.biblioteca.model.Books;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.LibraryItem;

import java.util.Set;

public class Book extends LibraryItem {
    private final String authorName;

    public Book(int itemId, String name, String authorName, int year, Set<Copy> copies) {
        super(itemId, name, year, copies);
        this.authorName = authorName;
    }

    public BookDTO createDTO() throws LibraryItemProcessingException {
        return new BookDTO(getAnyUnBorrowedCopy().getIsbn(), name, authorName, year);
    }

}
