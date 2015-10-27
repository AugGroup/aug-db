package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.Room;

public interface RoomService {
	public List<Room> findAll();
	public Room findById(Integer Id);
	public void deleteById(Integer id);
	public void update(Room room);
	public void delete(Room room);
	public void create(Room room);
}
