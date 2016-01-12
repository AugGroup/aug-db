package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Room;
import com.aug.hrdb.repositories.RoomRepository;
import com.aug.hrdb.services.RoomService;


@Transactional
@Service(value = "roomService")
public class RoomServiceImpl implements RoomService {

  @Autowired
  RoomRepository roomRepository;

  @Override
  public List<Room> findAll() {
    return roomRepository.findAll();
  }

  @Override
  public Room findById(Integer Id) {
    return roomRepository.find(Id);
  }

  @Override
  public void deleteById(Integer id) {
    roomRepository.deleteById(id);
  }

  @Override
  public void update(Room room) {
    roomRepository.update(room);
  }

  @Override
  public void delete(Room room) {
    roomRepository.delete(room);
  }

  @Override
  public void create(Room room) {
    roomRepository.create(room);
  }

}