package com.twu.biblioteca.view;

import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.command.menu.MenuCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuViewTest {

    private Menu menu;
    private OutputWriter outputWriter;
    private InputReader inputReader;
    private Map<Integer, String> menuOptions;
    private Map<Integer, MenuCommand> menuCommands;

    @Before
    public void setUp() {
        outputWriter = Mockito.mock(OutputWriter.class);
        inputReader = Mockito.mock(InputReader.class);
        menuOptions = new HashMap<>();
        menuOptions.put(1, "option 1");
        menuOptions.put(2, "option 2");
        menuCommands = new HashMap<>();
        menu = new Menu(menuOptions, menuCommands);
    }

    @Test
    public void shouldDisplayMenuOptions() throws Exception {
        MenuView menuView = new MenuView(menu, outputWriter, inputReader);
        menuView.displayMenu(menuOptions);
        verify(outputWriter).println("Menu Options :");
        verify(outputWriter).println("1 option 1");
        verify(outputWriter).println("2 option 2");
    }

    @Test
    public void shouldReadMenuOption() throws Exception {
        MenuView menuView = new MenuView(menu, outputWriter, inputReader);
        when(inputReader.readInt()).thenReturn(1);
        menuView.getMenuOption();
        verify(inputReader).readInt();
    }

    @Test
    public void shouldDisplayInvalidMenuOption() throws Exception {
        MenuView menuView = new MenuView(menu, outputWriter, inputReader);
        menuView.displayInvalidOption();
        verify(outputWriter).println("Select a valid option!");
    }
}
