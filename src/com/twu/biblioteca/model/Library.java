package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.BookCopyProcessingException;

import java.util.*;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    private Book findBookCopyByIsbn(int isbn) {
        for(Book book : books) {
            if(book.isIsbnOfThisBookType(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void checkOutBookCopy(int isbn) throws BookCopyProcessingException {
        Book book = findBookCopyByIsbn(isbn);
        if(book != null) {
            book.checkOutACopyByIsbn(isbn);
        } else {
            throw new BookCopyProcessingException("Requested Book Copy UnAvailable");
        }
    }

    public List<BookDTO> getListOfAvailableBookDTO() throws BookCopyProcessingException {
        List<BookDTO> bookDTOs = new ArrayList<>();
        for(Book book : books) {
            if(book.isAnyCopyAvailableUnBorrowed()) {
                BookDTO bookDTO = book.createBookDTO();
                bookDTOs.add(bookDTO);
            }
        }
        return bookDTOs;
    }

    public void checkInBookCopy(int isbn) throws BookCopyProcessingException {
        Book book = findBookCopyByIsbn(isbn);
        if(book != null) {
            book.checkInACopyByIsbn(isbn);
        } else {
            throw new BookCopyProcessingException("Requested Book Copy UnAvailable");
        }
    }
}
