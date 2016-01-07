package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.model.Books.Copy;
import com.twu.biblioteca.Exception.BookCopyPrcoeesingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private List<Book> books;
    private Set<Copy> copies;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        copies = new HashSet<>();
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void shouldCheckOutBookCopyWhenBookIsAvailable() {
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisBookType(isbn)).thenReturn(true);
        books.add(book);
        Library library = new Library(books);
        library.checkOutBookCopy(isbn);
        verify(book).checkOutACopyByIsbn(isbn);
    }

    @Test
    public void shouldThrowExceptionWhenCheckOutBookCopyIsUnAvailable() {
        expected.expect(BookCopyPrcoeesingException.class);
        expected.expectMessage("Requested Book Copy UnAvailable");
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisBookType(isbn)).thenReturn(false);
        books.add(book);
        Library library = new Library(books);
        library.checkOutBookCopy(isbn);
    }

    @Test
    public void shouldCheckInBookCopyWhenBookIsBorrowed() {
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisBookType(isbn)).thenReturn(true);
        books.add(book);
        Library library = new Library(books);
        library.checkInBookCopy(isbn);
        verify(book).checkInACopyByIsbn(isbn);
    }

    @Test
    public void shouldThrowExceptionWhenCheckInBookCopyIsUnAvailable() {
        expected.expect(BookCopyPrcoeesingException.class);
        expected.expectMessage("Requested Book Copy UnAvailable");
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisBookType(isbn)).thenReturn(false);
        books.add(book);
        Library library = new Library(books);
        library.checkInBookCopy(isbn);
    }

    @Test
    public void shouldReturnTrueIfBookIsBorrowed() {
        int bookId = 21;
        copies.add(new Copy(1234, true));
        Book book = new Book(bookId, "book4", "author4", 2000, copies);
        books.add(book);
        Library library = new Library(books);
        assertTrue(library.isBorrowedBookCopy(1234));
    }

    @Test
    public void shouldReturnTrueIfBookIsAvailable() {
        int bookId = 21;
        copies.add(new Copy(1234, false));
        Book book = new Book(bookId,"book4", "author4", 2000, copies);
        books.add(book);
        Library library = new Library(books);
        assertTrue(library.isBookCopyAvailable(1234));
    }

}
