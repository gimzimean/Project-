package com.gzm.project.model.follow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespListFollowNotFollowId {
	private int toId;
	private int fromId;
	private int bandId;
	

}

