package com.twu.biblioteca.Books;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CopyTest {

    @Test
    public void shouldReturnTrueIfTheBookIsCheckedOut() {
        int isbn = 1234;
        Copy copy = new Copy(isbn, false);
        copy.checkOut();
        assertTrue(copy.isBorrowed());
    }

    @Test
    public void shouldReturnFalseIfTheBookIsCheckedIn() {
        int isbn = 1234;
        Copy copy = new Copy(isbn, true);
        copy.checkIn();
        assertFalse(copy.isBorrowed());
    }
}
