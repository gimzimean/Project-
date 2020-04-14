package com.gzm.project.model.band;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Band {
	private int bandId;
	private int userId;
	private String bandName;
	private String bandInfo;
	private String username;
	private String bandFile;

}
