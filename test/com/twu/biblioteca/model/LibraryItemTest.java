package com.twu.biblioteca.model;

import com.twu.biblioteca.DTO.LibraryItemDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Users.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class LibraryItemTest {

    private Set<Copy> copies;

    @Before
    public void setUp() throws Exception {
        copies = new HashSet<>();
    }

    private LibraryItem getLibraryItem(int itemId, String itemName, int year, Set<Copy> copies) {
        return new LibraryItem(itemId, itemName, year, copies) {
            @Override
            public <T extends LibraryItemDTO> T createDTO() throws LibraryItemProcessingException {
                return null;
            }
        };
    }

    @Test
    public void checkIfTheISBNBelongsToThisLibraryItem() {
        copies.add(new Copy(2345, null));
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        assertTrue(LibraryItem.isIsbnOfThisItemType(2345));
    }
    
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void shouldReturnTrueIfAnyUnBorrowedLibraryItemIsAvailable() {
        copies.add(new Copy(2345, null));
        copies.add(new Copy(3456, null));
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        assertTrue(LibraryItem.isAnyCopyAvailableUnBorrowed());
    }

    @Test
    public void shouldReturnFalseIfNoUnBorrowedLibraryItemIsAvailable() {
        copies.add(new Copy(2345, mock(User.class)));
        copies.add(new Copy(3456, mock(User.class)));
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        assertFalse(LibraryItem.isAnyCopyAvailableUnBorrowed());
    }

    @Test
    public void shouldCheckOutALibraryItemCopyByIsbnWhenAvailable() throws LibraryItemProcessingException {
        Copy copy = new Copy(2345, null);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345, mock(User.class));
        assertTrue(copy.isBorrowed());
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsAlreadyBorrowedWhileCheckingOut() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy Already Borrowed");
        Copy copy = new Copy(2345, mock(User.class));
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345, null);
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsNotAvailableWhileCheckingOut() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy UnAvailable");
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345, null);
    }

    @Test
    public void shouldCheckInALibraryItemCopyByIsbn() throws LibraryItemProcessingException {
        User user = mock(User.class);
        Copy copy = new Copy(2345, user);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkInACopyByIsbn(2345, user);
        assertFalse(copy.isBorrowed());
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsNotBorrowedWhileCheckingIn() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy Was Not Borrowed");
        Copy copy = new Copy(2345, null);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkInACopyByIsbn(2345, null);
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsNotAvailableWhileCheckingIn() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy UnAvailable");
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345, null);
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsNotBorrowedByGivenUser() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Not Borrowed By This User");
        User user = mock(User.class);
        copies.add(new Copy(5678, user));
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkInACopyByIsbn(5678, null);
    }

    @Test
    public void shouldFindACopyByIsbn() throws LibraryItemProcessingException {
        Copy copy = new Copy(2345, null);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        assertEquals(copy, LibraryItem.findCopyByIsbn(2345));
    }
}
