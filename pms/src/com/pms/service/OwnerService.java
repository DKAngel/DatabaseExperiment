package com.pms.service;

import com.pms.pojo.Owner;

public interface OwnerService {
	public int insertByRegister(Owner owner);
	public Owner selectByEmail(String ownersEmail);
}
