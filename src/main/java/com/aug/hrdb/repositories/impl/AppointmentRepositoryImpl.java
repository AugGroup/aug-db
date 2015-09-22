package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.Appointment;
import com.aug.hrdb.repositories.AppointmentRepository;

@Repository
public class AppointmentRepositoryImpl extends GenericRepositoryImpl<Appointment, Integer> implements AppointmentRepository{

	public AppointmentRepositoryImpl() {
		super(Appointment.class);
		// TODO Auto-generated constructor stub
	}

}
