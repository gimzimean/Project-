package com.gzm.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzm.project.SearchCriteria;
import com.gzm.project.mapper.BandMapper;
import com.gzm.project.model.ReturnCode;
import com.gzm.project.model.band.Band;
import com.gzm.project.model.band.dto.ReqUpdateDto;
import com.gzm.project.model.band.dto.RespBandandUsername;
import com.gzm.project.model.band.dto.RespListFollowed;
import com.gzm.project.model.follow.dto.RespListFollowNotFollowId;
import com.gzm.project.model.page.Criteria;
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


	public List<Map<String, Object>> 팔로우밴드목록보기(int userId, Criteria cri) {
		// TODO Auto-generated method stub
		return bandmapper.findFollowBandAll(userId,cri);
	}

	public int create(int userId,String bandName, String bandInfo, String uuidFilename, String originalName) {
		// TODO Auto-generated method stub
		return bandmapper.save(userId,bandName, bandInfo, uuidFilename,originalName);
		
	}


	public RespBandandUsername 밴드상세보기(int bandId) {
		return bandmapper.findById(bandId);
	}
	
	public List<RespListFollowNotFollowId> 팔로우상태보기(int bandId, int principalUserId) {
		System.out.println(principalUserId);
		
		return bandmapper.findbyBandId(bandId, principalUserId);
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


	public List<Map<String, Object>> 내밴드목록보기(int userId, Criteria cri) {
		// TODO Auto-generated method stub
		//return bandmapper.findmylist(userId,cri);
		return bandmapper.findmylist(userId,cri);
	}
	
	
//	@SuppressWarnings("unchecked")
//	public List<Map<String, Object>> selectBoardList(Criteria cri) {
//	    return (List<Map<String,Object>>)selectList("board.selectBoardList", cri);
//	}


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

	public int countBandListTotal(int userId) {
		// TODO Auto-generated method stub
		return bandmapper.countBandList(userId);
	}


	public int countAllBandListTotal() {
		// TODO Auto-generated method stub
		return bandmapper.countAllBandList();
	}


	public List<Map<String, Object>> 모든밴드목록보기(Criteria cri) {
		// TODO Auto-generated method stub
		return bandmapper.findAllList(cri);
	}


	public int countFollowingBand(int userId) {
		// TODO Auto-generated method stub
		return bandmapper.countFollowing(userId);
	}


	public List<Map<String, Object>> 내밴드검색목록보기(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		System.out.println("keyword"+keyword);
		return bandmapper.searchMyBandByKeyword(keyword);
	}


	public int countMyBand(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		return bandmapper.countMyBand(keyword);
	}


	public List<Map<String, Object>> searchAll(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return bandmapper.searchAllByKeyword(scri);
	}


	public int countAll(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return bandmapper.countAll(scri);
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
