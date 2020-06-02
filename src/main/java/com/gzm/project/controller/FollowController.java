package com.gzm.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gzm.project.model.RespCM;
import com.gzm.project.model.follow.Follow;
import com.gzm.project.model.page.Criteria2;
import com.gzm.project.model.page.PageMaker2;
import com.gzm.project.model.user.User;
import com.gzm.project.service.FollowService;

@Controller
public class FollowController {
	@Autowired
	private FollowService followService;
	
	@Autowired
	private HttpSession session;
	@PostMapping("/follow/{fromId}")
	public ResponseEntity<?> follow(@PathVariable int fromId,@RequestBody Follow follow) {
		/*
		 * User principal=(User)session.getAttribute("principal");
		 * System.out.println("fromId는"+follow.getFollowId());
		 * follow.setFromId(principal.getUserId());
		 * System.out.println("fromId2222222는"+follow.getFollowId());
		 */
		int result=followService.팔로우하기(follow);
		if(result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);	
		}else {
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}  
		
	}
	
	
	//@DeleteMapping("/band/delete/{bandId}")
		@RequestMapping(value="/unfollow/{fromId}", method= {RequestMethod.DELETE,RequestMethod.GET})
		private ResponseEntity<?> delete(@PathVariable int fromId, @RequestBody Follow follow) {
			System.out.println(follow);
			int result=followService.연팔로우하기(follow);
			
			if (result==1) {
				return new ResponseEntity<RespCM>(new RespCM(200,"ok"), HttpStatus.OK);
				
			}else {
				return new ResponseEntity<RespCM>(new RespCM(403, "fail"),HttpStatus.FORBIDDEN);
				
			}

		}
	
	@GetMapping("/follow/contacts/{userId}")
	public ModelAndView contacts(@PathVariable int userId, Model model, Criteria2 cri) {
		ModelAndView mav= new ModelAndView("/pages/examples/contacts");
		
		PageMaker2 pageMaker=new PageMaker2();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(followService.countFollowing(userId));
		
		
		List<Map<String, Object>> list = followService.FollowingList(userId, cri);
		User principal= (User)session.getAttribute("principal");
		session.setAttribute("principal", principal);
		System.out.println("principal"+principal);
		System.out.println(list);
		mav.addObject("follow", list);
		mav.addObject("pageMaker", pageMaker);
		
		return mav;
	}
  
}
