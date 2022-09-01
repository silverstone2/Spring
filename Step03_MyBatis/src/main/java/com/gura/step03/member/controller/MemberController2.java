package com.gura.step03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.member.dao.MemberDao;
import com.gura.step03.member.dto.MemberDto;
import com.gura.step03.member.service.MemberService;
/*
 *  컨트롤러에 대한 이해
 *  
 *  - 컨트롤러에서는 dao 를 이용한 비즈니스 로직 혹은 복잡한 비즈니스 로직 처리는 하지 않는게 원칙이다.
 *  - 따라서 컨트롤러에서 dao 에 의존하고 있다는 것은 바람직한 구조가 아니다.
 *  - 그럼 dao 를 활용한 비즈니스 로직처리는 어떻게 해야 하나 ?  
 *    답: 서비스 객체를 이용해서 비즈니스 로직을 처리 해야한다.
 *  - 따라서 컨트롤러는 dao 에 의존하지 말고 서비스에 의존하도록 해야 한다.
 *  - 그럼 컨트롤러에서는 무엇을 해야 하나 ?
 *    답: 클라이언트의 어떤 경로 요청에 대해서  어떤 서비스로 비즈니스 로직을 처리하고 
 *        어디로 어떻게 이동해서 응답해야 할지에 대한 작업만 하면 된다. 
 */   
@Controller
public class MemberController2 {
   
   @Autowired
   private MemberService service;
   
   @RequestMapping("/member/update")
   public String update(MemberDto dto) {
      
      //MemberService 객체를 이용해서 회원 정보 수정 반영
      service.updateMember(dto);
      
      //view page 로 forward 이동해서 응답 
      return "member/update";
   }
   
   
   @RequestMapping("/member/updateform")
   public ModelAndView updateform(int num, ModelAndView mView) {
      
      //MemberService 객체를 이용해서 ModelAndView 에 회원 한명의 정보가 담기도록 한다. 
      service.getMember(num, mView);
      
      //view page 의 정보를 ModelAndView 에 담기 
      mView.setViewName("member/updateform");
      
      return mView;
   }
   
   @RequestMapping("/member/delete")
   public String delete(int num) {
      
      //MemberService 객체를 이용해서 회원 정보 삭제하기
      service.deleteMember(num);
      
      /* /member/list.do  요청을 다시 하도록 리다일렉트 이동 시킨다
            리다일렉트 이동은 특정경로로 요청을 다시 하라고 강요하는 응답이다.
            
         "redirect: context 경로를 제외한 요청을 다시할 절대경로 " 
      */
      return "redirect:/member/list.do";
   }
   
   @RequestMapping("/member/insert")
   public ModelAndView insert(MemberDto dto) {
      //MemberService 객체를 이용해서 회원 한명의 정보 추가하기
      service.addMember(dto);
      
      // ModelAndView 객체의 생성자의 인자로 view page 의 정보를 넣어줄수도 있다.
      return new ModelAndView("member/insert");
   }
   
   
   @RequestMapping("/member/insertform")
   public ModelAndView insertform(ModelAndView mView) {
      
      //모델은 담지 않고 view page 정보만 담아서 리턴할수도 있다 
      mView.setViewName("member/insertform");
      return mView;
   }
   
   @RequestMapping("/member/list")
   public ModelAndView list() {
      
      // Model 과 view page 의 정보를 동시에 담을 객체를 생성해서 
      ModelAndView mView=new ModelAndView();
      
      //MemberService 객체를 이용해서 ModelAndView 객체에 회원목록을 담아온다.
      service.getListMember(mView);
      
      // view page 의 정보도 담고 
      mView.setViewName("member/list");
      // ModelAndView 객체를 리턴해주면 동일하게 동작한다. 
      return mView;
      
   }
}








