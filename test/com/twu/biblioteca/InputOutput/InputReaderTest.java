package com.twu.biblioteca.InputOutput;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {

    @Test
    public void shouldReadSingleWordInput() {
        Scanner scanner=new Scanner("input");
        InputReader inputReader =new InputReader(scanner);
        assertEquals("input",inputReader.read());
    }

    @Test
    public void shouldReadSingleLineInput() {
        Scanner scanner=new Scanner("input input");
        InputReader inputReader =new InputReader(scanner);
        assertEquals("input input",inputReader.readLine());
    }
}
