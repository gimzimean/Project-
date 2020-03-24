package com.gzm.project.model.band.dto;

import com.gzm.project.model.board.board;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqUpdateDto {
	private int bandId;
	private String bandName;
	private String bandInfo;
	private String bandFile;
	private int userId;
	private int followerNUM;
}
