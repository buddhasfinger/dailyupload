package com.java.lec.dao;

import java.util.List;

import com.java.lec.model.Board;
import com.java.lec.model.Member;

public interface BoardDao {

	Member loginCheck(Member member);

	int listCount();

	List<Board> selectboardListAll();
//	List<Board> selectboardListAll(int startrow, int endrow);

	void insertBoardWrite(Board board);

	void selectUpHit(String bid);

	Board selectContent_view(String bid);

	String selectbpwcheck(String bpw, int bid);

}
