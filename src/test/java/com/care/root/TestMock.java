package com.care.root;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

@RunWith(SpringRunner.class) //서버로 구동하는게 아니라 테스트 환경으로 구동하겠다.
@ContextConfiguration(locations= {//특정 파일을 현재 위치로 불러오는 어노테이션
		"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMock {
	
	@Autowired MemberController mc;
	
	MockMvc mock;
	
	@Before
	public void setUp() {
		System.out.println("test실행전 실행");
		mock = MockMvcBuilders.standaloneSetup(mc).build(); //mc경로로 접근 가능
	}
	//@Test
	public void testIndex() throws Exception {
		System.out.println("===test 실행");
		
		mock.perform(get("/list"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/list"));
		
		Assert.assertNull(null);
	}
	
	@Test
	@Transactional(transactionManager = "txMgr")
	public void testInsert() throws Exception {
		mock.perform(post("/insert")
					.param("id", "565")
					.param("name", "kjst"))
				.andDo(print())
				.andExpect(status().is3xxRedirection());
				
	}
	
}
