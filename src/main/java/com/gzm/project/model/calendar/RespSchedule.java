package com.gzm.project.model.calendar;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespSchedule {
	private int calendarId;
	private int userId;
	private String title;
	private boolean allDay;
	private String start;
	private String end;
	private String description;
	private String backgroundColor;
	private String borderColor;
	private String textColor;
	

}
