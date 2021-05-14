package com.java.lec.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.lec.model.Member;
import com.java.lec.service.BoardService;

@Controller
@RequestMapping("/")
public class BoardController {

	@Autowired
	BoardService boardservice;
	
	
	@RequestMapping("")
	public String main() {
		return "index";
	}
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	@RequestMapping("loginCheck")
	@ResponseBody
	public Member loginCheck(HttpServletRequest request,Member member) {
		System.out.println("컨트1");
		 Member mem = boardservice.loginCheck(member);
		 System.out.println("컨트2");
		 System.out.println("mem:"+mem);
		 if(mem != null) {
			 HttpSession session = request.getSession();
			 session.setAttribute("session_flag", "success");
			 session.setAttribute("session_id", mem.getId());
		 }
		 System.out.println("mem:"+ mem.getId() +"pw:"+mem.getPw() );
		 
		return mem;
	}
}
