package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuViewTest {

    private OutputWriter outputWriter;
    private InputReader inputReader;

    @Before
    public void setUp() {
        outputWriter = Mockito.mock(OutputWriter.class);
        inputReader = Mockito.mock(InputReader.class);
    }

    @Test
    public void shouldDisplayMenuOptions() throws Exception {
        MenuView menuView = new MenuView(outputWriter, inputReader);
        menuView.displayMenu();
        verify(outputWriter).println("Menu Options :");
        verify(outputWriter).println("1. List Books");
    }

    @Test
    public void shouldReadMenuOption() throws Exception {
        MenuView menuView = new MenuView(outputWriter, inputReader);
        when(inputReader.read()).thenReturn("1");
        menuView.getMenuOption();
        verify(inputReader).read();
    }


    @Test
    public void shouldDisplayInvalidMenuOption() throws Exception {
        MenuView menuView = new MenuView(outputWriter, inputReader);
        menuView.displayInvalidOption();
        verify(outputWriter).println("Select a valid option!");
    }
}
