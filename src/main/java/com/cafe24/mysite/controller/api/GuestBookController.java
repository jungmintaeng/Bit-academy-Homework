package com.cafe24.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.GuestBookService;
import com.cafe24.mysite.vo.GuestBookVo;

@Controller("guestBookAPIController")
@RequestMapping("/api/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping("/list")
	@ResponseBody
	public JSONResult list() {
		return JSONResult.success(guestBookService.getAllGuestBooks());
	}
	
	@RequestMapping("/list/{lastNo}")
	@ResponseBody
	public JSONResult list(
				@PathVariable("lastNo") Long lastNo
			) {
		return JSONResult.success(guestBookService.getLimitedGuestBookList(lastNo));
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONResult add(
				@ModelAttribute GuestBookVo vo
			) {
		return JSONResult.success(guestBookService.addAndReturnGuestBook(vo));
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JSONResult delete(
				@ModelAttribute GuestBookVo vo
			) {
		return JSONResult.success(guestBookService.deleleteGuestBook(vo) ? vo.getNo() : -1);
	}
}