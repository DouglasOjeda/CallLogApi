package com.douglasojeda.calllog.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testConstructor() {
        User user = new User(4L, "Robert", null);
        assertEquals(4L, user.getUserId());
        assertEquals("Robert", user.getDisplayName());
        assertNull(user.getContacts());
    }

}