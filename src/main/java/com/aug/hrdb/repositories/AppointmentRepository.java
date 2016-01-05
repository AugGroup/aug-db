package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.AppointmentDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;

public interface AppointmentRepository extends GenericRepository<Appointment, Integer>{

	List<Appointment> findByApplicant(Applicant applicant);

	List<AppointmentDto> findAppointment(String start, String end);
	
	AppointmentDto findById(Integer id);

	int countMailStatus(Integer status);

}
