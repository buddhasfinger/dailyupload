package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	private int m_num;
	private String m_name,m_ide,m_pw1,m_pw2,m_email1,m_email2,
			m_zip,m_add1,m_add2,m_tel,m_year,m_month,m_day,
			m_lunar,m_gender,m_news,m_favor;
	private Timestamp m_date;
}
