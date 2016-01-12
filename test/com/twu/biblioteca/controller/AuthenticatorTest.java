package com.twu.biblioteca.controller;

import com.twu.biblioteca.Exception.UserOperationException;
import com.twu.biblioteca.model.Users.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticatorTest {

    @Test
    public void shouldReturnUserIfLibraryNumberAndPasswordMatches() throws UserOperationException {
        String libraryNumber = "123-4567";
        String password = "password";
        User user = mock(User.class);
        when(user.checkPassword(password)).thenReturn(true);
        when(user.isSameLibraryNumber(libraryNumber)).thenReturn(true);
        List<User> userList = new ArrayList<>();
        userList.add(user);

        Authenticator authenticator = new Authenticator(userList);
        assertEquals(user, authenticator.authenticate(libraryNumber, password));
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfLibraryNumberAndPasswordDoesNotMatch() throws UserOperationException {
        expected.expect(UserOperationException.class);
        expected.expectMessage("User not found");

        String libraryNumber = "123-4567";
        String password = "password";
        User user = mock(User.class);
        when(user.checkPassword(password)).thenReturn(false);
        when(user.isSameLibraryNumber(libraryNumber)).thenReturn(false);
        List<User> userList = new ArrayList<>();
        userList.add(user);

        Authenticator authenticator = new Authenticator(userList);
        authenticator.authenticate(libraryNumber, password);
    }

}
