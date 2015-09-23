package com.aug.hrdb.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;
import com.aug.hrdb.repositories.AppointmentRepository;

@Repository
public class AppointmentRepositoryImpl extends GenericRepositoryImpl<Appointment, Integer> implements
		AppointmentRepository {

	public AppointmentRepositoryImpl() {
		super(Appointment.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Appointment> findByApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = new ArrayList<Appointment>();
		org.hibernate.Query query = getCurrentSession().createQuery(
				"From Appointment Where APPLICANT_ID=:applicant_id");
		query.setParameter("applicant_id", applicant.getId());
		appointments = query.list();
		return appointments;
	}

}
