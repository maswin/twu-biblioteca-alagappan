package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuViewTest {

    private OutputWriter outputWriter;
    private InputReader inputReader;
    private Map<Integer, String> menuOptions;

    @Before
    public void setUp() {
        outputWriter = Mockito.mock(OutputWriter.class);
        inputReader = Mockito.mock(InputReader.class);
        menuOptions = new HashMap<>();
        menuOptions.put(1, "option 1");
        menuOptions.put(2, "option 2");
    }

    @Test
    public void shouldDisplayMenuOptions() throws Exception {
        MenuView menuView = new MenuView(outputWriter, inputReader);
        menuView.displayMenu(menuOptions);
        verify(outputWriter).println("menu Options :");
        verify(outputWriter).println("1 option 1");
        verify(outputWriter).println("2 option 2");
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
