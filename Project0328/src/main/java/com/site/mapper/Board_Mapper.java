package com.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.BoardDto;
import com.site.dto.MemberDto;

@Mapper
public interface Board_Mapper {
	MemberDto selectloginCheck(MemberDto dto);
	
	//리스트 가져오기
		List<BoardDto> selectBoardListAll(int startrow,int endrow);
		List<BoardDto> selectBoardListTitle(int startrow, int endrow, String search);
		List<BoardDto> selectBoardListContent(int startrow, int endrow, String search);
		List<BoardDto> selectBoardListSearchAll(int startrow, int endrow, String search);
		
		//list 개수 가져오기
		int listCount();
		int listCountTitle(String search);
		int listCountContent(String search);
		int listCountSearchAll(String search);
		
		//content_view
		BoardDto selectBoardContent_view(String hb_Seq);
		void selectUpHit(String hb_Seq);
		//write
		void insertBoardWrite(BoardDto boardDto);

		void insertReplyWrite(String hrw_Content, String hrw_User, String hrw_Group);
}
