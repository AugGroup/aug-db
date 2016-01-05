package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.AppointmentDto;
import com.aug.hrdb.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class AppointmentServiceTest {

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasJobLevelService masJobLevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private AppointmentService appointmentService;

  private Appointment appointment;

  private String startDate, endDate;

  @Before
  public void setUp() throws Exception {
    // create applicant
    MasCoreSkill masCoreSkill = new MasCoreSkill();
    masCoreSkill.setAuditFlag("C");
    masCoreSkill.setCreatedBy(1);
    masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masCoreSkill.setIsActive(true);
    masCoreSkill.setCode("ITS");
    masCoreSkill.setName("ITS");
    masCoreSkillService.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJobLevelService.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyService.create(masTechnology);

    Applicant applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
    applicant.setJoblevel(masJobLevelService.findById(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyService.findById(masTechnology.getId()));
    applicantService.create(applicant);

    // create date
    //first date
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    Calendar first = Calendar.getInstance();
    first.set(Calendar.DAY_OF_MONTH, 1);
    Date today = first.getTime();
    startDate = df.format(today);

    //last date
    Calendar last = Calendar.getInstance();
    last.set(Calendar.DAY_OF_MONTH, last.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date lastDay = last.getTime();
    endDate = df.format(lastDay);

    // create appointment
    appointment = new Appointment();
    appointment.setColor("#FFFFFF");
    appointment.setTopic("Test topic");
    appointment.setApplicant(applicant);
    appointment.setMailStatus(0);
    appointment.setStart(today);
    appointment.setEnd(lastDay);
    appointmentService.create(appointment);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(appointmentService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masTechnologyService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithAppointmentServiceShouldReturnAppointmentThatSetup() throws Exception {
    Appointment result = appointmentService.find(appointment.getId());
    assertNotNull(result);
    assertThat(result.getColor(), is("#FFFFFF"));
    assertThat(result.getTopic(), is("Test topic"));

  }

  @Test
  public void testFindAllWithAppointmentServiceShouldReturnListOfAllAppointment() throws Exception {
    List<Appointment> result = appointmentService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithAppointmentServiceShouldReturnAppointmentThatUpdated() throws Exception {
    Appointment update = appointmentService.find(appointment.getId());
    update.setTopic("Update topic");
    update.setMailStatus(1);
    appointmentService.update(update);

    Appointment result = appointmentService.find(update.getId());
    assertThat(result.getTopic(), is("Update topic"));
    assertThat(result.getMailStatus(), is(1));

  }

  @Test
  public void testDeleteWithAppointmentServiceShouldNotFindThatAppointment() throws Exception {
    Appointment delete = appointmentService.find(appointment.getId());
    appointmentService.delete(delete);

    Appointment result = appointmentService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithAppointmentServiceShouldNotFindThatAppointment() throws Exception {
    Appointment delete = appointmentService.find(appointment.getId());
    appointmentService.deleteById(delete.getId());

    Appointment result = appointmentService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByApplicantWithAppointmentServiceShouldFindListOfAppointmentThatHasSelectedApplicant() throws Exception {
    List<Appointment> result = appointmentService.findByApplicant(appointment.getApplicant());
    assertNotNull(result);
    assertThat(result.get(0).getTopic(), is("Test topic"));
    assertThat(result.get(0).getColor(), is("#FFFFFF"));

  }

  @Test
  public void testFindAppointmentWithAppointmentServiceShouldFindListOfAppointmentThatBetweenStartAnsEndDate() throws Exception {
    List<AppointmentDto> result = appointmentService.findAppointment(startDate, endDate);
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testFindByIdWithAppointmentServiceShouldReturnAppointmentThatSetup() throws Exception {
    AppointmentDto result = appointmentService.findById(appointment.getId());
    assertNotNull(result);
    assertThat(result.getColor(), is("#FFFFFF"));
    assertThat(result.getTopic(), is("Test topic"));

  }

  @Test
  public void testCountMailStatusWithAppointmentServiceShouldReturnQuantityOfAppointment() throws Exception {
    int result = appointmentService.countMailStatus(0);
    assertThat(result, is(new GreaterOrEqual<>(1)));

  }
  
}
