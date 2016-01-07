package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        books.add(new Book(1,"book1", "author1", 2012, new HashSet<>()));
        books.add(new Book(2,"book2", "author2", 2013, new HashSet<>()));
        books.add(new Book(3,"book3", "author3", 2014, new HashSet<>()));
    }

//    @Test
//    public void shouldReturnBookIfIdMatchesExistingBookID() {
//        Book book = new Book(21,"book4", "author4", 2000);
//        books.add(book);
//        Library library = new Library(books, new ArrayList<>());
//        assertEquals(book, library.findBookById(21));
//    }
//
//    @Test
//    public void shouldReturnNullIfIdMatchesNoExistingBookID() {
//        Library library = new Library(books, new ArrayList<>());
//        assertEquals(null, library.findBookById(21));
//    }

    @Test
    public void shouldRemoveBookFromBooksAndAddInBorrowedBooksWhenThatBookIsCheckedOut() {
        Book book = new Book(21,"book4", "author4", 2000, new HashSet<>());
        books.add(book);
        List<Book> borrowedBooks = new ArrayList<>();
        Library library = new Library(books, borrowedBooks);
        library.checkOut(21);
        assertEquals(3, books.size());
        assertEquals(1, borrowedBooks.size());
    }

    @Test
    public void shouldReturnTrueIfBookIsAvailable() {
        int bookId = 21;
        Book book = new Book(bookId,"book4", "author4", 2000, new HashSet<>());
        books.add(book);
        List<Book> borrowedBooks = new ArrayList<>();
        Library library = new Library(books, borrowedBooks);
        assertTrue(library.isBookAvailable(bookId));

    }

    @Test
    public void shouldReturnTrueIfBookIsBorrowed() {
        int bookId = 21;
        Book book = new Book(bookId,"book4", "author4", 2000, new HashSet<>());
        List<Book> borrowedBooks = new ArrayList<>();
        borrowedBooks.add(book);
        Library library = new Library(books, borrowedBooks);
        assertTrue(library.isBorrowedBook(bookId));
    }

    @Test
    public void shouldRemoveBookFromBorrowedBooksAndAddInBooksWhenThatBookIsCheckedIn() {
        Book book = new Book(21,"book4", "author4", 2000, new HashSet<>());
        List<Book> borrowedBooks = new ArrayList<>();
        borrowedBooks.add(book);
        Library library = new Library(books, borrowedBooks);
        library.checkIn(21);
        assertEquals(4, books.size());
        assertEquals(0, borrowedBooks.size());
    }
}
