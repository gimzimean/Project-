package com.gzm.project.mapper;

import com.gzm.project.model.user.User;
import com.gzm.project.model.user.dto.ReqJoinDto;
import com.gzm.project.model.user.dto.ReqLoginDto;

public interface UserMapper {
	
	User findEmailPassword(ReqLoginDto dto);
	int findByUsername(String username);
	int save(ReqJoinDto dto);

}
