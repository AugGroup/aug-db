package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.CareerCase;
import com.aug.hrdb.repositories.CareerCaseRepository;
import com.aug.hrdb.services.CareerCaseService;

@Service(value="careerCaseService")
@Transactional
public class CareerCaseServiceImpl implements CareerCaseService {

	@Autowired
	private CareerCaseRepository careerCaseRepository;

	@Override
	public List<CareerCase> findAll() throws DataAccessException {
		return careerCaseRepository.findAll();
	}

	@Override
	public CareerCase findById(Integer id) {
		return careerCaseRepository.find(id);
	}

	@Override
	public void create(CareerCase e) {
		careerCaseRepository.create(e);
	}

	@Override
	public void update(CareerCase e) {
		careerCaseRepository.update(e);
	}

	@Override
	public void delete(CareerCase e) {
		careerCaseRepository.delete(e);
	}

	@Override
	public void deleteById(Integer id) {
		careerCaseRepository.deleteById(id);
	}

}