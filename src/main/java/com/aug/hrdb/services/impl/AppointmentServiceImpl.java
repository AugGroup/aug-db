package com.aug.hrdb.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.AppointmentRepository;
import com.aug.hrdb.services.AppointmentService;


@Service(value="AppointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	/*@Autowired
	ApplicantRepository applicantRepository;*/
	
	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment findById(Integer id) {
		// TODO Auto-generated method stub
		return appointmentRepository.find(id);
	}

	@Override
	public List<Appointment> findByApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByApplicant(applicant);
	}

	@Override
	public void create(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.create(appointment);
	}

}
