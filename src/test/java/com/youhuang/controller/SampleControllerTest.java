package com.youhuang.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.youhuang.demo.DemoSpringApplication;
import com.youhuang.demo.SampleController;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DemoSpringApplication.class)
@WebAppConfiguration
public class SampleControllerTest {

    private MockMvc mvc;
    
    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SampleController()).build();
    }
    
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/index").param("key1", "value1").param("key2", "value2"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("indexx")));
    }
}
