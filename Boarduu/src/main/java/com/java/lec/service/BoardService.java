package com.java.lec.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.java.lec.model.Board;
import com.java.lec.model.Member;

public interface BoardService {

	Member loginCheck(Member member);

	Map<String, Object> ListAll();
//	Map<String, Object> ListAll(String page, String category, String search);

	void boardWrite(Board board, MultipartFile file);

	Board contentView(String bid, String search, String category, String page);

	int bpwcheck(String bpw, int bid);

}
