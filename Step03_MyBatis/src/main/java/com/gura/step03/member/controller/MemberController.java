package com.gura.step03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.step03.member.dao.MemberDao;
import com.gura.step03.member.dto.MemberDto;

/*
 *	컨트롤러에 대한 이해
 *
 *	- 컨트롤러에서는 dao 를 이용한 비지니스 로직 혹은 복잡한 비지니스 로직 처리는 하지 안는 것이 원칙이다.
 *	- 따라서 컨트롤러에서 dao 에 의존하고 있다는 것은 바람직한 구조가 아니다.
 *	- 그럼 dao 를 활용한 비지니스 로직 처리는 어떻게 해야하나?
 *
 *	- 답 : 서비스 객체를 이요해서 비지니스 로직을 처리해야한다.
 *
 *	- 따라서 컨트롤러는 dao 에 의존하지 않고 서비스에 의존하도록 해야 한다.
 *	- 그럼 컨트롤러에서는 무엇을 해야 하는가?
 *
 *	- 답 : 클라이언트의 어떤 경로 요청에 대해서 어떤 서비스로 비지니스 로직을 처리하고
 *		    어디로 어떻게 이동해서 응답해야 할지에 대한 작업만 하면 된다.
 */

//@Controller
public class MemberController {
	
	// spring bean container 로 부터 MemberDao 인터페이스 type 의 참조값을 DI 받는다.
	@Autowired
	private MemberDao dao; //controller에 의해서 dao에 의존하고 있음.
	
	
	@RequestMapping("/member/delete")
	public String delete(int num) {
		// MemberDao 객체를 이용해서 DB 에서 삭제하고
		dao.delete(num);
		// view page 로 forward 이동해서 응답한다.
		return "member/delete";
	}
	
	@RequestMapping("/member/update")
	public String update(MemberDto dto) {
		
		dao.update(dto);
		return "member/update";
	}
	
	@RequestMapping("/member/updateform")
	public String updateform(int num, HttpServletRequest request) {
		// MemberDao 객체를 이용해서 수정할 회원의 정보를 DB 에서 불러온다.
		MemberDto dto = dao.getData(num);
		
		// view page 에 전달할 모델(data) 를 request 영역에 담는다
		request.setAttribute("dto", dto);
		
		// view page 로 forward 이동해서 수정할 회원폼을 출력해준다.
		return "member/updateform";
	}
	
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) {
		
		// MemberDao 객체를 이용해서 추가하기
		dao.insert(dto);
		// view page 로 forward 이동해서 응답하기
		return "member/insert";
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		
		return "member/insertform";
	}
	
	@RequestMapping("/member/list")
	public String list(HttpServletRequest request) {
		
		List<MemberDto> list = dao.getList();
		
		request.setAttribute("list", list);
		/*
		 *	/WEB-INF/views/member/list.jsp 페이지로 forward 이동해서
		 *	회원목록을 출력하면 된다.
		 *
		 *	그런데... 회원 목록은 어떻게 얻어올까?
		 *
		 *	MemberDaoImpl 가 없으면 된다.
		 */
		
		return "member/list";
	}
}
