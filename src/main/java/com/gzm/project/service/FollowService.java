package com.gzm.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzm.project.mapper.FollowMapper;
import com.gzm.project.model.follow.Follow;
import com.gzm.project.model.follow.Following;
import com.gzm.project.model.follow.dto.RespListDto;
import com.gzm.project.model.page.Criteria2;

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


	public int 연팔로우하기(Follow follow) {
		// TODO Auto-generated method stub
		return followMapper.delete(follow);
	}


	public List<RespListDto> 팔로우리스트(int userId) {
		// TODO Auto-generated method stub
		return followMapper.findAll(userId);
	}


	public int 팔로우하기following(Following following) {
		// TODO Auto-generated method stub
		return followMapper.save2(following);
	}


	public List<Map<String, Object>> FollowingList(int userId, Criteria2 cri) {
		// TODO Auto-generated method stub
		return followMapper.findAllFollowingList(userId,cri);
	}


	public int countFollowing(int userId) {
		// TODO Auto-generated method stub
		return followMapper.countFollowingNum(userId);
	}

}
