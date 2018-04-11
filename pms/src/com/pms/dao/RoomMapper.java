package com.pms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pms.pojo.Room;

@Repository("roomMapper")
public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
    
    //查询所有单元房信息
    List<Room> selectAllRoom();
    
    int updateByRegister(@Param("roomOwner")Integer ownerId, @Param("roomId")Integer roomId);
}