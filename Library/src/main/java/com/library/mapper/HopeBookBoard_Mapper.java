package com.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.library.dto.HopeBookBoardDto;
import com.library.dto.lMemberDto;

@Mapper
public interface HopeBookBoard_Mapper {
	lMemberDto selectloginCheck(lMemberDto dto);
	
	//리스트 가져오기
		List<HopeBookBoardDto> selectBoardListAll(@Param("startrow") int startrow,@Param("endrow") int endrow);
		List<HopeBookBoardDto> selectBoardListTitle(int startrow, int endrow, String search);
		List<HopeBookBoardDto> selectBoardListContent(int startrow, int endrow, String search);
		List<HopeBookBoardDto> selectBoardListSearchAll(int startrow, int endrow, String search);
		
		//list 개수 가져오기
		int listCount();
		int listCountTitle(String search);
		int listCountContent(String search);
		int listCountSearchAll(String search);
		
		//content_view
		HopeBookBoardDto selectBoardContent_view(String hb_Seq);
		void selectUpHit(String hb_Seq);
		//write
		void insertBoardWrite(HopeBookBoardDto boardDto);

		void insertReplyWrite(String hrw_Content, String hrw_User, String hrw_Group);
}
