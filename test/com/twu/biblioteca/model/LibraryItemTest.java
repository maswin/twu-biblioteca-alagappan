package com.twu.biblioteca.model;

import com.twu.biblioteca.DTO.LibraryItemDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        copies.add(new Copy(2345, false));
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        assertTrue(LibraryItem.isIsbnOfThisItemType(2345));
    }
    
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void shouldReturnTrueIfAnyUnBorrowedLibraryItemIsAvailable() {
        copies.add(new Copy(2345, true));
        copies.add(new Copy(3456, false));
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        assertTrue(LibraryItem.isAnyCopyAvailableUnBorrowed());
    }

    @Test
    public void shouldReturnFalseIfNoUnBorrowedLibraryItemIsAvailable() {
        copies.add(new Copy(2345, true));
        copies.add(new Copy(3456, true));
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        assertFalse(LibraryItem.isAnyCopyAvailableUnBorrowed());
    }

    @Test
    public void shouldCheckOutALibraryItemCopyByIsbnWhenAvailable() throws LibraryItemProcessingException {
        Copy copy = new Copy(2345, false);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345);
        assertTrue(copy.isBorrowed());
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsAlreadyBorrowedWhileCheckingOut() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy Already Borrowed");
        Copy copy = new Copy(2345, true);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345);
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsNotAvailableWhileCheckingOut() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy UnAvailable");
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345);
    }

    @Test
    public void shouldCheckInALibraryItemCopyByIsbn() throws LibraryItemProcessingException {
        Copy copy = new Copy(2345, true);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkInACopyByIsbn(2345);
        assertFalse(copy.isBorrowed());
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsNotBorrowedWhileCheckingIn() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy Was Not Borrowed");
        Copy copy = new Copy(2345, false);
        copies.add(copy);
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkInACopyByIsbn(2345);
    }

    @Test
    public void shouldThrowExceptionWhenLibraryItemCopyIsNotAvailableWhileCheckingIn() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested LibraryItem Copy UnAvailable");
        LibraryItem LibraryItem = getLibraryItem(0, "Harry Potter", 2005, copies);
        LibraryItem.checkOutACopyByIsbn(2345);
    }
}
