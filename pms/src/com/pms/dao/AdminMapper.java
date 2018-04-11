package com.pms.dao;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Admin;

@Repository("adminMapper")
public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin selectByAccount(String account);
}