package com.gura.step03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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
	
}
