package com.pms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.service.NoticeService;

@Controller
@RequestMapping(value = "/adminMain")
public class AdminMainController {
	
	@Resource(name = "noticeService")
	NoticeService noticeService;
	
	@RequestMapping(value = "main")
	public String main(){
		return "/admin/main";
	}
	
	@RequestMapping(value = "top")
	public String top(){
		return "/admin/top";
	}
	@RequestMapping(value = "left")
	public String left(){
		return "/admin/left";
	}
	@RequestMapping(value = "index")
	public String index(){
		return "/admin/index";
	}
	
	@RequestMapping(value = "notice")
	public String notice(){
		return "/admin/noticeAdd";
	}
}
