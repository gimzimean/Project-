package com.gzm.project.mapper;

import java.util.List;

import com.gzm.project.model.calendar.RequestScheduleUpdate;
import com.gzm.project.model.calendar.RequestTimeResizing;
import com.gzm.project.model.calendar.RespSchedule;
import com.gzm.project.model.calendar.ScheduleVo;

public interface CalendarMapper {

	int save(ScheduleVo scheduleVo);

	List<RespSchedule> findAll(int bandId);

	int updateTimeSchedule(RequestTimeResizing requestTimeResizing);

	int updateAllSchedule(RequestScheduleUpdate requestScheduleUpdate);

	int deleteById(int calendarId);

}
