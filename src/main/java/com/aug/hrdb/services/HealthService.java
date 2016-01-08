package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.HealthDto;
import com.aug.hrdb.entities.Health;

public interface HealthService {

  void create(Health health);

  void update(Health health);

  void delete(Health health);

  Health find(Integer Id);

  List<Health> findAll();

  void deleteById(Integer id);

  Health createSetDtoToEntity(HealthDto healthDto);

  HealthDto findByIdReturnToDto(Integer id);

  void updateSetDtoToEntity(HealthDto healthDto);

  HealthDto findByEmployeeId(Integer id);

}