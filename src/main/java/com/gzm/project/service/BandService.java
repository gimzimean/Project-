package com.gzm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzm.project.mapper.BandMapper;
import com.gzm.project.model.band.Band;

@Service
public class BandService {
	
	@Autowired
	private BandMapper bandmapper;
	
	
	public List<Band> 밴드목록보기(){
		System.out.println("여기 왔니 ");
		return bandmapper.findAll();
	}
	

}
