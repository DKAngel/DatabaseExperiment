package com.pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Notice;

@Repository("noticeMapper")
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    //自己编写
    int insertByNoId(Notice notice);
    
    List<Notice> selectAllNotice();
}