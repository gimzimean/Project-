package com.gzm.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzm.project.mapper.CalendarMapper;
import com.gzm.project.model.calendar.RequestScheduleUpdate;
import com.gzm.project.model.calendar.RequestTimeResizing;
import com.gzm.project.model.calendar.RespSchedule;
import com.gzm.project.model.calendar.ScheduleVo;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarMapper calendarMapper;
	@Autowired
	private HttpSession session;
	

	

	public int save(ScheduleVo scheduleVo) {
		// TODO Auto-generated method stub
		return calendarMapper.save(scheduleVo);
	}


	public List<RespSchedule> selectScheduleList(int bandId) {
		// TODO Auto-generated method stub
		return calendarMapper.findAll( bandId);
	}


	public int resizing(RequestTimeResizing requestTimeResizing) {
		// TODO Auto-generated method stub
		return calendarMapper.updateTimeSchedule(requestTimeResizing);
	}


	public int update(RequestScheduleUpdate requestScheduleUpdate) {
		// TODO Auto-generated method stub
		return calendarMapper.updateAllSchedule(requestScheduleUpdate);
	}


	public int delete(int calendarId) {
		return calendarMapper.deleteById(calendarId);
	}


	public int dropUpdate(RequestTimeResizing requestTimeResizing) {
		// TODO Auto-generated method stub
		return calendarMapper.updateTimeSchedule(requestTimeResizing);
	}


}
