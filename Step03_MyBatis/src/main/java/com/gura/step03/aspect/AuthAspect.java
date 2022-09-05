package com.gura.step03.aspect;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/*
 *    - Aspectj Expression
 * 
 *    1. execution(* *(..))
 *    	 => 접근 가능한 모든 메소드가 point cut
 *    2. execution(* test.service.*.*(..)) 
 *       => test.service 패키지의 모든 메소드 point cut
 *    3. execution(void insert*(..))
 *       =>리턴 type 은 void 이고 메소드명이 insert 로 시작하는 모든 메소드가 point cut
 *    4. execution(* delete*(*))
 *       => 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 메소드가 point cut (aop 가 적용되는 위치)
 *    5. execution(* delete*(*,*))
 *       => 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 메소드가 point cut (aop 가 적용되는 위치)
 *  6. execution(String update*(Integer,*))
 *       => 메소드 명이 update 로 시작하고 리턴 type 은 String 메소드의 첫번째 인자는 Integer type, 두번째 인자는 아무 type 다되는 메소드가 point cut (aop 가 적용되는 위치)
 *      
 */

@Aspect // aspect 역할을 할 수 있도록
@Component // Component scan 을 통해서 bean 이 될 수 있도록
public class AuthAspect {
	
	/*
	 * @Around(" aspectj expression ")
	 * 
	 * execution(ModelAndView auth*(..) 라는 aspectj expression 은
	 * 
	 * 리턴 type 은 ModelAndView 이고 메소드의 이름은 auth 로 시작하는 모든 메소드를 가리킨다.
	 * 
	 * 따라서 Spring 이 관리하는 객체 중에 위의 모양을 가지고 있는 메소드는 
	 * 
	 * 아래의 aspect 가 적용이 된다.
	 */
	
	   @Around("execution(org.springframework.web.servlet.ModelAndView auth*(..))")
	   public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
	      Object[] args=joinPoint.getArgs();
	      /*
	       * 아래의 for문을 풀어서 쓴 것 
	      	for(int i=0; i<args.length; i++) {
	    	  Object tmp = args[i];
	      	}
	      */
	      //메소드에 전달된 인자중에서 HttpServletRequest 객체를 찾는다.
	      for(Object tmp:args) {
	    	  // 만일 tmp 가 HttpServletRequest type 이라면 
	         if(tmp instanceof HttpServletRequest) {
	            //찾았으면 원래 type 으로 casting
	            HttpServletRequest request=(HttpServletRequest)tmp;
	            //HttpSession 객체의 참조값 얻어와서 로그인 여부를 알아낸다.
	            String id=(String)request.getSession().getAttribute("id");
	            if(id == null) {//만일 로그인을 하지 않았으면
	               //원래 가려던 url 정보 읽어오기
	               String url=request.getRequestURI();
	               //GET 방식 전송 파라미터를 query 문자열로 읽어오기 ( a=xxx&b=xxx&c=xxx )
	               String query=request.getQueryString();
	               //특수 문자는 인코딩을 해야한다.
	               String encodedUrl=null;
	               if(query==null) {//전송 파라미터가 없다면 
	                  encodedUrl=URLEncoder.encode(url);
	               }else {
	                  // 원래 목적지가 /test/xxx.jsp 라고 가정하면 아래와 같은 형식의 문자열을 만든다.
	                  // "/test/xxx.jsp?a=xxx&b=xxx ..."
	                  encodedUrl=URLEncoder.encode(url+"?"+query);
	               }

	               //로그인 페이지로 리다일렉트 할수 있는 ModelAndView 객체를 생성해서  -> spring framework가 직접 받아서 실행
	               ModelAndView mView=new ModelAndView();
	               mView.setViewName("redirect:/users/loginform.do?url="+encodedUrl);
	               return mView;
	            }
	         }
	      }

	      //로그인을 했으면 아래의 코드가 수행되고 ModelAndView 객체가 Object type 으로 리턴된다. 
	      Object obj=joinPoint.proceed();

	      return obj;
	   }
	   @Around("execution(java.util.Map auth*(..))")
	   public Object loginCheckAjax(ProceedingJoinPoint joinPoint) throws Throwable {
	      Object[] args=joinPoint.getArgs();
	      //메소드에 전달된 인자중에서 HttpServletRequest 객체를 찾는다.
	      for(Object tmp:args) {
	         if(tmp instanceof HttpServletRequest) {
	            //찾았으면 원래 type 으로 casting
	            HttpServletRequest request=(HttpServletRequest)tmp;
	            //HttpSession 객체의 참조값 얻어와서 로그인 여부를 알아낸다.
	            String id=(String)request.getSession().getAttribute("id");
	            if(id == null) {//만일 로그인을 하지 않았으면
	               //예외를 발생 시켜서 정상적인 응답을 받을수 없도록 한다. 일부러 500번 버스를 태운다
	               throw new RuntimeException("로그인이 필요 합니다.");
	            }
	         }
	      }

	      //로그인을 했으면 아래의 코드가 수행되고 ModelAndView 객체가 Object type 으로 리턴된다. 
	      Object obj=joinPoint.proceed();

	      return obj;
	   }
}
