package com.pms.dao;

import com.pms.pojo.Verify;

public interface VerifyMapper {
    int deleteByPrimaryKey(Integer verifyId);

    int insert(Verify record);

    int insertSelective(Verify record);

    Verify selectByPrimaryKey(Integer verifyId);

    int updateByPrimaryKeySelective(Verify record);

    int updateByPrimaryKey(Verify record);
}