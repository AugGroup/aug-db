package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.PunishDto;
import com.aug.hrdb.entities.Punish;

public interface PunishRepository extends GenericRepository<Punish, Integer> {

  List<Punish> findByCriteria(Punish punish);

  List<PunishDto> searchPunish(Integer id);

}