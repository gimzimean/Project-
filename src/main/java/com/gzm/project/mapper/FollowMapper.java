package com.gzm.project.mapper;

import java.util.List;

import com.gzm.project.model.follow.Follow;
import com.gzm.project.model.follow.Following;
import com.gzm.project.model.follow.dto.RespListDto;

public interface FollowMapper {

	int save(Follow follow);

	int delete(Follow follow);

	List<RespListDto> findAll(int userId);

	int save2(Following following);

}
