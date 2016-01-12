package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.Room;
import com.aug.hrdb.repositories.RoomRepository;

@Repository(value = "roomRepository")
public class RoomRepositoryImpl extends GenericRepositoryImpl<Room, Integer> implements RoomRepository {

  public RoomRepositoryImpl() {
    super(Room.class);
  }

}