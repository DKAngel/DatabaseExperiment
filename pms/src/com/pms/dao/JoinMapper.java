package com.pms.dao;

import com.pms.pojo.Join;

public interface JoinMapper {
    int deleteByPrimaryKey(Integer joinsId);

    int insert(Join record);

    int insertSelective(Join record);

    Join selectByPrimaryKey(Integer joinsId);

    int updateByPrimaryKeySelective(Join record);

    int updateByPrimaryKey(Join record);
}