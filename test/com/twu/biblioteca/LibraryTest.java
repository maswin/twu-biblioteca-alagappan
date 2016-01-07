package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private List<Book> books;
    private Set<Integer> borrowedIsbns;
    private Set<Integer> isbns;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        books.add(new Book(1,"book1", "author1", 2012, new HashSet<>()));
        books.add(new Book(2,"book2", "author2", 2013, new HashSet<>()));
        books.add(new Book(3,"book3", "author3", 2014, new HashSet<>()));

        borrowedIsbns = new HashSet<>();
        isbns = new HashSet<>();
    }

    @Test
    public void shouldAddInBorrowedBooksWhenThatBookIsCheckedOut() {
        isbns.add(1234);
        Book book = new Book(21,"book4", "author4", 2000, isbns);
        books.add(book);
        Library library = new Library(books, borrowedIsbns);
        library.checkOut(1234);
        assertEquals(4, books.size());
        assertEquals(1, borrowedIsbns.size());
    }

    @Test
    public void shouldNotAddBookInBorrowedBookWhenBookIsUnAvailable() {
        isbns.add(1234);
        Book book = new Book(21,"book4", "author4", 2000, isbns);
        books.add(book);
        Library library = new Library(books, borrowedIsbns);
        library.checkOut(2345);
        assertEquals(4, books.size());
        assertEquals(0, borrowedIsbns.size());
    }

    @Test
    public void shouldReturnTrueIfBookIsAvailable() {
        int bookId = 21;
        isbns.add(1234);
        Book book = new Book(bookId,"book4", "author4", 2000, isbns);
        books.add(book);
        Library library = new Library(books, borrowedIsbns);
        assertTrue(library.isBookAvailable(1234));
    }

    @Test
    public void shouldReturnTrueIfBookIsBorrowed() {
        int bookId = 21;
        isbns.add(1234);
        Book book = new Book(bookId, "book4", "author4", 2000, isbns);
        books.add(book);
        borrowedIsbns.add(1234);
        Library library = new Library(books, borrowedIsbns);
        assertTrue(library.isBorrowedBook(1234));
    }

    @Test
    public void shouldRemoveBookFromBorrowedIsbnsWhenItIsCheckedIn() {
        int bookId = 21;
        isbns.add(1234);
        Book book = new Book(bookId, "book4", "author4", 2000, isbns);
        books.add(book);
        borrowedIsbns.add(1234);
        Library library = new Library(books, borrowedIsbns);
        library.checkIn(1234);
        assertEquals(4, books.size());
        assertEquals(0, borrowedIsbns.size());
    }

    @Test
    public void shouldReturnFalseWhenBookNotBorrowedIsCheckedIn() {
        int bookId = 21;
        isbns.add(1234);
        Book book = new Book(bookId, "book4", "author4", 2000, isbns);
        books.add(book);
        borrowedIsbns.add(1234);
        Library library = new Library(books, borrowedIsbns);
        assertFalse(library.checkIn(1235));
        assertEquals(4, books.size());
        assertEquals(1, borrowedIsbns.size());
    }

}
