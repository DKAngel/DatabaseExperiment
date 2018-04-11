package com.pms.service;

import com.pms.pojo.Owner;

public interface FrontLoginService {
	public Owner getByEmail(String ownersEmail);
}
