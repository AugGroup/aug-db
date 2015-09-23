package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;

public interface AppointmentRepository extends GenericRepository<Appointment, Integer>{

	List<Appointment> findByApplicant(Applicant applicant);

}
