package com.pms.dao;

import com.pms.pojo.Chat;

public interface ChatMapper {
    int deleteByPrimaryKey(Integer chatId);

    int insert(Chat record);

    int insertSelective(Chat record);

    Chat selectByPrimaryKey(Integer chatId);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);
}