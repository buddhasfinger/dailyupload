package woo.edu.c.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import woo.edu.c.vo.boardVO;
import woo.edu.c.vo.testVo;

public interface BoardService {

	List<testVo> test();

	List<boardVO> listAll();

	boardVO boardContent_view(int bid);

	void boardWrite(boardVO vo);

	void modifyCheck(boardVO vo);

	void boardDelete(int bid);


}
