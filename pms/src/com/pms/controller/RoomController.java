package com.pms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Room;
import com.pms.service.RoomService;

@Controller
@RequestMapping(value = "/room")
public class RoomController {
	
	@Resource(name = "roomService")
	RoomService roomService;
	
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		List<Room> roomList = roomService.getRoom();
//		if(roomList.isEmpty()){
//			System.out.println("空空如也");
//		}else{
//			System.out.println("有点东西");
//		}
		mv.addObject("roomList",roomList);
		mv.setViewName("/room/show");
		return mv;
	}
}
