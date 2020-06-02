package com.gzm.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gzm.project.model.follow.Follow;
import com.gzm.project.model.follow.Following;
import com.gzm.project.model.follow.dto.RespListDto;
import com.gzm.project.model.page.Criteria2;

public interface FollowMapper {

	int save(Follow follow);

	int delete(Follow follow);

	List<RespListDto> findAll(int userId);

	int save2(Following following);

	List<Map<String, Object>> findAllFollowingList(@Param("userId") int userId,@Param("cri") Criteria2 cri);

	int countFollowingNum(int userId);

}
