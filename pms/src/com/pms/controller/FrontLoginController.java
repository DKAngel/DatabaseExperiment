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
import com.pms.service.FrontLoginService;

@Controller
@RequestMapping(value = "/frontLogin")
public class FrontLoginController {
	
	@Resource(name = "frontLoginService")
	FrontLoginService frontLoginService;
	
	@RequestMapping("/login")
	public String login(){
		return "/front/login";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ModelAndView check(HttpServletRequest request, HttpSession session){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginEmail", email);
		mv.setViewName("/front/login");

		if(email.equals("")){
			request.setAttribute("loginError", "邮箱不能为空!");
			return mv;
		}else{
			if(password.equals("")){
				request.setAttribute("loginError", "密码不能为空!");
				return mv;
			}
		}
		Owner owner = frontLoginService.getByEmail(email);
		
		if(owner == null){
        	request.setAttribute("loginError", "业主不存在!");
			return mv;
        }
		
		String md5Password = null;
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
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
            md5Password = buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if(md5Password.equals(owner.getOwnersPassword())){
        	mv.setViewName("/front/index");
        	session.setAttribute("owner", owner);
        	return mv;
        }else{
        	request.setAttribute("loginError", "密码不正确!");
			return mv;
        }
	}
	
	@RequestMapping("/forget")
	public String forget(){
		
		return "/front/login";
	}
}
