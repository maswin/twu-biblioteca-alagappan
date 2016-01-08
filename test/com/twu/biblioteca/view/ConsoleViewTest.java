package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

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
        ConsoleView bookView = new ConsoleView("Welcome to com.twu.biblioteca.controller.Biblioteca !!", outputWriter, inputReader);
        bookView.printWelcomeMessage();
        verify(outputWriter).println("Welcome to com.twu.biblioteca.controller.Biblioteca !!");
    }

}
