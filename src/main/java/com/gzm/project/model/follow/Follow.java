package com.gzm.project.model.follow;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
	private int followId;
	private int fromId;
	private int toId;
	private int bandId;
	
	/*public void getFollowIdArrray(){
		Follow follow=new Follow();
		List<Follow> followList=new ArrayList<Follow>();
		System.out.println("get"+);
		
		for (int i = 0; i < followList.size(); i++) {
			System.out.println("저장된 팔로우:"+followList.get(i)); 
		}
	 	
	}*/

}
