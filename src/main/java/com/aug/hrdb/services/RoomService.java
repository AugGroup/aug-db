package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.Room;

public interface RoomService {

  List<Room> findAll();

  Room findById(Integer Id);

  void deleteById(Integer id);

  void update(Room room);

  void delete(Room room);

  void create(Room room);

}