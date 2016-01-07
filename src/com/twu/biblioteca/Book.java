package com.twu.biblioteca;

import com.twu.biblioteca.Books.Copy;
import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.BookCopyPrcoeesingException;

import java.util.Set;

public class Book {
    private final int bookId;
    private final String name;
    private final String authorName;
    private final int yearPublished;
    private Set<Copy> copies;

    public Book(int bookId, String name, String authorName, int yearPublished, Set<Copy> copies) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
        this.copies = copies;
    }

    @Override
    public String toString() {
        return String.format("%-25s %-20s %d", name, authorName, yearPublished);
    }

    public boolean isAnyCopyAvailable() {
        return !copies.isEmpty();
    }

    public boolean isAnyCopyAvailableUnBorrowed() {
        for(Copy copy : copies) {
            if(!copy.isBorrowed()) {
                return true;
            }
        }
        return false;
    }

    public Copy getAnyUnBorrowedCopy() {
        for(Copy copy : copies) {
            if(!copy.isBorrowed()) {
                return copy;
            }
        }
        throw new BookCopyPrcoeesingException("No Book Copy Available");
    }

    public BookDTO createBookDTO() {
        return new BookDTO(getAnyUnBorrowedCopy().getIsbn(), name, authorName, yearPublished);
    }

    public boolean isIsbnOfThisBookType(int isbn) {
        for(Copy copy : copies) {
            if(copy.getIsbn() == isbn) {
                return true;
            }
        }
        return false;
    }

    private Copy findBookCopyByIsbn(int isbn) {
        for(Copy copy : copies) {
            if(copy.getIsbn() == isbn) {
                return copy;
            }
        }
        return null;
    }

    public void checkOutACopyByIsbn(int isbn) {
        Copy copy = findBookCopyByIsbn(isbn);
        if(copy == null) {
            throw new BookCopyPrcoeesingException("Requested Book Copy UnAvailable");
        }
        if(copy.isBorrowed()) {
            throw new BookCopyPrcoeesingException("Requested Book Copy Already Borrowed");
        }
        copy.checkOut();
    }

    public void checkInACopyByIsbn(int isbn) {
        Copy copy = findBookCopyByIsbn(isbn);
        if(copy == null) {
            throw new BookCopyPrcoeesingException("Requested Book Copy UnAvailable");
        }
        if(!copy.isBorrowed()) {
            throw new BookCopyPrcoeesingException("Requested Book Copy Was Not Borrowed");
        }
        copy.checkIn();
    }

    public boolean isThisBookCopyBorrowed(int isbn) {
        Copy copy = findBookCopyByIsbn(isbn);
        if(copy == null) {
            throw new BookCopyPrcoeesingException("Requested Book Copy UnAvailable");
        }
        return copy.isBorrowed();
    }

}
