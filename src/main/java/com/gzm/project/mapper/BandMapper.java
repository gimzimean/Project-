package com.gzm.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzm.project.model.band.Band;

public interface BandMapper {
	
	public List<Band> findAll();

	public int save(@Param("userId") int userId,@Param("bandName") String bandName,@Param("bandInfo") String bandInfo,@Param("uuidFilename") String uuidFilename);

	public void findById(int bandId);
	
	
	

}
