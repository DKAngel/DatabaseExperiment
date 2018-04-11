package com.pms.service;

import com.pms.pojo.Admin;

public interface AdminLoginService {
	public Admin getByAccount(String account);
}
