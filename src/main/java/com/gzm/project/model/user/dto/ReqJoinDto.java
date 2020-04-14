package com.gzm.project.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqJoinDto {
	private String username;
	private String email;
	private String password;
	

}
