package com.aug.hrdb.repositories;

//import java.sql.Date;
import java.util.List;

import com.aug.hrdb.dto.AppointmentDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;

public interface AppointmentRepository extends GenericRepository<Appointment, Integer>{

	List<Appointment> findByApplicant(Applicant applicant);

	void create(Appointment appointment);
	
	void update(Appointment appointment);

	void delete(Appointment appointment);

	List<AppointmentDto> findAppointment(String start, String end, Integer mailStatus);
	
	public AppointmentDto findById(Integer id);
	
	public Appointment find(Integer id);

	int countMailStatus(Integer status);
}
