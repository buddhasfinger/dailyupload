package com.java.lec.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.lec.dao.BoardDao;
import com.java.lec.model.Board;
import com.java.lec.model.Member;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	@Autowired
	PageNumber pageNumber;
	
	Board board;
	List<Board> list;
	Map map = new HashMap<String, Object>();
	int check=0;
	
	@Override
	public Member loginCheck(Member member) {
		return dao.loginCheck(member);
	}

//	@Override
//	public Map<String, Object> ListAll(String listPage, String category, String search) {
//		System.out.println("서비스임플 카테고리 전 search : "+search);
//		Map map = new HashMap<String, Object>();
//		list = new ArrayList<Board>();
//		int page = 1;// 처음 들어왔을때 페이지 초기화
//		int limit = 10;// 페이지가 나오는 갯수
//		if (listPage != null && listPage != "") {
//			page = Integer.parseInt(listPage);
//		}
//		int startrow = (page - 1) * limit + 1; // 시작 게시글번호 1,11,21...
//		int endrow = startrow + limit - 1; // 마지막 게시글번호 10,20,30...
//
//		if (category == null || category.equals("")) {
//			list = dao.selectboardListAll(startrow, endrow);
//		} 
////		else if (category.equals("all")) { // opt:title search:제목
////			System.out.println("프리보드서비스 임플 전체검색: "+search);
////			list = dao.selectFreeboardListTitle(startrow, endrow, search);
////		} else if (category.equals("title")) { // opt:title search:제목
////			System.out.println("프리보드서비스 임플 제목검색: "+search);
////			list = dao.selectFreeboardListContent(startrow, endrow, search);
////		} else if (category.equals("content")) { // opt:title search:제목
////			System.out.println("프리보드서비스 임플 내용 검색: "+search);
////			list = dao.selectFreeboardListSearchAll(startrow, endrow, search);
////		}
//		map = pageNumber.PageNumber(page, limit, category, search);
//		System.out.println("freeboardImplpageNumber 내용 : "+pageNumber.PageNumber(page, limit, category, search));
//		map.put("list", list);
//		return map;
//	}

	@Override
	public Map<String, Object> ListAll() {
		System.out.println("리스트3");
		list = dao.selectboardListAll();
		System.out.println("리스트4");
		map.put("list", list);
		return map;
	}

	@Override
	public void boardWrite(Board board, MultipartFile file) {
		// 원본파일이름
		String fileName = file.getOriginalFilename();
		// 확장자명 가져오기
		String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
		if (fileNameExtension != "") {
			String fileUrl = "C:\\Users\\Jason\\git\\dailyupload3\\Boarduu\\src\\main\\webapp\\resources\\upload\\";
			
			// 파일 이름 재정의
			String uploadFileName = RandomStringUtils.randomAlphanumeric(20) + "." + fileNameExtension;

			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			board.setBfilename(uploadFileName);
		}else {
			board.setBfilename("");
		}
		
		//dao 전달
		dao.insertBoardWrite(board);
		
	}//write

	@Override
	public Board contentView(String bid, String search, String category, String page) {
			
		//조회수 1증가
		dao.selectUpHit(bid);
		
		//content 1개 가져오기
		board =	dao.selectContent_view(bid);
		
		return board;
	}

	@Override
	public int bpwcheck(String bpw,int bid) {
		String rs = dao.selectbpwcheck(bpw,bid);
		if(rs==null) {
			check=1;
		}else {
			check=0;
		}
		return check;
	}

}
