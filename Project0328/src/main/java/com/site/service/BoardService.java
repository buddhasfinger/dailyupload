package com.site.service;

import java.util.Map;

import com.site.dto.BoardDto;
import com.site.dto.MemberDto;

public interface BoardService {
	
	
	MemberDto logincheck(MemberDto dto);
	
	Map<String, Object> hboardListAll(String page,String category,String search);

	Map<String, Object> boardContent_view(String hb_Seq, String page, String category, String search);

	void BoardWrite(BoardDto boardDto);

	void ReplyWrite(String hrw_Content, String hrw_User,String hrw_Group);


}
