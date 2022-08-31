package com.gura.step02;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	
	// /home.do 요청이 왔을 때 동작하는 컨트롤러 메소드
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		
		// DB 에서 읽어온 공지사항 이라고 가정하자
		List<String> noticeList = new ArrayList<>();
		noticeList.add("Spring Framework 시작입니다.");
		noticeList.add("화이팅!");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");
		
		// view page(jsp page) 에 전달할 Model(data) 을 request 영역에 담기
		request.setAttribute("noticeList", noticeList);
		
		// /WEB-INF/views/home/jsp 페이지로 forward 이동해서 응답
		return "home";
	}
	
	/*
	 * 어떤 요청에 대해서 동작을 할지 요청 경로를 명시한다,
	 * .do는 생략 가능하다
	 * 메소드의 return type 은 String or ModelAndView 이다.
	 * 메소드명은 마음대로 지을 수 있다,
	 * 메소드에 필요한 인자는 필요시에 선언하면 해당 객체의 참조값이 알아서 전달된다.
	 * 전달되는 type : HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView 등등
	 */
	
	@RequestMapping("/study.do") // 반드시 /로 시작해야한다.
	public String study() {
	
		// /WEB-INF/views/study.jsp 페이지로 forward 이동해서 응답
		return "study"; // /로 시작하면 안된다
	}
	
	@RequestMapping("/sub/play.do")
	public String play() {
	
		return "sub/play";
	}
	
}
