package com.site.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.BoardDto;
import com.site.dto.MemberDto;
import com.site.service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	BoardService bs;
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam @Nullable String page,
			@RequestParam @Nullable String category,
			@RequestParam @Nullable String search, 
			Model model) {
		System.out.println("page :"+page);
		Map<String, Object> map = bs.hboardListAll(page,category,search);
		model.addAttribute("map",map);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam @Nullable String page,
			@RequestParam @Nullable String category,
			@RequestParam @Nullable String search, 
			@RequestParam @Nullable String hb_Seq, 
			Model model) {
		map = bs.boardContent_view(hb_Seq, page, category, search);
		model.addAttribute("map",map);
		
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view(@RequestParam String hb_User,Model model) {
		model.addAttribute("hb_User",hb_User);
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String  write(BoardDto boardDto) {
		System.out.println("hb_User "+boardDto.getHb_User());
		System.out.println("hb_Title "+boardDto.getHb_Title());
		bs.BoardWrite(boardDto);
		return "redirect:/list";
	}

	@RequestMapping("/hrwrite")  
	@ResponseBody
	public Map<String, Object> hrwrite(HttpServletRequest request,String hrw_Content,String hrw_User,String hrw_Group) {
		System.out.println("hrw_Content "+hrw_Content);
		System.out.println("hrw_User "+hrw_User);
		System.out.println("hrw_Group "+hrw_Group);
		//bs.ReplyWrite(hrw_Content,hrw_User,hrw_Group);
		map.put("hrw_Content", hrw_Content);
		map.put("hrw_User", hrw_User);
		map.put("hrw_Group", hrw_Group);
		
		return map;
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
		
		//model.addAttribute("redirect",redirect); //로그인 후 메인을 안가고, 해당 페이지로 가려고함.
		//return "login_check2"; 콘트롤러를 안거치고 login_check2.jsp로 가버림
		return "redirect:/login_check2"; //콘트롤러를 거쳐서 /login_check2 로 감.
	}
	
	@RequestMapping("/login_check2")
	public String login_check2() {
		return "login_check2";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	
}
