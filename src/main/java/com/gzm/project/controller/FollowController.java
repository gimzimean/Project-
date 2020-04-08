package com.gzm.project.controller;

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

import com.gzm.project.model.RespCM;
import com.gzm.project.model.follow.Follow;
import com.gzm.project.model.follow.Following;
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
	public String contacts(@PathVariable int userId, Model model) {
		
		model.addAttribute("follow",  followService.팔로우리스트(userId));
		return "/pages/examples/contacts";
	}
  
}
