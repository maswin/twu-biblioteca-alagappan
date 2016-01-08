package com.twu.biblioteca.model.Books;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.BookCopyProcessingException;

import java.util.Optional;
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

    public boolean isAnyCopyAvailableUnBorrowed() {
        return copies.stream().anyMatch(copy -> !copy.isBorrowed());
    }

    private Copy getAnyUnBorrowedCopy() throws BookCopyProcessingException {
        Optional<Copy> foundCopy = copies.stream().filter(copy -> !copy.isBorrowed()).findFirst();
        if(foundCopy.isPresent()) {
            return foundCopy.get();
        }
        throw new BookCopyProcessingException("No Book Copy Available");
    }

    public BookDTO createBookDTO() throws BookCopyProcessingException {
        return new BookDTO(getAnyUnBorrowedCopy().getIsbn(), name, authorName, yearPublished);
    }

    public boolean isIsbnOfThisBookType(int isbn) {
        return copies.stream().anyMatch(copy -> copy.isSameIsbn(isbn));
    }

    private Copy findBookCopyByIsbn(int isbn) {
        Optional<Copy> foundCopy = copies.stream().filter(copy -> copy.isSameIsbn(isbn)).findFirst();
        if(foundCopy.isPresent()) {
            return foundCopy.get();
        }
        return null;
    }

    public void checkOutACopyByIsbn(int isbn) throws BookCopyProcessingException {
        Copy copy = findBookCopyByIsbn(isbn);
        if(copy == null) {
            throw new BookCopyProcessingException("Requested Book Copy UnAvailable");
        }
        if(copy.isBorrowed()) {
            throw new BookCopyProcessingException("Requested Book Copy Already Borrowed");
        }
        copy.checkOut();
    }

    public void checkInACopyByIsbn(int isbn) throws BookCopyProcessingException {
        Copy copy = findBookCopyByIsbn(isbn);
        if(copy == null) {
            throw new BookCopyProcessingException("Requested Book Copy UnAvailable");
        }
        if(!copy.isBorrowed()) {
            throw new BookCopyProcessingException("Requested Book Copy Was Not Borrowed");
        }
        copy.checkIn();
    }

}
