package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.RoomMapper;
import com.pms.pojo.Room;
import com.pms.service.RoomService;

@Service("roomService")
public class RoomServiceImpl implements RoomService{
	
	@Resource(name = "roomMapper")
	private RoomMapper roomMapper;
	
	@Override
	public List<Room> getRoom(){
		return roomMapper.selectAllRoom();
	}
	
	public Room getByPrimaryKey(Integer roomId){
		return roomMapper.selectByPrimaryKey(roomId);
	}
	
	public int updateByRegister(Integer ownerId, Integer roomId){
		return roomMapper.updateByRegister(ownerId, roomId);
	}
}
