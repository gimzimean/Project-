package com.gzm.project.model.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {
	private int bandId;
	private int userId;
	private int calendarId;
	private String title;
	private String start;
	private String end;
	private String description;
	private String backgroundColor;
	

}
