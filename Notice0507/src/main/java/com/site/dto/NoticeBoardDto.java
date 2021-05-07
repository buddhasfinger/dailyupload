package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBoardDto {
	
	private int b_num,b_group,b_step,b_indent,b_hit;
	private String m_id,b_title,b_content,
			b_good,b_filename1,b_filename2;
	private Timestamp b_date;
}
