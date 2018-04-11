package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.OwnerMapper;
import com.pms.pojo.Owner;
import com.pms.service.OwnerService;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService{
	@Resource(name = "ownerMapper")
	private OwnerMapper ownerMapper;
	
	public int insertByRegister(Owner owner){
		return ownerMapper.insertByRegister(owner);
	}
	
	public Owner selectByEmail(String ownerEmail){
		return ownerMapper.selectByEmail(ownerEmail);
	}
}
