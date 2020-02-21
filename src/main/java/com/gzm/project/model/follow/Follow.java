package com.gzm.project.model.follow;

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

}
