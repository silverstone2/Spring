package com.gura.step02.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @ 어노테이션을 많이 사용할 예정입니다.
 * 
 * 어노테이션에 대한 이해!
 * 
 * - 어노테이션이 붙은 클래스는 그 모양 그대로 사용되지 않고 런타임시에 변형되어서 사용된다.
 * 
 * 어떤 변형이 될까
 * 
 * 특정 클래스를 상속 받기도 하고, 특정 인터페이스를 구현하기도 하고
 * 없던 메소드가 만들어지기도 하고, 없던 필드가 추가되기도 하고 동등의 작업이 자동화되어 있다.
 */

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
