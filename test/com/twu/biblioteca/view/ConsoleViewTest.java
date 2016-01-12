package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConsoleViewTest {

    private OutputWriter outputWriter;
    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        outputWriter = Mockito.mock(OutputWriter.class);
        inputReader = Mockito.mock(InputReader.class);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        ConsoleView bookView = new ConsoleView(outputWriter, inputReader);
        bookView.printWelcomeMessage();
        verify(outputWriter).println("Welcome to Bibilioteca App !!");
    }

    @Test
    public void shouldGetLibraryNumber() {
        ConsoleView bookView = new ConsoleView(outputWriter, inputReader);
        String libraryNumber = "123-4567";
        when(inputReader.read()).thenReturn(libraryNumber);

        assertEquals(libraryNumber, bookView.getLibraryNumber());
        verify(outputWriter).println("Enter Your Library Number");
        verify(inputReader).read();
    }

    @Test
    public void shouldGetPassword() {
        ConsoleView bookView = new ConsoleView(outputWriter, inputReader);
        String password = "password";
        when(inputReader.read()).thenReturn(password);

        assertEquals(password, bookView.getPassword());
        verify(outputWriter).println("Enter Your Password");
        verify(inputReader).read();
    }

    @Test
    public void shouldPrintInvalidLoginMessage() {
        ConsoleView bookView = new ConsoleView(outputWriter, inputReader);
        bookView.printInvalidLoginMessage();
        verify(outputWriter).println("Invalid Login Credentials !!");
    }

}
