package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.AdminMapper;
import com.pms.pojo.Admin;
import com.pms.service.AdminLoginService;

@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Resource(name = "adminMapper")
	private AdminMapper adminMapper;
	
	@Override
	public Admin getByAccount(String account){
		return adminMapper.selectByAccount(account);
	}
}
