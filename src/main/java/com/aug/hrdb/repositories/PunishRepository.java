package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.PunsihDto;
import com.aug.hrdb.entities.Punish;



public interface PunishRepository extends GenericRepository<Punish, Integer> {
	
	public List<Punish> findByCriteria(Punish punish);
	public Punish deleteById(Integer id);
	public List<PunsihDto> searchPunish(Integer id);
	
}
