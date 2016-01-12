package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.PunishDto;
import com.aug.hrdb.entities.Punish;

public interface PunishService {

  void create(Punish punish);

  void update(Punish punish);

  void delete(Punish punish);

  Punish findById(Integer id);

  List<Punish> findAll();

  void deleteById(Integer id);

  List<Punish> findByCriteria(Punish punish);

  List<PunishDto> searchPunish(Integer id);

}