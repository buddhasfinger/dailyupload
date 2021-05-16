package com.java.lec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.lec.model.Board;
import com.java.lec.model.Member;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public Member loginCheck(Member member) {
		Member mem = sql.selectOne("member.login",member);
		return mem ; 
		//return sql.selectOne("board.login",member); 
	}

	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> selectboardListAll() {
		return sql.selectList("board.list");
	}
//	@Override
//	public List<Board> selectboardListAll(int startrow, int endrow) {
//		return sql.selectlist;
//	}

	@Override
	public void insertBoardWrite(Board bod) {
		System.out.println("bod:"+ bod.getBpw());
		sql.insert("board.insertboard",bod);
		System.out.println("dao2");
	}

	@Override
	public void selectUpHit(String bid) {
		sql.update("board.hitup",bid);
	}

	@Override
	public Board selectContent_view(String bid) {
		return sql.selectOne("board.contentView",bid);
	}

	@Override
	public String selectbpwcheck(String bpw,int bid) {
		Map map = new HashMap<String, Object>();
		map.put("bpw", bpw);
		map.put("bid", bid);
		
		return sql.selectOne("board.bpwcheck",map);
		
	}

}
