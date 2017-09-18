package com.ymedaghri.retrogames.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetroGameControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void shouldGetUnauthorizedWithoutRole() throws Exception{

        this.mvc.perform(get("/api/games"))
                .andExpect(status().isUnauthorized());
    }


    @Test
    public void testRetrieveRetrocards() throws Exception {
        this.mvc.perform(get("/api/games"))
                .andExpect(status().isOk());
                //.andDo(MockMvcResultHandlers.print())
                //.andExpect(content().json("{'data':[{'useRegEx':'false','hosts':'v2v2v2'}]}"));

    }
}