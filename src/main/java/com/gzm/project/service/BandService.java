package com.gzm.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzm.project.mapper.BandMapper;
import com.gzm.project.model.ReturnCode;
import com.gzm.project.model.band.Band;
import com.gzm.project.model.band.dto.ReqUpdateDto;
import com.gzm.project.model.band.dto.RespBandandUsername;
import com.gzm.project.model.band.dto.RespListFollowed;
import com.gzm.project.model.user.User;

@Service
public class BandService{
	
	@Autowired
	private BandMapper bandmapper;
	
	@Autowired
	private HttpSession session;
	
	
	public List<Band> 밴드목록보기(){
		return bandmapper.findAll();
	}


	public List<RespListFollowed> 팔로우밴드목록보기(int userId) {
		// TODO Auto-generated method stub
		return bandmapper.findFollowBandAll(userId);
	}

	public int create(int userId,String bandName, String bandInfo, String uuidFilename) {
		// TODO Auto-generated method stub
		return bandmapper.save(userId,bandName, bandInfo, uuidFilename);
		
	}


	public RespBandandUsername 밴드상세보기(int bandId) {
		return bandmapper.findById(bandId);
	}


	public RespBandandUsername 수정하기(int bandId) {
		User principal=(User) session.getAttribute("principal");
		RespBandandUsername respBandUsername=bandmapper.findById(bandId);
		
		if (principal.getUserId()==respBandUsername.getUserId()) {
			return respBandUsername;
		}else {
			return null;
		}
	}


	



	public int 수정완료(int bandId, String bandName,String bandInfo, String uuidFilename) {
		// TODO Auto-generated method stub
		User principal=(User)session.getAttribute("principal");
		RespBandandUsername respBandandUsername= bandmapper.findById(bandId);
		
		if (principal.getUserId()==respBandandUsername.getUserId()) {
			return bandmapper.update(bandId, bandName, bandInfo, uuidFilename);
		}else {
			return ReturnCode.권한없음;
		}
	}


	public ReqUpdateDto 업데이트된나의밴드전체보기(int bandId) {
				 
		return bandmapper.findRespAndUserName(bandId);
	}


	public List<Band> 내밴드목록보기(int userId) {
		// TODO Auto-generated method stub
		return bandmapper.findmylist(userId);
	}


	public int 나의밴드삭제(int bandId) {
		// TODO Auto-generated method stub
		User principal=(User)session.getAttribute("principal");
		RespBandandUsername respBandandUsername= bandmapper.findById(bandId);
		if (principal.getUserId()==respBandandUsername.getUserId()) {
			return bandmapper.나의밴드삭제(bandId);
		}else {
			return ReturnCode.권한없음;
		}
		
		
	}




	/*
	 * public Object 팔로우숫자보기() { // TODO Auto-generated method stub Follow
	 * principal=(Follow) session.getAttribute("principal"); Follow follow=new
	 * Follow(); int toId=follow.getToId(); System.out.println(toId);
	 * 
	 * 
	 * bandmapper.followerNUM(toId);
	 * 
	 * return null; }
	 */
	

}
