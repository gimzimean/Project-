package com.gzm.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gzm.project.SearchCriteria;
import com.gzm.project.model.band.Band;
import com.gzm.project.model.band.dto.ReqUpdateDto;
import com.gzm.project.model.band.dto.RespBandandUsername;
import com.gzm.project.model.band.dto.RespListFollowed;
import com.gzm.project.model.follow.dto.RespListFollowNotFollowId;
import com.gzm.project.model.page.Criteria;

public interface BandMapper {
	
	public List<Band> findAll();

	public int save(@Param("userId") int userId,@Param("bandName") String bandName,@Param("bandInfo") String bandInfo,@Param("uuidFilename") String uuidFilename,@Param("originalName") String originalName);

	public RespBandandUsername findById(int bandId);
	
	
	public ReqUpdateDto findRespAndUserName(int bandId);
	ReqUpdateDto followerNUM(int toId);

	public int update(@Param("bandId") int bandId,@Param("bandName") String bandName,@Param("bandInfo") String bandInfo,@Param("uuidFilename") String uuidFilename);

	public List<Band> findmylist(int userId);
	public List<Map<String, Object>> findmylist(@Param("userId") int userId,@Param("cri") Criteria cri);

	public int 나의밴드삭제(int bandId);

	public List<Map<String, Object>> findFollowBandAll(@Param("userId") int userId,@Param("cri") Criteria cri);

	public List<RespListFollowNotFollowId> findbyBandId(@Param("bandId") int bandId, @Param("principalUserId") int principalUserId);

	public int countBandList(int userId);

	public int countAllBandList();

	public List<Map<String, Object>> findAllList(@Param("cri") Criteria cri);

	public int countFollowing(int userId);

	public List<Map<String, Object>> searchMyBandByKeyword(@Param("keyword") Map<String, Object> keyword);

	public int countMyBand(@Param("keyword") Map<String, Object> keyword);

	public List<Map<String, Object>> searchAllByKeyword(SearchCriteria scri);

	public int countAll(SearchCriteria scri);
	


	
	
	

}
