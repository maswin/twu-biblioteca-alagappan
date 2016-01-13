package com.twu.biblioteca.model.Users;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemberTest {

    @Test
    public void shouldRepresentUserAsString() throws Exception {
        User user = new Member("123-4567", "password", "name", "abc@xyz.com", "12345678");
        assertEquals(String.format("Library Number : %s\nName : %s\nE-Mail : %s\nPhone No. : %s",
                "123-4567", "name", "abc@xyz.com", "12345678"), user.toString());
    }
}
