package com.gzm.project.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzm.project.mapper.FollowMapper;
import com.gzm.project.model.follow.Follow;

@Service
public class FollowService {
	
	@Autowired
	private FollowMapper followMapper;
	@Autowired
	private HttpSession session;
	

	public int 팔로우하기(Follow follow) {
		// TODO Auto-generated method stub
		return followMapper.save(follow);
		
	}

}
