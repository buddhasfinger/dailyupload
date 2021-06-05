package woo.edu.c.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import woo.edu.c.service.BoardService;
import woo.edu.c.vo.boardVO;
import woo.edu.c.vo.testVo;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	Map<String,Object> map = new HashMap<String,Object>();
	List<boardVO> list = new ArrayList<boardVO>();
	boardVO vo;
	int rs;
	String rss;
	
	@Inject
	private BoardService boardService;
	
	// 메인 화면
	@RequestMapping(value = "/")
	public String home(Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "crud";
	}
	
	//게시판 전체 리스트1
	@RequestMapping("/board/crudBoard")
	public String crudBoard(Model model) {
		list = boardService.listAll();
		model.addAttribute("list",list);
		return "/board/crudBoard";
	}
	//게시판 전체 리스트2 -ajax
	@RequestMapping("/board/ajaxCrudBoard")
	public String ajaxCrudBoard(Model model) {
		list = boardService.listAll();
		model.addAttribute("list",list);
		return "/board/ajaxCrudBoard";
	}
	//게시판 전체 리스트 -ajax
	@RequestMapping("/board/listAll")
	@ResponseBody
	public List<boardVO> listAll() {
		list = boardService.listAll();
		return list;
	}
	
	//컨텐츠 뷰
	@RequestMapping("/contentView")
	public String contentView(@RequestParam int bid,Model model ) {
		System.out.println("bid:"+bid);
		vo = boardService.boardContent_view(bid);
		model.addAttribute("vo",vo);
		return "/board/contentView";
	}
	//Ajax컨텐츠 뷰
	@RequestMapping("/contentView1")
	@ResponseBody
	public boardVO contentView1(@RequestParam int bid,Model model ) {
		System.out.println("bid:"+bid);
		vo = boardService.boardContent_view(bid);
		System.out.println("vo"+vo);
		return vo;
	}
	
	//글쓰기 화면
	@RequestMapping("/board/write")
	public String write_View(Model model) {
		return "/board/write";
	}
	//글쓰기 저장
	@RequestMapping("/board/writeCheck")
	public String writeCheck(boardVO vo) {
		boardService.boardWrite(vo);
		return "redirect:/board/crudBoard";
	}
	//Ajax글쓰기 저장
	@RequestMapping("/board/writeCheck1")
	@ResponseBody
	public String writeCheckAjax(boardVO vo) {
		boardService.boardWrite(vo);
		
		return rss;
	}
	//수정 화면
	@RequestMapping("/board/modifyView")
	public String modifyView(@RequestParam int bid,Model model) {
		System.out.println("bid"+bid);
		vo = boardService.boardContent_view(bid);
		model.addAttribute("vo",vo);
		return "/board/modifyView";
	}
	//수정 저장
		@RequestMapping("/board/modifyCheck")
		public String modifyCheck(boardVO vo) {
			System.out.println("vo:"+vo);
			boardService.modifyCheck(vo);
			return "redirect:/board/crudBoard";
		}
		
	//글 삭제하기
	@RequestMapping("/board/boardDelete")
	public String boardDelete(@RequestParam int bid) {
		System.out.println("bid"+bid);
		boardService.boardDelete(bid);
		return "redirect:/board/crudBoard";
	}	
	//Ajax글 삭제하기
		@RequestMapping("/board/boardDeleteAjax")
		@ResponseBody
		public String boardDeleteAjax(@RequestParam int bid,Model model) {
			System.out.println("bid"+bid);
			boardService.boardDelete(bid);
			return rss;
		}	
		
	//구구단,색깔바꾸기,4열숫자판
		@RequestMapping("/wooTest3")
		public String wooTest3() {
			return "/board/wooTest3";
		}
		
	
	// test
	@RequestMapping(value = "/board/test", method = RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		List<testVo> test = boardService.test();
		model.addAttribute("boardList", test);
		return "/board/boardhome";
	}
		
		
}




