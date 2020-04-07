package com.gzm.project.model.follow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Following {
	private int followingId;
	private int fromId;
	private int toId;
	private int bandId;

}
