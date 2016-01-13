package com.twu.biblioteca.model.Users;

import com.twu.biblioteca.model.Role;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldReturnTrueIfGivenLibraryNumberMatchesUserLibraryNumber() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678", Role.MEMBER){};
        assertTrue(user.isSameLibraryNumber(libraryNumber));
    }

    @Test
    public void shouldReturnFalseIfGivenLibraryNumberDoesNotMatchUserLibraryNumber() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678", Role.MEMBER){};
        assertFalse(user.isSameLibraryNumber("1234"));
    }

    @Test
    public void shouldReturnTrueIfGivenPasswordMatchesUserPassword() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678", Role.MEMBER){};
        assertTrue(user.checkPassword(password));
    }

    @Test
    public void shouldReturnFalseIfGivenPasswordDoesNotMatchUserPassword() {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = new User(libraryNumber, password, "name", "abc@xyz.com", "12345678", Role.MEMBER){};
        assertFalse(user.checkPassword("password1"));
    }

}
