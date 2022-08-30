package com.gura.step02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Controller 어노테이션을 import 해서 붙인다.
@Controller
public class SendController {
	
	// post 방식 /add.do 요청을 처리할 메소드
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(String content) {
		System.out.println("post 방식 요청 : "+content);
		return "result";
	}
	
	// get 방식 /add.do
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add2(String content) {
		System.out.println("get 방식 요청 : "+content);
		return "result";
	}
	
	/*
	 * 요청 파라미터 추출하는 방법 1
	 * 
	 * 메소드의 인자로 HttpServletRequest 객체를 전달 받은 다음
	 * 해당 객체의 getParameter() 메소드를 이요해서 추출한다(서블릿 or jsp 하던 방식 그대로)
	 * 
	 */
	
	@RequestMapping("/send")
	public String send(HttpServletRequest request) {
		
		// msg 라는 파라미터 명으로 전송되는 문자열 추출하기
		String msg = request.getParameter("msg");
		// 콘솔팡에 출력하기
		System.out.println("msg:"+msg);
		// 응답하기
		return "result";
	}
	
	/*
	 * 요청 파라미터 추출하는 방법 2
	 * 
	 * 파라미터 명과 동일한 이름의 매개 변수를 선언하면 자동으로 추출되어서 전달된다.
	 * 
	 * <input name = "msg">	-> String msg
	 * <input name = "num">	-> int num or String num
	 * xxx.do?msg=xxx		-> String msg
	 * xxx.do?num=xxx		-> int num or String num
	 * 
	 */
	
	@RequestMapping("/send2")
	public String send2(String msg) {
		
		// 콘솔팡에 출력하기
		System.out.println("msg:"+msg);
		// 응답하기
		return "result";
	}
}
