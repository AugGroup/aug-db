package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class AppointmentRepositoryTest {

	@Autowired
	private MasCoreSkillRepository masCoreSkillRepository;

	@Autowired
	private MasJobLevelRepository masJobLevelRepository;

	@Autowired
	private MasTechnologyRepository masTechnologyRepository;

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

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
		masCoreSkillRepository.create(masCoreSkill);

		MasJobLevel masJobLevel = new MasJobLevel();
		masJobLevel.setAuditFlag("C");
		masJobLevel.setCreatedBy(1);
		masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJobLevel.setIsActive(true);
		masJobLevel.setCode("C");
		masJobLevel.setName("Consultant");
		masJobLevelRepository.create(masJobLevel);

		MasTechnology masTechnology = new MasTechnology();
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(1);
		masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masTechnology.setIsActive(true);
		masTechnology.setCode("1");
		masTechnology.setName("Java");
		masTechnologyRepository.create(masTechnology);

		Applicant applicant = new Applicant();
		applicant.setAuditFlag("C");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
		applicant.setJoblevel(masJobLevelRepository.find(masJobLevel.getId()));
		applicant.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
		applicantRepository.create(applicant);

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
		appointmentRepository.create(appointment);

	}

	@Test
	public void testLoadRepositoriesShouldPass() throws Exception {
		assertNotNull(appointmentRepository);
		assertNotNull(masTechnologyRepository);
		assertNotNull(masJobLevelRepository);
		assertNotNull(masCoreSkillRepository);
		assertNotNull(applicantRepository);

	}

	@Test
	public void testFindWithAppointmentRepositoryShouldReturnAppointmentThatSetup() throws Exception {
		Appointment result = appointmentRepository.find(appointment.getId());
		assertNotNull(result);
		assertThat(result.getColor(), is("#FFFFFF"));
		assertThat(result.getTopic(), is("Test topic"));

	}

	@Test
	public void testFindAllWithAppointmentRepositoryShouldReturnListOfAllAppointment() throws Exception {
		List<Appointment> result = appointmentRepository.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithAppointmentRepositoryShouldReturnAppointmentThatUpdated() throws Exception {
		Appointment update = appointmentRepository.find(appointment.getId());
		update.setTopic("Update topic");
		update.setMailStatus(1);
		appointmentRepository.update(update);

		Appointment result = appointmentRepository.find(update.getId());
		assertThat(result.getTopic(), is("Update topic"));
		assertThat(result.getMailStatus(), is(1));

	}

	@Test
	public void testDeleteWithAppointmentRepositoryShouldNotFindThatAppointment() throws Exception {
		Appointment delete = appointmentRepository.find(appointment.getId());
		appointmentRepository.delete(delete);

		Appointment result = appointmentRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithAppointmentRepositoryShouldNotFindThatAppointment() throws Exception {
		Appointment delete = appointmentRepository.find(appointment.getId());
		appointmentRepository.deleteById(delete.getId());

		Appointment result = appointmentRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindByApplicantWithAppointmentRepositoryShouldFindListOfAppointmentThatHasSelectedApplicant() throws Exception {
		List<Appointment> result = appointmentRepository.findByApplicant(appointment.getApplicant());
		assertNotNull(result);
		assertThat(result.get(0).getTopic(), is("Test topic"));
		assertThat(result.get(0).getColor(), is("#FFFFFF"));

	}

	@Test
	public void testFindAppointmentWithAppointmentRepositoryShouldFindListOfAppointmentThatBetweenStartAnsEndDate() throws Exception {
		List<AppointmentDto> result = appointmentRepository.findAppointment(startDate, endDate);
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testFindByIdWithAppointmentRepositoryShouldReturnAppointmentThatSetup() throws Exception {
		AppointmentDto result = appointmentRepository.findById(appointment.getId());
		assertNotNull(result);
		assertThat(result.getColor(), is("#FFFFFF"));
		assertThat(result.getTopic(), is("Test topic"));

	}

	@Test
	public void testCountMailStatusWithAppointmentRepositoryShouldReturnQuantityOfAppointment() throws Exception {
		int result = appointmentRepository.countMailStatus(0);
		assertThat(result, is(new GreaterOrEqual<>(1)));

	}

}
