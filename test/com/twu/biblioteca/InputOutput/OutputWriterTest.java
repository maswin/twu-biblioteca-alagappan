package com.twu.biblioteca.InputOutput;

import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class OutputWriterTest {
    @Test
    public void shouldPrintTheOutput() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputWriter outputWriter = new OutputWriter(out);
        outputWriter.println("hello");
        assertEquals("hello\n", out.toString());
    }
}
