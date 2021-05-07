package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardservice;
	
	@RequestMapping("/main")
	public String main() {
		System.out.println("main실행");
		return "/main";
	}
	
	@RequestMapping("member/join")
	public String join() {
		System.out.println("join실행");
		return ("/member/join");
	}
	@RequestMapping("member/login")
	public String login() {
		System.out.println("login실행");
		return ("/member/login");
	}
	
}
