package com.gzm.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gzm.project.SearchCriteria;
import com.gzm.project.model.band.Band;
import com.gzm.project.model.page.Criteria;
import com.gzm.project.model.page.PageMaker;
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
	public ModelAndView list(@ModelAttribute("scri") SearchCriteria scri,Model model) {
		// model.addAttribute("band", bandService.밴드목록보기());

		Band band2 = (Band) session.getAttribute("band2");
		model.addAttribute("band2", band2);

		ModelAndView mav = new ModelAndView("/band/list");

		User principal = (User) session.getAttribute("principal");
		session.setAttribute("principal", principal);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(bandService.countAllBandListTotal());

		List<Map<String, Object>> list = bandService.모든밴드목록보기(scri);
		System.out.println(list);
		mav.addObject("band", list);
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}

	@GetMapping("/band/go/{bandId}")
	public String go(@PathVariable int bandId, Model model) {

		User principal = (User) session.getAttribute("principal");

		int principalUserId = principal.getUserId();

		model.addAttribute("principal", principal);

		model.addAttribute("band", bandService.밴드상세보기(bandId));

		model.addAttribute("FollowStatus", bandService.팔로우상태보기(bandId, principalUserId));

		return "/pages/examples/profile2";
	}

	@GetMapping("/band/updatedPage/{bandId}")
	public String updatedPage(@PathVariable int bandId, Model model) {

		model.addAttribute("band", bandService.업데이트된나의밴드전체보기(bandId));

		return "/pages/examples/profile2";
	}

	@GetMapping("/band/edit/{bandId}")
	public String edit(@PathVariable int bandId, Model model) {
		// model.addAttribute("band", bandService.수정하기(bandId));
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
	public ModelAndView myband(@PathVariable int userId, Model model, Criteria cri) {
		// model.addAttribute("band", bandService.내밴드목록보기(userId));
		ModelAndView mav = new ModelAndView("/pages/tables/jsgrid");

		User principal = (User) session.getAttribute("principal");
		session.setAttribute("principal", principal);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bandService.countBandListTotal(userId));

		List<Map<String, Object>> list = bandService.내밴드목록보기(userId, cri);
		mav.addObject("band", list);
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}

	@GetMapping("/band/followingBand/{userId}")
	public ModelAndView followingBand(@PathVariable int userId, Model model, Criteria cri) {
		// model.addAttribute("band", bandService.팔로우밴드목록보기(userId));
		User principal = (User) session.getAttribute("principal");
		session.setAttribute("principal", principal);

		ModelAndView mav = new ModelAndView("/pages/tables/followingBand");

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bandService.countFollowingBand(userId));

		List<Map<String, Object>> list = bandService.팔로우밴드목록보기(userId, cri);
		mav.addObject("band", list);
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}

	@PostMapping("/band/create/{userId}")
	public String create(@PathVariable @RequestParam int userId,
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, @RequestParam String bandName,
			@RequestParam String bandInfo, @RequestParam MultipartFile bandFile,Model model) throws IOException {

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

		String uploadFolder = "C:\\src\\springBlog학원\\Project2-update-\\src\\main\\webapp\\resources\\media\\";
		System.out.println("bandFile"+bandFile);
		UUID uuid = UUID.randomUUID();
		System.out.println("bandFileorigianl"+bandFile.getOriginalFilename());
		String uuidFilename = uuid + "_" + bandFile;

		String originalName=bandFile.getOriginalFilename();
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
		int result = bandService.create(userId, bandName, bandInfo, uuidFilename,originalName);
		if (result == 1) {
			return "home";
		}
		return null;
	}

	@GetMapping("/band/search")
	public String search() {
		return "redirect:/list";
	}

	@GetMapping("/band/calendar/{bandId}")
	public String calendar(@PathVariable int bandId, Model model) {
		User principal = (User) session.getAttribute("principal");

		int principalUserId = principal.getUserId();

		model.addAttribute("principal", principal);

		model.addAttribute("band", bandService.밴드상세보기(bandId));

		model.addAttribute("FollowStatus", bandService.팔로우상태보기(bandId, principalUserId));

		return "/pages/examples/calendar3";
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

		String uploadFolder = "C:\\src\\springBlog학원\\Project2-update-\\src\\main\\webapp\\resources\\media\\";

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
			out.println("location.href='/band/updatedPage/" + bandId + "';");
			// out.println("location.href='/band/updatedPage/'"+bandId+';");
			out.println("alert('수정완료222');");
			out.println("</script>");
			out.flush();
			out.close();

			return null;
		}
		return null;

	}

	// @DeleteMapping("/band/delete/{bandId}")
	@RequestMapping(value = "/band/delete/{bandId}", method = { RequestMethod.DELETE, RequestMethod.GET })
	private ModelAndView delete(@PathVariable int bandId, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes redAttr) throws Exception {
		User principal = (User) session.getAttribute("principal");
		session.setAttribute("principal", principal);

		ModelAndView mv = new ModelAndView("redirect:/band/myband/" + principal.getUserId() + "");

		int result = bandService.나의밴드삭제(bandId);
		if (result == 1) {
			redAttr.addFlashAttribute("result", "success");
			// header말고 세션을 통해서 전달됨.
			redAttr.addAttribute("page", cri.getPage());
			redAttr.addAttribute("perPagNum", cri.getPerPageNum());
		}

		return mv;

	}

	@GetMapping("/band/detail/{bandId}")
	public String detail(@PathVariable int bandId, Model model) {
		User principal = (User) session.getAttribute("principal");
		model.addAttribute("principal", principal);

		model.addAttribute("band", bandService.밴드상세보기(bandId));

		return "/pages/examples/profile2";
	}

	@GetMapping("/band/searchMyBandByTitle/{userId}")
	public ModelAndView searchMyBandByTitle(@RequestParam(value = "table_search") String table_search,
			@PathVariable int userId, Model model, Criteria cri, RedirectAttributes redAttr) {
		User principal = (User) session.getAttribute("principal");
		session.setAttribute("principal", principal);
		ModelAndView mav = new ModelAndView("/pages/tables/jsgrid");

		// HashMap 생성
		Map<String, Object> keyword = new HashMap<String, Object>();
		keyword.put("search", table_search);
		keyword.put("userId", userId);

		// 페이지
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bandService.countMyBand(keyword));

		List<Map<String, Object>> searchList = bandService.내밴드검색목록보기(keyword);
		mav.addObject("band", searchList);
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}

	// 게시판 목록 조회
	@GetMapping("/band/searchMyBandByTitle")
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		System.err.println("scri"+scri);

		model.addAttribute("band", bandService.searchAll(scri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(bandService.countAll(scri));

		model.addAttribute("pageMaker", pageMaker);

		return "/band/list";

	}
	@GetMapping("/lists")
	public ModelAndView pagingList(@ModelAttribute("scri") SearchCriteria scri,Model model) {
		// model.addAttribute("band", bandService.밴드목록보기());

		Band band2 = (Band) session.getAttribute("band2");
		model.addAttribute("band2", band2);

		ModelAndView mav = new ModelAndView("/band/list");

		User principal = (User) session.getAttribute("principal");
		session.setAttribute("principal", principal);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(bandService.countAll(scri));

		List<Map<String, Object>> list = bandService.searchAll(scri);
		System.out.println(list);
		mav.addObject("band", list);
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}

}
