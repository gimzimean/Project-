package com.gzm.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gzm.project.model.RespCM;
import com.gzm.project.model.band.Band;
import com.gzm.project.model.user.User;
import com.gzm.project.service.BandService;

@Controller
public class BandController {

	@Autowired
	private BandService bandService;

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private HttpServletResponse resp;

	@Autowired
	private HttpSession session;

	private PrintWriter out;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("band", bandService.밴드목록보기());
		
		Band band2=(Band)session.getAttribute("band2");
		model.addAttribute("band2",band2);
		return "/band/list";
	}

	@GetMapping("/band/go/{bandId}")
	public String go(@PathVariable int bandId, Model model) {
		User principal = (User) session.getAttribute("principal");
		model.addAttribute("principal", principal);

		model.addAttribute("band", bandService.밴드상세보기(bandId));

		return "/pages/examples/profile2";
	}

	@GetMapping("/band/updatedPage/{bandId}")
	public String updatedPage(@PathVariable int bandId, Model model) {
		
		model.addAttribute("band", bandService.업데이트된나의밴드전체보기(bandId));

		return "/pages/examples/profile2";
	}

	@GetMapping("/band/edit/{bandId}")
	public String edit(@PathVariable int bandId, Model model) {
		//model.addAttribute("band", bandService.수정하기(bandId));
		User principal = (User) session.getAttribute("principal");
		model.addAttribute("principal", principal);

		model.addAttribute("band", bandService.밴드상세보기(bandId));
		return "/pages/examples/profile2";
	}

	@GetMapping("/band/create")
	public String create() {
		return "/pages/examples/profile";
	}
	
	@GetMapping("/band/myband/{userId}")
	public String myband(@PathVariable int userId, Model model) {
		model.addAttribute("band", bandService.내밴드목록보기(userId));
	
		
		User principal=(User) session.getAttribute("principal");
		session.setAttribute("principal", principal);
		return "/pages/tables/jsgrid";
	}
	
	@GetMapping("/band/followingBand/{userId}")
	public String followingBand(@PathVariable int userId, Model model) {
		model.addAttribute("band", bandService.팔로우밴드목록보기(userId));
		User principal=(User) session.getAttribute("principal");
		session.setAttribute("principal", principal);
		return "/pages/tables/followingBand";
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

		String uploadFolder = "C:\\src\\springBlog집\\Project-\\Project-\\src\\main\\webapp\\resources\\media\\";

		UUID uuid = UUID.randomUUID();
		System.out.println(bandFile.getOriginalFilename());
		String uuidFilename = uuid + "_" + bandFile;
		
		Path filePath = Paths.get(uploadFolder + uuidFilename);

		try {
			Files.write(filePath, bandFile.getBytes());
			/*
			 * File saveFile=new File(uploadFolder3, bandFile.getOriginalFilename());
			 * bandFile.transferTo(saveFile);
			 */

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


	@GetMapping("/band/calendar")
	public String calendar() {
		return "/pages/examples/calendar";
	}

	

	@PostMapping("/band/update/{bandId}")
	public String update(@PathVariable @RequestParam int bandId,
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, @RequestParam String bandName,
			@RequestParam String bandInfo, @RequestParam MultipartFile bandFile, RedirectAttributes rttr)
			throws IOException {

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

		String uploadFolder = "C:\\src\\springBlog집\\Project-\\Project-\\src\\main\\webapp\\resources\\media\\";

		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid + "_" + bandFile;
		Path filePath = Paths.get(uploadFolder + uuidFilename);

		try {
			Files.write(filePath, bandFile.getBytes());
			// File saveFile=new File(uploadFolder, bandFile.getOriginalFilename());
			// bandFile.transferTo(saveFile);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int result = bandService.수정완료(bandId, bandName, bandInfo, uuidFilename);
		if (result == 1) {
			resp.setContentType("text/html;charset=UTF-8");
			out = resp.getWriter();
			out.println("<script>");
			out.println("alert('수정완료');");
			out.println("location.href='/band/updatedPage/"+bandId+"';");
			//out.println("location.href='/band/updatedPage/'"+bandId+';");
			out.println("alert('수정완료222');");
			out.println("</script>");
			out.flush();
			out.close();

			return null;
		}
		return null;

	}
	
	//@DeleteMapping("/band/delete/{bandId}")
	@RequestMapping(value="/band/delete/{bandId}", method= {RequestMethod.DELETE,RequestMethod.GET})
	private ResponseEntity<?> delete(@PathVariable int bandId) {
		
		int result=bandService.나의밴드삭제(bandId);
		
		if (result==1) {
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"), HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Integer>(403,HttpStatus.FORBIDDEN);
			
		}

	}
	
	@GetMapping("/band/detail/{bandId}")
	public String detail(@PathVariable int bandId, Model model) {
		User principal = (User) session.getAttribute("principal");
		model.addAttribute("principal", principal);

		model.addAttribute("band", bandService.밴드상세보기(bandId));

		return "/pages/examples/profile2";
	}
	
}
