package com.pms.service;

import java.util.List;

import com.pms.pojo.Notice;

public interface NoticeService {
	public int deleteByPrimaryKey(Integer id);
	public int insertByNoId(Notice notice);
	public List<Notice> getAllNotice();
	public Notice getByPrimaryKey(Integer id);
}
