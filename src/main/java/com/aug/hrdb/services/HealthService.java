package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.HealthDto;
import com.aug.hrdb.entities.Health;




public interface HealthService {

	public void create(Health health);
	public void update(Health health);
	public void delete(Health health);
	public Health find(Integer Id);
	public List<Health> findAll();
	public Health createSetDtoToEnity(HealthDto healthDto);
	public HealthDto findByIdReturnToDto(Integer id);
	public void updateSetDtoToEntity(HealthDto healthDto);
	public HealthDto findByEmployeeId(Integer id);
}
