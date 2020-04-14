package com.gzm.project.model.follow.dto;

import com.gzm.project.model.follow.Follow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespListDto {
	private int toId;
	private int fromId;
	private String username;
	private String email;
	

}
 