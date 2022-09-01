package com.gura.step03.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.step03.todo.dao.TodoDao;
import com.gura.step03.todo.dto.TodoDto;

@Controller
public class TodoController {
	
	// spring bean container 로 부터 MemberDao 인터페이스 type 의 참조값을 DI 받는다.
	@Autowired
	private TodoDao dao;
	
	
	@RequestMapping("/todo/delete")
	public String delete(int num) {
		dao.delete(num);
		return "todo/delete";
	}
	
	@RequestMapping("/todo/update")
	public String update(TodoDto dto) {
		
		dao.update(dto);
		return "todo/update";
	}
	
	@RequestMapping("/todo/updateform")
	public String updateform(int num, HttpServletRequest request) {
		TodoDto dto = dao.getData(num);
		request.setAttribute("dto", dto);
		return "todo/updateform";
	}
	
	@RequestMapping("/todo/insert")
	public String insert(TodoDto dto) {

		dao.insert(dto);
		return "todo/insert";
	}
	
	@RequestMapping("/todo/insertform")
	public String insertform() {
		
		return "todo/insertform";
	}
	
	@RequestMapping("/todo/list")
	public String list(HttpServletRequest request) {
		
		List<TodoDto> list = dao.getList();
		
		request.setAttribute("list", list);
		
		return "todo/list";
	}
}
