package com.twu.biblioteca;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.BookCopyPrcoeesingException;

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

    public void checkOutBookCopy(int isbn) {
        Book book = findBookCopyByIsbn(isbn);
        if(book != null) {
            book.checkOutACopyByIsbn(isbn);
        } else {
            throw new BookCopyPrcoeesingException("Requested Book Copy UnAvailable");
        }
    }


    public List<BookDTO> getListOfAvailableBookDTO() {
        List<BookDTO> bookDTOs = new ArrayList<>();
        for(Book book : books) {
            if(book.isAnyCopyAvailableUnBorrowed()) {
                BookDTO bookDTO = book.createBookDTO();
                bookDTOs.add(bookDTO);
            }
        }
        return bookDTOs;
    }

    public boolean isBookCopyAvailable(int isbn) {
        for(Book book : books) {
            if(book.isIsbnOfThisBookType(isbn))
                return true;
        }
        return false;
    }

    public boolean isBorrowedBookCopy(int isbn) {
        for(Book book : books) {
            if(book.isIsbnOfThisBookType(isbn) && book.isThisBookCopyBorrowed(isbn))
                return true;
        }
        return false;
    }

    public void checkInBookCopy(int isbn) {
        Book book = findBookCopyByIsbn(isbn);
        if(book != null) {
            book.checkInACopyByIsbn(isbn);
        } else {
            throw new BookCopyPrcoeesingException("Requested Book Copy UnAvailable");
        }
    }
}
