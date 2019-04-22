package com.nhfc99.test.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nhfc99.test.controller.DemoApplication;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {DemoApplication.class})
@AutoConfigureMockMvc
public class TestClass {
	@Autowired
	protected MockMvc mockMvc;
	
	@Test
	public void exampleTest() throws Exception {
		System.out.println("****hello world***********");
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test/config/getname")).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		System.out.println(mockHttpServletResponse.getContentAsString());
	}
	
	@Before
	public void beforeTest() {
		System.out.println("before");
	}
	
	@After
	public void afterTest() {
		System.out.println("after");
	}
}
