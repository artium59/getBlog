package com.web.blog.controller.heart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.blog.dao.heart.HeartDao;
import com.web.blog.model.heart.HeartRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.transaction.Transactional;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Transactional
@AutoConfigureMockMvc
class HeartControllerTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mvc;

    @Autowired
    HeartDao heartDao;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach()
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    void clickHeart() throws Exception {
        // reset this
        final String token = "eyJhbGciOiJIUzUxMiJ9" +
                ".eyJzdWIiOiIzMiIsImlhdCI6MTU5NzkyNzM0NywiZXhwIjoxNTk4MDEzNzQ3LCJlbWFpb" +
                "CI6InRlc3RAdGVzdC5jb20iLCJyb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19" +
                ".gKemZAbUgmtgNQVTglMGvAUGbFKIKwPoK9g-5jXugpVEpETNOENwGaObXUp2V4IfO2amgrVNYQhvBmfZ9NGaTQ";

        final String result =
                Boolean.TRUE.equals(heartDao.existsByPostPnoAndUserUid(11L, 32L)) ?
                "true" : "false";

        mvc.perform(post("/heart/check")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(new HeartRequest(token, 11L))))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(result)))
                .andDo(print());
    }

    @Test
    void checkHeart() throws Exception {
        // reset this
        final String token = "eyJhbGciOiJIUzUxMiJ9" +
                ".eyJzdWIiOiIzMiIsImlhdCI6MTU5NzkyNzM0NywiZXhwIjoxNTk4MDEzNzQ3LCJlbWFpb" +
                "CI6InRlc3RAdGVzdC5jb20iLCJyb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19" +
                ".gKemZAbUgmtgNQVTglMGvAUGbFKIKwPoK9g-5jXugpVEpETNOENwGaObXUp2V4IfO2amgrVNYQhvBmfZ9NGaTQ";

        // MOC MVC test
        mvc.perform(post("/heart/check")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(new HeartRequest(token, 11L))))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}
