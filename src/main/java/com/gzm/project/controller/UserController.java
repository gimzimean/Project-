package com.gzm.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gzm.project.model.ReturnCode;
import com.gzm.project.model.band.Band;
import com.gzm.project.model.user.User;
import com.gzm.project.model.user.dto.ReqJoinDto;
import com.gzm.project.model.user.dto.ReqLoginDto;
import com.gzm.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private HttpServletResponse resp;
	
	private PrintWriter out;
	
	
	@GetMapping("/user/login")
	public String login() {
		// @ModelAttribute("msg") String msg 위에 넣기
		return "/pages/examples/login";
	}

	@GetMapping("/user/join")
	public String join() {
		return "/pages/examples/register";
	}

	@PostMapping("/user/join")
	public String join(ReqJoinDto dto, BindingResult bindingResult) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		

		int result = userService.회원가입(dto);
		

		if (result == ReturnCode.아이디중복) {
			out.println("<script>");
			out.println("alert('이메일이 중복되었습니다.');");
			out.println("location.href='/user/join'");
			out.println("</script>");
			out.flush();
			out.close();
			
			
			
			return "/pages/examples/register";
		} else if (result == ReturnCode.성공) {
			return "redirect:/user/login";
		} else {
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("location.href='/user/join'");
			out.println("</script>");
			out.flush();
			out.close();
			return"/pages/examples/register";
		}
	}

	@PostMapping("/user/login")
	public String login(@RequestParam String rememberME, @RequestParam String email, ReqLoginDto dto) throws Exception {

		String rememberMe = Optional.ofNullable(req.getParameter("rememberME")).orElse("off");

		if (rememberMe.equals("on")) {
			Cookie cookie = new Cookie("userEmailCookie", email);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			resp.addCookie(cookie);
			System.out.println("쿠키들어옴~");
		} else {
			Cookie cookie = new Cookie("userEmailCookie", "");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		User principal = userService.로그인(dto);
		Band band=new Band();
		

		if (principal != null) {
			session.setAttribute("bands", band);
			session.setAttribute("principal", principal);
			return "home";
		} else {
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("location.href='/user/login'");
			out.println("</script>");
			out.flush();
			out.close();

			/* rttr.addAttribute("msg","로그인 실패22"); */
			return null;
		}

	}
	
	

	@GetMapping("/user/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/list";
	}

}
