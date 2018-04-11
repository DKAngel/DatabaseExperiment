package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.NoticeMapper;
import com.pms.pojo.Notice;
import com.pms.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Resource(name = "noticeMapper")  
    private NoticeMapper noticeMapper; 
	
	public int insertByNoId(Notice notice){
		return noticeMapper.insertByNoId(notice);
	}
	
	public List<Notice> getAllNotice(){
		return noticeMapper.selectAllNotice();
	}
	
	public Notice getByPrimaryKey(Integer noticeId){
		return noticeMapper.selectByPrimaryKey(noticeId);
	}
	
	public int deleteByPrimaryKey(Integer noticeId){
		return noticeMapper.deleteByPrimaryKey(noticeId);
	}
}
