package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class MenuViewTest {

    @Test
    public void shouldDisplayMenuOptions() throws Exception {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        MenuView menuView = new MenuView(outputWriter);
        menuView.displayMenu();
        verify(outputWriter).println("Menu Options :");
        verify(outputWriter).println("1. List Books");
    }
    
}
