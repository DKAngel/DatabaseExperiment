package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.OwnerMapper;
import com.pms.pojo.Owner;
import com.pms.service.FrontRegisterService;

@Service("frontRegisterService")
public class FrontRegisterServiceImpl implements FrontRegisterService {
	@Resource(name = "ownerMapper")
	private OwnerMapper ownerMapper;
	
	@Override
	public Owner getByEmail(String ownersEmail){
		return ownerMapper.selectByEmail(ownersEmail);
	}
}
