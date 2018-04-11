package com.pms.dao;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Owner;

@Repository("ownerMapper")
public interface OwnerMapper {
    int deleteByPrimaryKey(Integer ownersId);

    int insert(Owner record);

    int insertSelective(Owner record);

    Owner selectByPrimaryKey(Integer ownersId);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);
    
    Owner selectByEmail(String ownersEmail);
    
    int insertByRegister(Owner owner);
}