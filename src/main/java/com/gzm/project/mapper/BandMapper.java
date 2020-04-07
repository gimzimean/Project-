package com.gzm.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzm.project.model.band.Band;
import com.gzm.project.model.band.dto.ReqUpdateDto;
import com.gzm.project.model.band.dto.RespBandandUsername;
import com.gzm.project.model.band.dto.RespListFollowed;

public interface BandMapper {
	
	public List<Band> findAll();

	public int save(@Param("userId") int userId,@Param("bandName") String bandName,@Param("bandInfo") String bandInfo,@Param("uuidFilename") String uuidFilename);

	public RespBandandUsername findById(int bandId);
	
	
	public ReqUpdateDto findRespAndUserName(int bandId);
	ReqUpdateDto followerNUM(int toId);
	
	

	public int update(@Param("bandId") int bandId,@Param("bandName") String bandName,@Param("bandInfo") String bandInfo,@Param("uuidFilename") String uuidFilename);

	public List<Band> findmylist(int userId);

	public int 나의밴드삭제(int bandId);

	public List<RespListFollowed> findFollowBandAll(int userId);


	
	
	

}
