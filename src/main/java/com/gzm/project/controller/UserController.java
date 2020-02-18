package com.gzm.project.controller;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gzm.project.model.RespCM;
import com.gzm.project.model.ReturnCode;
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
	public String join(ReqJoinDto dto, BindingResult bindingResult) {

		int result = userService.회원가입(dto);
		

		if (result == ReturnCode.아이디중복) {
			return "/pages/examples/register";
		} else if (result == ReturnCode.성공) {
			return "/band/list";
		} else {
			return"/pages/examples/register";
		}
	}

	@PostMapping("/user/login")
	public String login(@RequestParam String rememberME, @RequestParam String email, ReqLoginDto dto,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

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

		if (principal != null) {
			session.setAttribute("principal", principal);
			return "/band/list";
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
