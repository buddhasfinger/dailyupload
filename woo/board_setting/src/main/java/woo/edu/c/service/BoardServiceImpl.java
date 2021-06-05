package woo.edu.c.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import woo.edu.c.controller.HomeController;
import woo.edu.c.dao.BoardDao;
import woo.edu.c.vo.boardVO;
import woo.edu.c.vo.testVo;


@Service
public class BoardServiceImpl implements BoardService{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	Map<String,Object> map = new HashMap<String,Object>();
	List<boardVO> list = new ArrayList<boardVO>();
	boardVO vo;
	@Resource
	private BoardDao boardDao;


	@Override
	public List<boardVO> listAll() {
		list = boardDao.listAll();
		return list;
	}


	@Override
	public List<testVo> test() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boardVO boardContent_view(int bid) {
		vo = boardDao.contentView(bid);
		return vo;
	}


	@Override
	public void boardWrite(boardVO vo) {
		boardDao.writeCheck(vo);
	}


	@Override
	public void modifyCheck(boardVO vo) {
		boardDao.modifyCheck(vo);
		
	}


	@Override
	public void boardDelete(int bid) {
		System.out.println("임플1");
		boardDao.boardDelete(bid);
		System.out.println("임플2");
	}
	
}
