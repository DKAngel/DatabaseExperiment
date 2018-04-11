package com.pms.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Owner;
import com.pms.pojo.Room;
import com.pms.service.FrontRegisterService;
import com.pms.service.OwnerService;
import com.pms.service.RoomService;

@Controller
@RequestMapping(value = "/frontRegister")
public class FrontRegisterController {
	
	@Resource(name = "frontRegisterService")
	FrontRegisterService frontRegisterService;
	
	@Resource(name = "roomService")
	RoomService roomService;
	
	@Resource(name = "ownerService")
	OwnerService ownerService;
	
	@RequestMapping("/register")
	public String register(){
		return "/front/register";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	private ModelAndView setOwner (HttpServletRequest request, HttpSession session) {
		String registerEmail = request.getParameter("email");
		String registerPassword = request.getParameter("password");
		int registerRoomId = Integer.valueOf(request.getParameter("roomId"));
		
		Owner existOwner = frontRegisterService.getByEmail(registerEmail);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("registerEmail", registerEmail);
		mView.addObject("registerPassword", registerPassword);
		mView.addObject("registerRoomId", registerRoomId);
		mView.setViewName("/front/register");
		
		if(existOwner != null){
			request.setAttribute("loginError", "该邮箱已注册");
			return mView;
		}
		
		Room existRoom = roomService.getByPrimaryKey(registerRoomId);
		
		if(existRoom != null ){
			if(existRoom.getRoomOwner() == null){
				
				String registerPasswordMD5 = null;
		        try {
		            // 得到一个信息摘要器
		            MessageDigest digest = MessageDigest.getInstance("md5");
		            byte[] result = digest.digest(registerPassword.getBytes());
		            StringBuffer buffer = new StringBuffer();
		            // 把每一个byte 做一个与运算 0xff;
		            for (byte b : result) {
		                // 与运算
		                int number = b & 0xff;// 加盐
		                String str = Integer.toHexString(number);
		                if (str.length() == 1) {
		                    buffer.append("0");
		                }
		                buffer.append(str);
		            }
		            registerPasswordMD5 = buffer.toString();
		        } catch (NoSuchAlgorithmException e) {
		            e.printStackTrace();
		        }
				
				Owner owner = new Owner();
				owner.setOwnersEmail(registerEmail);
				owner.setOwnersPassword(registerPasswordMD5);
				owner.setRoomId(registerRoomId);
				
				//增加新业主
				ownerService.insertByRegister(owner);
				
				//修改room房主id
				Owner roomOwner = ownerService.selectByEmail(registerEmail);
				if(roomOwner == null){
					System.out.println("FrontRegisterController.setOwner()"+"速度太快了");
				}else{
					int ownerId = roomOwner.getOwnersId();
					roomService.updateByRegister(ownerId, registerRoomId);
				}
				
				session.setAttribute("owner", owner);
				
				mView.setViewName("/front/index");
				return mView;
				
			}else{
				request.setAttribute("loginError", "该房间已被注册，如有疑问请联系管理员");
				return mView;
			}
		}else{
			request.setAttribute("loginError", "房间不存在");
			return mView;
		}
	}
}

