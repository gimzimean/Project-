package com.gzm.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gzm.project.model.RespCM;
import com.gzm.project.model.calendar.RequestScheduleUpdate;
import com.gzm.project.model.calendar.RequestTimeResizing;
import com.gzm.project.model.calendar.RespSchedule;
import com.gzm.project.model.calendar.ScheduleVo;
import com.gzm.project.service.CalendarService;

@Controller
public class CalendarController {
	@Autowired
	private CalendarService calendarService;

	@Autowired
	private HttpSession session;

	@PostMapping("/calendar/save")
	public ResponseEntity<RespCM> calendarSave(@RequestBody ScheduleVo scheduleVo, ModelMap model) {
		int result = calendarService.save(scheduleVo);
		if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);

		} else {
			return new ResponseEntity<RespCM>(new RespCM(403, "ok"), HttpStatus.FORBIDDEN);

		}
	}

	@PostMapping(value = "/calendar/write/{bandId}")
	public @ResponseBody HashMap<String, Object> calendarWrite(@PathVariable int bandId,@RequestBody RespSchedule respSchedule, ModelMap model)
			throws SQLException {
		List<RespSchedule> scheduleList = new ArrayList<RespSchedule>();
		scheduleList = calendarService.selectScheduleList(bandId);
		ScheduleVo scheduleVo;

		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = new JSONObject();
		try {
			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < scheduleList.size(); i++) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("id", scheduleList.get(i).getCalendarId());
				jsonObj.put("userId", scheduleList.get(i).getUserId());
				jsonObj.put("title", scheduleList.get(i).getTitle());
				jsonObj.put("start", scheduleList.get(i).getStart());
				jsonObj.put("end", scheduleList.get(i).getEnd());
				jsonObj.put("description", scheduleList.get(i).getDescription());
				jsonObj.put("backgroundColor", scheduleList.get(i).getBackgroundColor());
				jsonObj.put("allDay", scheduleList.get(i).isAllDay());
				jsonObj.put("borderColor", scheduleList.get(i).getBorderColor());
				jsonObj.put("textColor", scheduleList.get(i).getTextColor());
				/* map.put("ScheduleVo", scheduleList.get(i)); */
				jsonArr.add(jsonObj);
			}
			obj.put("jsonArr", jsonArr);
			map.put("obj", obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("scheduleList: " + scheduleList.size());
		ModelAndView mav = new ModelAndView();

		mav.addObject("array", obj);
		model.addAttribute("array", obj);
		mav.setViewName("/pages/examples/calendar3");
		return map;
	}
	
	
	@PostMapping(value = "/calendar/resize")
	public ResponseEntity<RespCM> calendarResizing(@RequestBody RequestTimeResizing requestTimeResizing){
		int result = calendarService.resizing(requestTimeResizing);

		if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);

		} else {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);

		}
		
	}
	@PutMapping("/calendar/update")
	public ResponseEntity<RespCM> calendarUpdate(@RequestBody RequestScheduleUpdate requestScheduleUpdate){
		int result = calendarService.update(requestScheduleUpdate);

		if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);

		} else {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);

		}
		
	}
	@DeleteMapping("/calendar/delete/{calendarId}")
	public ResponseEntity<RespCM> calendarDelete(@PathVariable int calendarId){
		int result = calendarService.delete(calendarId);

		if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);

		} else {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);

		}
		
	}
	@PutMapping("/calendar/dropUpdate")
	public ResponseEntity<RespCM> calendarDropUpdate(@RequestBody RequestTimeResizing requestTimeResizing){
		System.out.println("requestTimeUpdate"+requestTimeResizing);
		int result = calendarService.dropUpdate(requestTimeResizing);

		if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);

		} else {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);

		}
		
	}

}
