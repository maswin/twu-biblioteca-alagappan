package com.twu.biblioteca.InputOutput;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {

    @Test
    public void shouldReadSingleWordInput() {
        String input = "input input";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputReader inputReader =new InputReader(in);
        assertEquals("input",inputReader.read());
    }

    @Test
    public void shouldReadSingleLineInput() {
        String input = "input input";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputReader inputReader =new InputReader(in);
        assertEquals("input input",inputReader.readLine());
    }

    @Test
    public void shouldReadInteger() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputReader inputReader =new InputReader(in);
        assertEquals(1,inputReader.readInt());
    }
}
