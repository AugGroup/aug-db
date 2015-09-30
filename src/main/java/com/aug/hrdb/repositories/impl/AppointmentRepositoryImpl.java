package com.aug.hrdb.repositories.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.List;



import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AppointmentDto;
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

	@Override
	public List<AppointmentDto> findAppointment(String start, String end) {
		// TODO Auto-generated method stub
		org.hibernate.Query query = getCurrentSession().getNamedQuery("FIND_APPOINTMENT");
		query.setParameter("START", start);
		query.setParameter("END", end);
		List<AppointmentDto> appointments = query.list();
		
		return appointments;
	}

	@Override
	public AppointmentDto findById(Integer id) {
		// TODO Auto-generated method stub
		org.hibernate.Query query = getCurrentSession().getNamedQuery("GET_APPOINTMENT_BY_ID");
		query.setParameter("ID", id);
		List<AppointmentDto> appointments = query.list();
		return appointments.get(0);
	}

}
