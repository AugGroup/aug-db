package com.aug.hrdb.services.impl;

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
		return appointmentRepository.findAll();
	}

	@Override
	public AppointmentDto findById(Integer id) {
		return appointmentRepository.findById(id);
	}

	@Override
	public List<Appointment> findByApplicant(Applicant applicant) {
		return appointmentRepository.findByApplicant(applicant);
	}

	@Override
	public void deleteById(Integer id) {
		appointmentRepository.deleteById(id);

	}

	@Override
	public void update(Appointment appointment) {
		appointmentRepository.update(appointment);
	}

	@Override
	public void delete(Appointment appointment) {
		appointmentRepository.delete(appointment);
	}

	@Override
	public void create(Appointment appointment) {
		appointmentRepository.create(appointment);
	}

	@Override
	public List<AppointmentDto> findAppointment(String start, String end) {
		return appointmentRepository.findAppointment(start, end);
	}

	@Override
	public Appointment find(Integer id) {
		return appointmentRepository.find(id);
	}

	@Override
	public int countMailStatus(Integer status) {
		return appointmentRepository.countMailStatus(status);
	}

}
