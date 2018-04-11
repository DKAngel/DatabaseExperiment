package com.pms.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pms.pojo.Admin;
import com.pms.service.AdminLoginService;

@Controller
@RequestMapping(value = "/adminLogin")
public class AdminLoginController {
	
	@Resource(name = "adminLoginService")
	AdminLoginService adminLoginService;

	@RequestMapping(value = "index")
	public String index(){
		return "/admin/login";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	private String setAdmin (HttpServletRequest request, HttpSession session) {
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account.equals("")){
			request.setAttribute("loginError", "账号不能为空!");
			return "/admin/login";
		}else{
			if(password.equals("")){
				request.setAttribute("loginError", "密码不能为空!");
				return "/admin/login";
			}
		}

        Admin admin = adminLoginService.getByAccount(account);
        if(admin == null){
        	request.setAttribute("loginError", "用户不存在!");
			return "/admin/login";
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

        if(md5Password.equals(admin.getAdminPassword())){
        	session.setAttribute("user", admin);
        	return "/admin/main";
        }else{
        	request.setAttribute("loginError", "密码不正确!");
			return "/admin/login";
        }
	}
}
