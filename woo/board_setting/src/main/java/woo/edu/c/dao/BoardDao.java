package woo.edu.c.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import woo.edu.c.vo.boardVO;
import woo.edu.c.vo.testVo;

public interface BoardDao {

	List<testVo> test();

	List<boardVO> listAll();

	boardVO contentView(int bid);

	void writeCheck(boardVO vo);

	void modifyCheck(boardVO vo);

	void boardDelete(int bid);


}
