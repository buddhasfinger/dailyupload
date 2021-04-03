package com.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.MemberDto;

@Mapper
public interface Board_Mapper {
	
	
	MemberDto selectloginCheck(MemberDto dto);
}
