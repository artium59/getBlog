package com.web.blog.model.heart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeartRequestTest {
    @Test
    void getAccessToken() {
        final HeartRequest heartRequest = new HeartRequest("accessToken", 1234L);
        final String accessToken = heartRequest.getAccessToken();

        assertEquals("accessToken", accessToken);
    }

    @Test
    void getPno() {
        final HeartRequest heartRequest = new HeartRequest("accessToken", 1234L);
        Long pno = heartRequest.getPno();

        assertEquals(1234L, pno);
    }
}
