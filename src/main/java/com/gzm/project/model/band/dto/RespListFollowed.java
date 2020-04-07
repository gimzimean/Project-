package com.gzm.project.model.band.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespListFollowed {
	private int bandId;
	private int fromId;
	private int userId;
	private String username;
	private String bandName;
	private String bandInfo;
	private int toId;

}
