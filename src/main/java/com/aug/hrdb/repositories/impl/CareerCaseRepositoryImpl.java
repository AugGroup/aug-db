package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.CareerCase;
import com.aug.hrdb.repositories.CareerCaseRepository;

@Repository(value="careerCaseRepository")
public class CareerCaseRepositoryImpl extends GenericRepositoryImpl<CareerCase, Integer> implements CareerCaseRepository {

	public CareerCaseRepositoryImpl() {
		super(CareerCase.class);
	}

}