package com.care.root;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

/*
Junit : test 진행하기 위한 프레임워크(기능들의 집합)
test 주도 개발
단위 테스트(메소드 별), 통합 테스트
*/
@RunWith(SpringRunner.class) //서버로 구동하는게 아니라 테스트 환경으로 구동하겠다.
@ContextConfiguration(locations= {//특정 파일을 현재 위치로 불러오는 어노테이션
		"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"}) 
public class testMember {
	
	@Autowired MemberController mc;
	@Test
	public void testMc() {
		assertNotNull(mc); 
		//해당 빈(객체)이 null이 아니면 성공
		//만약 빈이 null 이면 실패
		System.out.println(mc);
	}
	
	@Autowired MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
		MemberDTO dto = new MemberDTO();
		dto.setId(2);
		dto.setName("길");
		int result = ms.insertMember(dto);
		System.out.println("result : "+ result);
		assertEquals(result, 1);
	}
	
	@Autowired MemberDAO dao;
	@Test
	public void testDao() {
		assertNotNull(dao);
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("동");
		int result = dao.insertMember(dto);
		System.out.println("result : "+ result);
		assertEquals(result, 1);
	}
}
