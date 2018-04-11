package com.pms.dao;

import com.pms.pojo.Upkeep;

public interface UpkeepMapper {
    int deleteByPrimaryKey(Integer upkeepId);

    int insert(Upkeep record);

    int insertSelective(Upkeep record);

    Upkeep selectByPrimaryKey(Integer upkeepId);

    int updateByPrimaryKeySelective(Upkeep record);

    int updateByPrimaryKey(Upkeep record);
}