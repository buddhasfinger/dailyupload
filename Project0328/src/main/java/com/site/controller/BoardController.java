package com.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.MemberDto;
import com.site.service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	BoardService bs;
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login_check")
	public String login_check(MemberDto dto,HttpServletRequest request,RedirectAttributes attr,Model model) {
		String redirect= request.getParameter("redirect");
		HttpSession session= request.getSession();
		MemberDto memberdto= bs.logincheck(dto);
		if(memberdto==null) {
			System.out.println("로그인 실패");
			session.setAttribute("session_flag", "fail");
		}else {
			System.out.println("성공");
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", memberdto.getId());
			session.setAttribute("session_name", memberdto.getName());
		}
		
		model.addAttribute("redirect",redirect);
		//return "login_check2"; 콘트롤러를 안거치고 login_check2.jsp로 가버림
		return "redirect:/login_check2"; //콘트롤러를 거쳐서 /login_check2 로 감.
	}
	
	@RequestMapping("/login_check2")
	public String login_check2() {
		return "login_check2";
	}
	
}
