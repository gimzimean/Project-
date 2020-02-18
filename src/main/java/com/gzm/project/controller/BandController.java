package com.gzm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gzm.project.service.BandService;


@Controller
public class BandController {
	
	@Autowired
	private BandService bandService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("bands",bandService.밴드목록보기());
		return "/band/list";
	}
	@GetMapping("/band/create")
	public String create() {
		return "/pages/examples/profile";
	}
	
	@GetMapping("/band/search")
	public String search() {
		return "redirect:/list";
	}
	@GetMapping("/band/myband/{userId }")
	public String myband(@PathVariable int userId) {
		return "/pages/tables/jsgrid";
	}
	@GetMapping("/band/calendar")
	public String calendar() {
		return "/pages/examples/calendar";
	}
	
	@GetMapping("/band/contacts")
	public String contacts() {
		return "/pages/examples/contacts";
	}
	
}
