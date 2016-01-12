package com.twu.biblioteca.model;

import com.twu.biblioteca.DTO.LibraryItemDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;

import java.util.Optional;
import java.util.Set;

public abstract class LibraryItem {
    protected int itemId;
    protected final String name;
    protected final int year;
    protected final Set<Copy> copies;

    public LibraryItem(int itemId, String name, int year, Set<Copy> copies) {
        this.itemId = itemId;
        this.name = name;
        this.year = year;
        this.copies = copies;
    }

    protected Copy getAnyUnBorrowedCopy() throws LibraryItemProcessingException {
        Optional<Copy> foundCopy = copies.stream().filter(copy -> !copy.isBorrowed()).findFirst();
        if(foundCopy.isPresent()) {
            return foundCopy.get();
        }
        throw new LibraryItemProcessingException("No LibraryItem Copy Available");
    }


    public boolean isAnyCopyAvailableUnBorrowed() {
        return copies.stream().anyMatch(copy -> !copy.isBorrowed());
    }

    public boolean isIsbnOfThisItemType(int isbn) {
        return copies.stream().anyMatch(copy -> copy.isSameIsbn(isbn));
    }

    private Copy findCopyByIsbn(int isbn) {
        Optional<Copy> foundCopy = copies.stream().filter(copy -> copy.isSameIsbn(isbn)).findFirst();
        if(foundCopy.isPresent()) {
            return foundCopy.get();
        }
        return null;
    }

    public void checkOutACopyByIsbn(int isbn) throws LibraryItemProcessingException {
        Copy copy = findCopyByIsbn(isbn);
        if(copy == null) {
            throw new LibraryItemProcessingException("Requested LibraryItem Copy UnAvailable");
        }
        if(copy.isBorrowed()) {
            throw new LibraryItemProcessingException("Requested LibraryItem Copy Already Borrowed");
        }
        copy.checkOut();
    }

    public void checkInACopyByIsbn(int isbn) throws LibraryItemProcessingException {
        Copy copy = findCopyByIsbn(isbn);
        if(copy == null) {
            throw new LibraryItemProcessingException("Requested LibraryItem Copy UnAvailable");
        }
        if(!copy.isBorrowed()) {
            throw new LibraryItemProcessingException("Requested LibraryItem Copy Was Not Borrowed");
        }
        copy.checkIn();
    }

    public abstract <T extends LibraryItemDTO> T createDTO() throws LibraryItemProcessingException;
}
