package com.web.blog.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getNickname() {
        final User user = new User("nickname", "email@email.com", "password");
        final String nickname = user.getNickname();

        assertEquals("nickname", nickname);
    }

    @Test
    void getEmail() {
        final User user = new User("nickname", "email@email.com", "password");
        final String email = user.getEmail();

        assertEquals("email@email.com", email);
    }
}
