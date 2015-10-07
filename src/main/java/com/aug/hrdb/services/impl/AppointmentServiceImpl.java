package com.aug.hrdb.services.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AppointmentDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;
import com.aug.hrdb.repositories.AppointmentRepository;
import com.aug.hrdb.services.AppointmentService;


@Service(value="appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public AppointmentDto findById(Integer id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id);
	}

	@Override
	public List<Appointment> findByApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByApplicant(applicant);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteById(id);

	}

	@Override
	public void update(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.update(appointment);
	}

	@Override
	public void delete(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.delete(appointment);
	}

	@Override
	public void create(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.create(appointment);
	}

	@Override
	public List<AppointmentDto> findAppointment(String start, String end, Integer mailStatus) {
		// TODO Auto-generated method stub
		return appointmentRepository.findAppointment(start, end, mailStatus);
	}

	@Override
	public Appointment find(Integer id) {
		// TODO Auto-generated method stub
		return appointmentRepository.find(id);
	}

	

}
