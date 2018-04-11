package com.pms.service;

import java.util.List;

import com.pms.pojo.Room;

public interface RoomService {
	public Room getByPrimaryKey(Integer roomId);
	public List<Room> getRoom();
	public int updateByRegister(Integer ownerId, Integer roomId);
}
