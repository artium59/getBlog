package com.web.blog.controller.account;

import com.web.blog.dao.user.UserDao;
import com.web.blog.model.user.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Optional;
import javax.transaction.Transactional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        properties = {
                "email = test@test.com",
                "nickname = test"
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Transactional
@AutoConfigureMockMvc
class AccountControllerTest {

    @Value("${email}")
    private String email;

    @Value("${nickname}")
    private String nickname;

    @Autowired
    MockMvc mvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserDao userDao;

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
    void getUserInfo() throws Exception {
        // reset this
        final String token = "eyJhbGciOiJIUzUxMiJ9" +
                ".eyJzdWIiOiIzMiIsImlhdCI6MTU5NzkyNzM0NywiZXhwIjoxNTk4MDEzNzQ3LCJlbWFpb" +
                "CI6InRlc3RAdGVzdC5jb20iLCJyb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19" +
                ".gKemZAbUgmtgNQVTglMGvAUGbFKIKwPoK9g-5jXugpVEpETNOENwGaObXUp2V4IfO2amgrVNYQhvBmfZ9NGaTQ";

        // MOC MVC test
        mvc.perform(get("/account/userinfo").param("accessToken", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nickname", is("test")))
                .andDo(print());

        // MockBean test
        Optional<User> user = userDao.findById(32L);
        if (user.isPresent()) {
            then("test").isEqualTo(user.get().getNickname());
            then("test@test.com").isEqualTo(user.get().getEmail());
        }
    }
}
