package com.aug.hrdb.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.HealthDto;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Health;
import com.aug.hrdb.repositories.HealthRepository;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.HealthService;

@Transactional
@Service(value = "healthService")
public class HealthServiceImpl implements HealthService {

  @Autowired
  private HealthRepository healthRepository;

  @Autowired
  private EmployeeService employeeService;

  @Override
  public void create(Health health) {
    healthRepository.create(health);
  }

  @Override
  public void update(Health health) {
    healthRepository.update(health);
  }

  @Override
  public void delete(Health health) {
    healthRepository.delete(health);
  }

  @Override
  public Health find(Integer Id) {
    return healthRepository.find(Id);
  }

  @Override
  public List<Health> findAll() {
    return healthRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    healthRepository.deleteById(id);
  }

  @Override
  public Health createSetDtoToEntity(HealthDto healthDto) {
    Employee employee = employeeService.findById(healthDto.getEmployeeId());

    Health health = new Health();
    health.setAuditFlag("C");
    health.setCreatedBy(healthDto.getEmployeeId());
    health.setCreatedTimeStamp(Calendar.getInstance().getTime());
    health.setEmployee(employee);
    health.setCongenitalDisease(healthDto.getCongenitalDisease());
    health.setCongenitalDiseaseExplain(healthDto.getCongenitalDiseaseExplain());
    health.setCongenitalDiseaseExplain2(healthDto.getCongenitalDiseaseExplain2());
    health.setCongenitalDiseaseExplain3(healthDto.getCongenitalDiseaseExplain3());
    health.setGeneticDisease(healthDto.getGeneticDisease());
    health.setGeneticDiseaseExplain(healthDto.getGeneticDiseaseExplain());
    health.setGeneticDiseaseExplain2(healthDto.getGeneticDiseaseExplain2());
    health.setGeneticDiseaseExplain3(healthDto.getGeneticDiseaseExplain3());
    health.setTakeMedicine(healthDto.getTakeMedicine());
    health.setTakeMedicineExplain(healthDto.getTakeMedicineExplain());
    health.setIntolerance(healthDto.getIntolerance());
    health.setIntoleranceExplain(healthDto.getIntoleranceExplain());

    healthRepository.create(health);

    return health;

  }

  @Override
  public HealthDto findByIdReturnToDto(Integer id) {
    Health health = healthRepository.find(id);

    HealthDto healthDto = new HealthDto();
    healthDto.setId(health.getId());
    healthDto.setCongenitalDisease(health.getCongenitalDisease());
    healthDto.setCongenitalDiseaseExplain(health.getCongenitalDiseaseExplain());
    healthDto.setCongenitalDiseaseExplain2(health.getCongenitalDiseaseExplain2());
    healthDto.setCongenitalDiseaseExplain3(health.getCongenitalDiseaseExplain3());
    healthDto.setGeneticDisease(health.getGeneticDisease());
    healthDto.setGeneticDiseaseExplain(health.getGeneticDiseaseExplain());
    healthDto.setGeneticDiseaseExplain2(health.getGeneticDiseaseExplain2());
    healthDto.setGeneticDiseaseExplain3(health.getGeneticDiseaseExplain3());
    healthDto.setTakeMedicine(health.getTakeMedicine());
    healthDto.setTakeMedicineExplain(health.getTakeMedicineExplain());
    healthDto.setIntolerance(health.getIntolerance());
    healthDto.setIntoleranceExplain(health.getIntoleranceExplain());
    healthDto.setEmployeeId(health.getEmployee().getId());
    healthDto.setEmployeeCode(health.getEmployee().getEmployeeCode());

    return healthDto;

  }

  @Override
  public void updateSetDtoToEntity(HealthDto healthDto) {
    Health health = healthRepository.find(healthDto.getId());
    health.setAuditFlag("U");
    health.setUpdatedBy(healthDto.getEmployeeId());
    health.setUpdatedTimeStamp(Calendar.getInstance().getTime());
    health.setCongenitalDisease(healthDto.getCongenitalDisease());
    health.setCongenitalDiseaseExplain(healthDto.getCongenitalDiseaseExplain());
    health.setCongenitalDiseaseExplain2(healthDto.getCongenitalDiseaseExplain2());
    health.setCongenitalDiseaseExplain3(healthDto.getCongenitalDiseaseExplain3());
    health.setGeneticDisease(healthDto.getGeneticDisease());
    health.setGeneticDiseaseExplain(healthDto.getGeneticDiseaseExplain());
    health.setGeneticDiseaseExplain2(healthDto.getGeneticDiseaseExplain2());
    health.setGeneticDiseaseExplain3(healthDto.getGeneticDiseaseExplain3());
    health.setTakeMedicine(healthDto.getTakeMedicine());
    health.setTakeMedicineExplain(healthDto.getTakeMedicineExplain());
    health.setIntolerance(healthDto.getIntolerance());
    health.setIntoleranceExplain(healthDto.getIntoleranceExplain());

    healthRepository.update(health);

  }

  @Override
  public HealthDto findByEmployeeId(Integer id) {
    Health health = healthRepository.findByEmployeeId(id);

    HealthDto healthDto = new HealthDto();
    if (health != null) {
      healthDto.setId(health.getId());
      healthDto.setCongenitalDisease(health.getCongenitalDisease());
      healthDto.setCongenitalDiseaseExplain(health.getCongenitalDiseaseExplain());
      healthDto.setCongenitalDiseaseExplain2(health.getCongenitalDiseaseExplain2());
      healthDto.setCongenitalDiseaseExplain3(health.getCongenitalDiseaseExplain3());
      healthDto.setGeneticDisease(health.getGeneticDisease());
      healthDto.setGeneticDiseaseExplain(health.getGeneticDiseaseExplain());
      healthDto.setGeneticDiseaseExplain2(health.getGeneticDiseaseExplain2());
      healthDto.setGeneticDiseaseExplain3(health.getGeneticDiseaseExplain3());
      healthDto.setTakeMedicine(health.getTakeMedicine());
      healthDto.setTakeMedicineExplain(health.getTakeMedicineExplain());
      healthDto.setIntolerance(health.getIntolerance());
      healthDto.setIntoleranceExplain(health.getIntoleranceExplain());
      healthDto.setEmployeeId(health.getEmployee().getId());
      healthDto.setEmployeeCode(health.getEmployee().getEmployeeCode());
    }

    return healthDto;

  }

}