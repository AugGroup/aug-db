package com.aug.hrdb.repositories.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AppointmentDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;
import com.aug.hrdb.repositories.AppointmentRepository;

@SuppressWarnings("unchecked")
@Repository(value = "appointmentRepository")
public class AppointmentRepositoryImpl extends GenericRepositoryImpl<Appointment, Integer> implements AppointmentRepository {

  public AppointmentRepositoryImpl() {
    super(Appointment.class);
  }

  @Override
  public List<Appointment> findByApplicant(Applicant applicant) {
    Query query = getCurrentSession().createQuery("From Appointment Where APPLICANT_ID = :applicant_id");
    query.setParameter("applicant_id", applicant.getId());
    List<Appointment> appointments = query.list();

    return appointments;

  }

  @Override
  public List<AppointmentDto> findAppointment(String start, String end) {
    Query query = getCurrentSession().getNamedQuery("FIND_APPOINTMENT");
    query.setParameter("START", start);
    query.setParameter("END", end);
    List<AppointmentDto> appointments = query.list();

    return appointments;

  }

  @Override
  public AppointmentDto findById(Integer id) {
    org.hibernate.Query query = getCurrentSession().getNamedQuery("GET_APPOINTMENT_BY_ID");
    query.setParameter("ID", id);
    List<AppointmentDto> appointments = query.list();

    return appointments.get(0);

  }

  @Override
  public int countMailStatus(Integer status) {
    Query query = getCurrentSession().createSQLQuery("SELECT COUNT(ID) FROM APPOINTMENT WHERE MAIL_STATUS=:STATUS");
    query.setParameter("STATUS", status);
    List<BigInteger> integers = query.list();

    return integers.get(0).intValue();

  }

}
