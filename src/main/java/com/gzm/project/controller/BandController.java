package com.gzm.project.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gzm.project.service.BandService;

@Controller
public class BandController {

	@Autowired
	private BandService bandService;

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private HttpServletResponse resp;

	private PrintWriter out;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("bands", bandService.밴드목록보기());
		return "/band/list";
	}
	
	@GetMapping("/band/go/{band.bandId }")
	public String go(@PathVariable int bandId) {
		bandService.밴드상세보기(bandId);
		
		return "/band/list";
	}
	
	

	@GetMapping("/band/create")
	public String create() {
		return "/pages/examples/profile";
	}

	@PostMapping("/band/create/{userId}")
	public String create(@PathVariable @RequestParam int userId,
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, @RequestParam String bandName,
			@RequestParam String bandInfo, @RequestParam MultipartFile bandFile) throws IOException {

		if (!agree) {
			resp.setContentType("text/html;charset=UTF-8");
			out = resp.getWriter();
			out.println("<script>");
			out.println("alert('약관에 동의해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
			return null;

		}

		String uploadFolder = "C:\\upload\\";

		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid + "_" + bandFile.getOriginalFilename();
		Path filePath = Paths.get(uploadFolder + uuidFilename);

		try {
			Files.write(filePath, bandFile.getBytes());
			// File saveFile=new File(uploadFolder, bandFile.getOriginalFilename());
			// bandFile.transferTo(saveFile);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int result = bandService.create(userId, bandName, bandInfo, uuidFilename);
		if (result == 1) {
			return "home";
		}
		return null;
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
