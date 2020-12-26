package com.zg.sell.controller;

import com.zg.sell.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    //todo：两个都报空引用
    @Autowired
    private MockMvc mvc;

    @Test
    void getAllEmployee() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/all")).andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.content().string("mm"));
    }
    @Test
    void findOne() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/employee/2")).andExpect(MockMvcResultMatchers.status().isOk());
        //.andExpect(MockMvcResultMatchers.content().string("mm"));

    }
}