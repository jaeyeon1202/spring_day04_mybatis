package com.care.root;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cookie")
public class CookieController {
	
	@Autowired(required = false)
	TestClass tc;
	
	@GetMapping("index")
	public String index(HttpServletResponse res) {
		System.out.println("index 실행");
		System.out.println(tc);
		
		Cookie cookie = new Cookie("key", "12345");
		cookie.setMaxAge(5);
		res.addCookie(cookie);
		
		return "cookie/index";
	}
	
	@GetMapping("result")
	public String result(HttpServletRequest req) {
		System.out.println("result 실행");
		Cookie[] arr = req.getCookies();
		for(Cookie c : arr) {
			System.out.println("name : "+c.getName());
			System.out.println("value : "+c.getValue());
			System.out.println("=======================");
		}
		
		return null;
	}
	
	@GetMapping("result02")
	public String result02(@CookieValue(value="key", required=false) Cookie cook) {
		System.out.println("result02 실행");
		
		System.out.println("cook: "+cook);
		if(cook != null) {
			System.out.println(cook.getName());
			System.out.println(cook.getValue());
		}
		return null;
	}
}
