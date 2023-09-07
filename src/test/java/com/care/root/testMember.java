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
Junit : test �����ϱ� ���� �����ӿ�ũ(��ɵ��� ����)
test �ֵ� ����
���� �׽�Ʈ(�޼ҵ� ��), ���� �׽�Ʈ
*/
@RunWith(SpringRunner.class) //������ �����ϴ°� �ƴ϶� �׽�Ʈ ȯ������ �����ϰڴ�.
@ContextConfiguration(locations= {//Ư�� ������ ���� ��ġ�� �ҷ����� ������̼�
		"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"}) 
public class testMember {
	
	@Autowired MemberController mc;
	@Test
	public void testMc() {
		assertNotNull(mc); 
		//�ش� ��(��ü)�� null�� �ƴϸ� ����
		//���� ���� null �̸� ����
		System.out.println(mc);
	}
	
	@Autowired MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
		MemberDTO dto = new MemberDTO();
		dto.setId(2);
		dto.setName("��");
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
		dto.setName("��");
		int result = dao.insertMember(dto);
		System.out.println("result : "+ result);
		assertEquals(result, 1);
	}
}
