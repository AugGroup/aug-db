package com.aug.hrdb.services;

import java.io.Serializable;
//import java.sql.Date;
import java.util.List;

import com.aug.hrdb.dto.AppointmentDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;


public interface AppointmentService {
	public List<Appointment> findAll();
	public AppointmentDto findById(Integer id);
	public List<Appointment> findByApplicant(Applicant applicant);
	public void deleteById(Integer id);
	public void update(Appointment appointment);
	public void delete(Appointment appointment);
	public void create(Appointment appointment);
	public  List<AppointmentDto> findAppointment(String start, String end, Integer mailStatus);
	public Appointment find(Integer id);
}
