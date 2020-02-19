package com.gzm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gzm.project.mapper.BandMapper;
import com.gzm.project.model.band.Band;

@Service
public class BandService{
	
	@Autowired
	private BandMapper bandmapper;
	
	
	public List<Band> 밴드목록보기(){
		System.out.println("여기 왔니 ");
		return bandmapper.findAll();
	}


	public int create(int userId,String bandName, String bandInfo, String uuidFilename) {
		// TODO Auto-generated method stub
		
		return bandmapper.save(userId,bandName, bandInfo, uuidFilename);
		
	}


	public void 밴드상세보기(int bandId) {
		bandmapper.findById(bandId);
	}
	

}
