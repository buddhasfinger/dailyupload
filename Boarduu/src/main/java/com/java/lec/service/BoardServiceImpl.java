package com.java.lec.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.lec.dao.BoardDao;
import com.java.lec.model.Member;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	Map map = new HashMap<String, Object>();
	
	@Override
	public Member loginCheck(Member member) {

		
		
		return dao.loginCheck(member);
	}

}
