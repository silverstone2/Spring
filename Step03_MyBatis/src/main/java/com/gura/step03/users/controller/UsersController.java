package com.gura.step03.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
	
	// 로그인 요청을 처리 할 컨트롤러 메소드
	@RequestMapping("/users/login")
	public ModelAndView login(String id, HttpSession session ) {
		// 입력한 아이디 비밀번호가 유효한 정보이면 로그인 처리를 한다.
		session.setAttribute("id", id); // 입력한 아이디를 session 영역에 담는다
		return new ModelAndView("users/login");
	}
	
	// 로그아웃 처리할 컨트롤러 메소드
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		// session 영역에 id 라는 키값으로 저장된 값 삭제하기
		session.removeAttribute("id"); //로그아웃 처리
		
		return "redirect:/home.do"; // 인덱스 페이지로 리다이렉트 시키기 
	}
	
	//로그인 폼 요청 처리를 할 컨트롤러 메소드
	   @RequestMapping("/users/loginform")
	   public String loginform() {
	      
	      return "users/loginform";
	   }
}
