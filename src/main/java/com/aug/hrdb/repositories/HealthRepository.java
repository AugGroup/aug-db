package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.HealthDto;
import com.aug.hrdb.entities.Health;



public interface HealthRepository extends GenericRepository<Health,Integer>{
	
	 public void create(Health health);
	 public void update(Health health);
	 public void delete(Health health);
	 public Health find(Integer Id);
	 public List<Health> findAll();	
	 public  List<HealthDto> listHealth(Integer id);
	 public Health findByEmployeeId(Integer id);
}
