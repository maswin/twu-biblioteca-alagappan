package com.twu.biblioteca.model.Users;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldReturnTrueIfGivenLibraryNumberMatchesUserLibraryNumber() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678");
        assertTrue(user.isSameLibraryNumber(libraryNumber));
    }

    @Test
    public void shouldReturnFalseIfGivenLibraryNumberDoesNotMatchUserLibraryNumber() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678");
        assertFalse(user.isSameLibraryNumber("1234"));
    }

    @Test
    public void shouldReturnTrueIfGivenPasswordMatchesUserPassword() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678");
        assertTrue(user.checkPassword(password));
    }

    @Test
    public void shouldReturnFalseIfGivenPasswordDoesNotMatchUserPassword() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678");
        assertFalse(user.checkPassword("password1"));
    }

    @Test
    public void shouldRepresentUserAsString() throws Exception {
        User user = new User("123-4567", "password", "name", "abc@xyz.com", "12345678");
        assertEquals(String.format("Library Number : %s\nName : %s\nE-Mail : %s\nPhone No. : %s",
                "123-4567", "name", "abc@xyz.com", "12345678"), user.toString());
    }
}
