package woo.edu.c.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import woo.edu.c.controller.HomeController;
import woo.edu.c.vo.boardVO;
import woo.edu.c.vo.testVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// mybatis
	@Inject
	private SqlSession sql;
	
	private static String namespace = "boardMapper";

	@Override
	public List<testVo> test() {
		return sql.selectList(namespace + ".test");
	}

	@Override
	public List<boardVO> listAll() {
		
		return sql.selectList(namespace +".list");
	}

	@Override
	public boardVO contentView(int bid) {
		return sql.selectOne(namespace +".contentView",bid);
	}

	@Override
	public void writeCheck(boardVO vo) {
		sql.insert(namespace +".writeCheck",vo);
	}

	@Override
	public void modifyCheck(boardVO vo) {
		sql.update(namespace +".modifyCheck",vo);
	}

	@Override
	public void boardDelete(int bid) {
		sql.delete(namespace +".boardDelete",bid);
	}

	
}
