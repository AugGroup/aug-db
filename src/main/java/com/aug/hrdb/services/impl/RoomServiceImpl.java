package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Room;
import com.aug.hrdb.repositories.RoomRepository;
import com.aug.hrdb.services.RoomService;


@Service(value="roomService")
@Transactional
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}
	
	@Override
	public Room findById(Integer Id) {
		
		return  roomRepository.find(Id);
	}

	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		roomRepository.deleteById(id);

	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
		roomRepository.update(room);
	}

	@Override
	public void delete(Room room) {
		// TODO Auto-generated method stub
		roomRepository.delete(room);
	}

	@Override
	public void create(Room room) {
		// TODO Auto-generated method stub
		roomRepository.create(room);
	}
}
