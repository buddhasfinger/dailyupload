package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.MemberDto;
import com.site.mapper.Board_Mapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	Board_Mapper board_mapper;
	
	@Override
	public MemberDto logincheck(MemberDto dto) {
		MemberDto memberDto =board_mapper.selectloginCheck(dto);
		return memberDto;
	}

	
	
}
