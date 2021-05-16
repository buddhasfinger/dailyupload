package com.java.lec.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.lec.model.Board;
import com.java.lec.model.Member;
import com.java.lec.service.BoardService;

@Controller
@RequestMapping("/")
public class BoardController {

	@Autowired
	BoardService boardservice;
	
	
	ArrayList<Board> list = new ArrayList();
	
	Board board;
	int check;
	
	@RequestMapping("")
	public String main() {
		return "index";
	}
	
	//게시판 전체리스트
	@RequestMapping("/list")
	public String freeboardlist(@RequestParam(required = false) String page,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String search,Model model) {
		
		//System.out.println("컨트롤러  search : "+search);
		
		//Map<String, Object> map = boardservice.ListAll(page,category,search);
		System.out.println("리스트1");
		Map<String, Object> map = boardservice.ListAll();
		System.out.println("리스트2");
		model.addAttribute("map",map);
		return"list";
		
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	@ResponseBody
	public String write(Board board,MultipartFile file) {
		System.out.println("컨트1");
		boardservice.boardWrite(board,file);
		System.out.println("컨트1");
		return "redirect:/list";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam(required = false) String page,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String search,
			@RequestParam(required = false) String bid,
			Model model) {
			
		board = boardservice.contentView(bid,search,category,page);
		
		model.addAttribute("board",board);
		return "/content_view";
	}
	
	@RequestMapping("/popup")
	public String popup(int bid,Model model) {
		System.out.println("bid:"+bid);
		model.addAttribute("bid",bid);
		return "popup";
	}
	
	@RequestMapping("/bpwCheck")
	@ResponseBody
	public int bpwCheck(String bpw,int bid) {
		System.out.println("bpw,bid"+bpw+","+bid);
		check =boardservice.bpwcheck(bpw,bid);
		return check;
	}
	
	@RequestMapping("login")
	public String login() {
		System.out.println("login진입");
		return "login";
	}
	@RequestMapping("loginCheck")
	@ResponseBody
	public Member loginCheck(HttpServletRequest request,Member member) {
		
		 Member mem = boardservice.loginCheck(member);
		 if(mem != null) {
			 HttpSession session = request.getSession();
			 session.setAttribute("session_flag", "success");
			 session.setAttribute("session_id", mem.getLm_user());
			 session.setAttribute("session_nname", mem.getLm_nname());
		 }
		 
		return mem;
	}
	
	@RequestMapping("logout")
	public String logout() {
		
		return "logout";
	}
	
}
