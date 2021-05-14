package com.java.lec.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.lec.model.Member;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public Member loginCheck(Member member) {
		System.out.println("다오입장");
		Member mem = sql.selectOne("member.login",member);
		System.out.println("다오퇴장");
		return mem ; 
		//return sql.selectOne("board.login",member); 
	}

}
