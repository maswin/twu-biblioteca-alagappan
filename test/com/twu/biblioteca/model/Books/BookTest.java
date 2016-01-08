package com.twu.biblioteca.model.Books;

import com.twu.biblioteca.Exception.BookCopyProcessingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {

    private Set<Copy> copies;

    @Before
    public void setUp() throws Exception {
        copies = new HashSet<>();
    }

    @Test
    public void representBookAsAString() {
        copies.add(new Copy(1234, false));
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        assertEquals(String.format("%-25s %-20s %d", "Harry Potter", "J.K.Rowling", 2005), book.toString());
    }

    @Test
    public void checkIfTheISBNBelongsToThisBook() {
        copies.add(new Copy(2345, false));
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        assertTrue(book.isIsbnOfThisBookType(2345));
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void shouldReturnTrueIfAnyUnBorrowedBookIsAvailable() {
        copies.add(new Copy(2345, true));
        copies.add(new Copy(3456, false));
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        assertTrue(book.isAnyCopyAvailableUnBorrowed());
    }

    @Test
    public void shouldReturnFalseIfNoUnBorrowedBookIsAvailable() {
        copies.add(new Copy(2345, true));
        copies.add(new Copy(3456, true));
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        assertFalse(book.isAnyCopyAvailableUnBorrowed());
    }

    @Test
    public void shouldCheckOutABookCopyByIsbnWhenAvailable() throws BookCopyProcessingException {
        Copy copy = new Copy(2345, false);
        copies.add(copy);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        book.checkOutACopyByIsbn(2345);
        assertTrue(copy.isBorrowed());
    }

    @Test
    public void shouldThrowExceptionWhenBookCopyIsAlreadyBorrowedWhileCheckingOut() throws BookCopyProcessingException {
        expected.expect(BookCopyProcessingException.class);
        expected.expectMessage("Requested Book Copy Already Borrowed");
        Copy copy = new Copy(2345, true);
        copies.add(copy);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        book.checkOutACopyByIsbn(2345);
    }

    @Test
    public void shouldThrowExceptionWhenBookCopyIsNotAvailableWhileCheckingOut() throws BookCopyProcessingException {
        expected.expect(BookCopyProcessingException.class);
        expected.expectMessage("Requested Book Copy UnAvailable");
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        book.checkOutACopyByIsbn(2345);
    }

    @Test
    public void shouldCheckInABookCopyByIsbn() throws BookCopyProcessingException {
        Copy copy = new Copy(2345, true);
        copies.add(copy);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        book.checkInACopyByIsbn(2345);
        assertFalse(copy.isBorrowed());
    }

    @Test
    public void shouldThrowExceptionWhenBookCopyIsNotBorrowedWhileCheckingIn() throws BookCopyProcessingException {
        expected.expect(BookCopyProcessingException.class);
        expected.expectMessage("Requested Book Copy Was Not Borrowed");
        Copy copy = new Copy(2345, false);
        copies.add(copy);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        book.checkInACopyByIsbn(2345);
    }

    @Test
    public void shouldThrowExceptionWhenBookCopyIsNotAvailableWhileCheckingIn() throws BookCopyProcessingException {
        expected.expect(BookCopyProcessingException.class);
        expected.expectMessage("Requested Book Copy UnAvailable");
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, copies);
        book.checkOutACopyByIsbn(2345);
    }
}
