package com.gura.step03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayController {
	
	@RequestMapping("/play")
	public ModelAndView authPlay(ModelAndView mView, HttpServletRequest request) {
		
		mView.setViewName("play");
		
		return mView;
	}
	
	@RequestMapping("/sub/play2")
	public ModelAndView authPlay2(ModelAndView mView, HttpServletRequest request) {
		
		mView.setViewName("sub/play2");
		
		return mView;
	}
	
}
