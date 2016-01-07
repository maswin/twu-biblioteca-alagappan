package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private List<Book> books;
    private Map<Book, Set<Integer>> borrowedBooks;
    private Set<Integer> isbns;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        books.add(new Book(1,"book1", "author1", 2012, new HashSet<>()));
        books.add(new Book(2,"book2", "author2", 2013, new HashSet<>()));
        books.add(new Book(3,"book3", "author3", 2014, new HashSet<>()));

        borrowedBooks = new HashMap<>();
        isbns = new HashSet<>();
    }

    @Test
    public void shouldAddInBorrowedBooksWhenThatBookIsCheckedOut() {
        Set isbns = new HashSet<>();
        isbns.add(1234);
        Book book = new Book(21,"book4", "author4", 2000, isbns);
        books.add(book);
        Library library = new Library(books, borrowedBooks);
        library.checkOut(1234);
        assertEquals(4, books.size());
        assertEquals(1, borrowedBooks.size());
    }

    @Test
    public void shouldAddInBorrowedBooksAndNumberOfTimesThatBookIsBorrowedShouldBe2WhenThatTypeOfBookIsCheckedOutTwice() {
        Set isbns = new HashSet<>();
        isbns.add(1234);
        isbns.add(2345);
        Book book = new Book(21,"book4", "author4", 2000, isbns);
        books.add(book);
        Library library = new Library(books, borrowedBooks);
        library.checkOut(1234);
        library.checkOut(2345);
        assertEquals(4, books.size());
        assertEquals(1, borrowedBooks.size());
        assertEquals(2, borrowedBooks.get(book).size());
    }

    @Test
    public void shouldReturnTrueIfBookIsAvailable() {
        int bookId = 21;
        isbns.add(1234);
        Book book = new Book(bookId,"book4", "author4", 2000, isbns);
        books.add(book);
        Library library = new Library(books, borrowedBooks);
        assertTrue(library.isBookAvailable(1234));
    }

    @Test
    public void shouldReturnTrueIfBookIsBorrowed() {
        int bookId = 21;
        isbns.add(1234);
        Book book = new Book(bookId, "book4", "author4", 2000, isbns);
        books.add(book);
        Set<Integer> thisBookBorrowedIsbn = new HashSet<>();
        thisBookBorrowedIsbn.add(1234);
        borrowedBooks.put(book, thisBookBorrowedIsbn);
        Library library = new Library(books, borrowedBooks);
        assertTrue(library.isBorrowedBook(1234));
    }

    @Test
    public void shouldRemoveBookFromBorrowedBooksWhenThatBookIsCheckedInAndItIsOnlyCopyOfThatBookBorrowed() {
        int bookId = 21;
        isbns.add(1234);
        Book book = new Book(bookId, "book4", "author4", 2000, isbns);
        books.add(book);
        Set<Integer> thisBookBorrowedIsbn = new HashSet<>();
        thisBookBorrowedIsbn.add(1234);
        borrowedBooks.put(book, thisBookBorrowedIsbn);
        Library library = new Library(books, borrowedBooks);
        library.checkIn(1234);
        assertEquals(4, books.size());
        assertEquals(0, borrowedBooks.size());
    }

    @Test
    public void shouldReduceNumberOfTimesThatBookIsBorrowedBy1WhenThatBookIsCheckedInAndItHasTwoCopiesOfThatBookBorrowed() {
        int bookId = 21;
        isbns.add(1234);
        isbns.add(2345);
        Book book = new Book(bookId, "book4", "author4", 2000, isbns);
        books.add(book);
        Set<Integer> thisBookBorrowedIsbn = new HashSet<>();
        thisBookBorrowedIsbn.add(1234);
        thisBookBorrowedIsbn.add(2345);
        borrowedBooks.put(book, thisBookBorrowedIsbn);
        Library library = new Library(books, borrowedBooks);
        library.checkIn(1234);
        assertEquals(4, books.size());
        assertEquals(1, borrowedBooks.size());
        assertEquals(1, borrowedBooks.get(book).size());
    }

}
