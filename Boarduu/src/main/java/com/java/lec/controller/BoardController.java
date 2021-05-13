package com.java.lec.controller;

import java.util.Map;

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
	public Map loginCheck(Member member) {
		
		Map map = boardservice.loginCheck(member);
		
		return map;
	}
}
