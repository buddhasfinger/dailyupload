package com.library.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.service.study.StudyService;

@Controller
public class StudyController {
	
	@Autowired
	StudyService studyService;
	
	
	Map<String,Object> map;
	List list = new ArrayList();
	//int[] rs ;
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	@RequestMapping("/study/studyRoom")
	public String studyRoom() {
		return "/study/studyRoom";
	}
	@RequestMapping("/study/roomTime")
	public String roomTime() {
		return "/study/roomTime";
	}

	@RequestMapping("/study/dateCheck")
	@ResponseBody
	public Map dateCheck(@RequestParam("date") String rb_date,@RequestParam("roomNum") String sr_id,
			Model model) {
		Map map = new HashMap<String, Object>();
		System.out.println("date :" +rb_date);
		System.out.println("roomNum :" +sr_id);
		
		map.put("rs",studyService.dateCheck(Integer.parseInt(sr_id),rb_date) )	;
//		map.put("date", rb_date);
//		map.put("roomNum", sr_id);
		
		return map;
	}
}
