package com.gzm.project.model.band.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBandandUsername {
	private int bandId;
	private int userId;
	private String username;
	private String bandName;
	private String bandInfo;
	private String bandFile;
	

}
