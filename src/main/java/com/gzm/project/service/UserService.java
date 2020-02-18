package com.gzm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzm.project.mapper.UserMapper;
import com.gzm.project.model.ReturnCode;
import com.gzm.project.model.user.User;
import com.gzm.project.model.user.dto.ReqJoinDto;
import com.gzm.project.model.user.dto.ReqLoginDto;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User 로그인(ReqLoginDto dto){
		return userMapper.findEmailPassword(dto);
		
	}
	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		int result=userMapper.findByUsername(dto.getUsername());
		if (result==1) {
			return ReturnCode.아이디중복;
		}else {
			return userMapper.save(dto);
		}
		
	}
	

	
	
}
