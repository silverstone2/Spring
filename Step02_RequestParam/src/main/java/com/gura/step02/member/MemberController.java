package com.gura.step02.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		
		// /WEB-INF/views/member/insertform.jsp 페이지에서 응답하기
		return "member/insertform";
	}
	
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) {
		// HttpServletRequest 객체의 메소드를 이용해서 파라미터 추출하기
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		System.out.println(num+"|"+name+"|"+addr);
		
		return "member/insert";
	}
	
	// 컨트롤러 메소드의 매개변수를 이용해서 파라미터 추출하기
	@RequestMapping("/member/insert2")
	public String insert2(int num, String name, String addr) {
		
		 System.out.println(num+"|"+name+"|"+addr);
		
		return "member/insert";
	}
	
	// 컨트롤러 메소드의 매개변수에 dto를 선언해도 된다.
	@RequestMapping("/member/insert3")
	public String insert3(MemberDto dto) {
		
		System.out.println(dto.getNum()+"|"+dto.getName()+"|"+dto.getAddr());
		
		return "member/insert";
	}
}
