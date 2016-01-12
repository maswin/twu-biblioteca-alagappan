package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Users.User;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class CopyTest {

    @Test
    public void shouldReturnTrueIfTheBookIsCheckedOut() {
        int isbn = 1234;
        Copy copy = new Copy(isbn, false, null);
        copy.checkOut(null);
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

    @Test
    public void shouldReturnTrueIfTheBookIsBorrowedByGivenUser() {
        int isbn = 1234;
        User user = mock(User.class);
        Copy copy = new Copy(isbn, true, user);
        assertTrue(copy.isThisTheBorrowedUser(user));
    }

    @Test
    public void shouldReturnFalseIfTheBookIsNotBorrowedByGivenUser() {
        int isbn = 1234;
        User user = mock(User.class);
        Copy copy = new Copy(isbn, true, user);
        assertFalse(copy.isThisTheBorrowedUser(null));
    }

    @Test
    public void checkIfTheUserMatchesTheCheckedOutUser() {
        int isbn = 1234;
        User user = mock(User.class);
        Copy copy = new Copy(isbn, true, null);
        copy.checkOut(user);
        assertTrue(copy.isThisTheBorrowedUser(user));
    }
}
