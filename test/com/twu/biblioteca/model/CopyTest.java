package com.twu.biblioteca.model;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CopyTest {

    @Test
    public void shouldReturnTrueIfTheBookIsCheckedOut() {
        int isbn = 1234;
        Copy copy = new Copy(isbn, false, null);
        copy.checkOut();
        assertTrue(copy.isBorrowed());
    }

    @Test
    public void shouldReturnFalseIfTheBookIsCheckedIn() {
        int isbn = 1234;
        Copy copy = new Copy(isbn, true, null);
        copy.checkIn();
        assertFalse(copy.isBorrowed());
    }

    @Test
    public void shouldReturnTrueIfGivenIsbnMatchesThisBookIsbn() {
        int isbn = 1234;
        Copy copy = new Copy(isbn, true, null);
        assertTrue(copy.isSameIsbn(isbn));
    }

    @Test
    public void shouldReturnFalseIfGivenIsbnDoesNotMatchThisBookIsbn() {
        int isbn = 1234;
        Copy copy = new Copy(isbn, true, null);
        assertFalse(copy.isSameIsbn(1235));
    }
}
