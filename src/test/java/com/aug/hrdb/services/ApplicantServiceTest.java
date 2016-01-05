package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.JoblevelDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.*;
import com.aug.hrdb.repositories.*;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasJobLevelService;
import com.aug.hrdb.services.MasTechnologyService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
@TransactionConfiguration
@Transactional
public class ApplicantServiceTest {

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private MasCoreSkillService masCoreSkillService;

	@Autowired
	private MasTechnologyService masTechnologyService;

	@Autowired
	private MasJobLevelService masJobLevelService;

	@Autowired
	private MasDegreeTypeService masDegreeTypeService;

	private Applicant applicant;

	private MasDegreeType masDegreeType;

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
		masJobLevel.setTag("t");
		masJobLevelService.create(masJobLevel);

		MasTechnology masTechnology = new MasTechnology();
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(1);
		masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masTechnology.setIsActive(true);
		masTechnology.setCode("1");
		masTechnology.setName("Java");
		masTechnologyService.create(masTechnology);

		applicant = new Applicant();
		applicant.setAuditFlag("C");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
		applicant.setJoblevel(masJobLevelService.findById(masJobLevel.getId()));
		applicant.setTechnology(masTechnologyService.findById(masTechnology.getId()));
		applicant.setFirstNameEN("Anat");
		applicant.setTrackingStatus("Interview");
		applicant.setApplyDate(Calendar.getInstance().getTime());
		applicantService.create(applicant);

		//create mas degree
		masDegreeType = new MasDegreeType();
		masDegreeType.setName("Bachelor");
		masDegreeType.setCode("B");
		masDegreeType.setIsactive(true);
		masDegreeType.setAuditFlag("C");
		masDegreeType.setCreatedBy(1);
		masDegreeType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreeTypeService.create(masDegreeType);

		//first date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Calendar first = Calendar.getInstance();
		first.set(Calendar.DAY_OF_MONTH, 1);
		Date today = first.getTime();
		startDate = df.format(today);

		//last date
		Calendar last = Calendar.getInstance();
		last.set(Calendar.DAY_OF_MONTH, last.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDay = last.getTime();
		endDate = df.format(lastDay);

	}

	@Test
	public void testLoadServicesShouldPass() throws Exception {
		assertNotNull(applicantService);
		assertNotNull(masCoreSkillService);
		assertNotNull(masTechnologyService);
		assertNotNull(masJobLevelService);
		assertNotNull(masDegreeTypeService);

	}
	
	@Test
	public void testFindWithApplicantServiceShouldReturnSetupApplicant() throws Exception {
		Applicant result = applicantService.findById(applicant.getId());
		assertNotNull(result);
		assertThat(result.getFirstNameEN(), is("Anat"));

	}

	@Test
	public void testFindAllWithApplicantServiceShouldReturnListOfApplicant() throws Exception {
		List<Applicant> result = applicantService.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithApplicantServiceShouldReturnApplicantThatUpdated() throws Exception {
		Applicant update = applicantService.findById(applicant.getId());
		update.setFirstNameEN("AnatUpdate");
		applicantService.update(update);

		Applicant result = applicantService.findById(update.getId());
		assertNotNull(result);
		assertThat(result.getId(), is(update.getId()));
		assertThat(result.getFirstNameEN(), is("AnatUpdate"));

	}

	@Test
	public void testDeleteWithApplicantServiceShouldNotFindApplicantThatDelete() throws Exception {
		Applicant delete = applicantService.findById(applicant.getId());
		applicantService.delete(delete);

		Applicant result = applicantService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithApplicantServiceShouldNotFindApplicantThatDelete() throws Exception {
		Applicant delete = applicantService.findById(applicant.getId());
		applicantService.deleteById(delete.getId());

		Applicant result = applicantService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindApplicantByIdWithApplicantServiceShouldReturnSetupApplicant() throws Exception {
		ApplicantDto result = applicantService.findApplicantById(applicant.getId());
		assertNotNull(result);
		assertThat(result.getFirstNameEN(), is("Anat"));

	}

	@Test
	public void testFindAllApplicantWithApplicantServiceShouldReturnListOfAllApplicant() throws Exception {
		List<ApplicantDto> result = applicantService.findAllApplicant();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testFindByJobLevelWithApplicantServiceShouldReturnListOfApplicantThatHaveSetupJobLevel() throws Exception {
		List<ApplicantDto> result = applicantService.findByJoblevel(applicant.getJobLevel().getName());
		assertNotNull(result);
		assertThat(result.get(0).getJoblevelStr(), is("Consultant"));

	}

	@Test
	public void testFindByTrackingStatusWithApplicantServiceShouldReturnListOfApplicantThatHaveTrackingStatusSameSetup() throws Exception {
		List<ApplicantDto> result = applicantService.findByTrackingStatus(applicant.getTrackingStatus());
		assertNotNull(result);
		assertThat(result.get(0).getTrackingStatus(), is("Interview"));

	}

	@Test
	public void testCheckTagWithApplicantServiceShouldReturnListOfJobLevelThatHaveTagSameSetup() throws Exception {
		List<JoblevelDto> result = applicantService.checkTag(applicant.getJobLevel().getTag());
		assertNotNull(result);
		assertThat(result.get(0).getTag(), is("t"));

	}

	@Test
	public void testReportApplicantWithApplicantServiceShouldReturnListOfReportApplicant() throws Exception {
		List<ReportApplicantDto> result = applicantService.reportApplicant();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

//	wait education
//	@Test
//	public void testFindReportByCriteriaWithApplicantServiceShouldReturnListOfReportApplicant() throws Exception {
//		List<ReportApplicantDto> result = applicantService.findReportByCriteria(applicant.getTechnology().getId(),
//																				applicant.getJobLevel().getId(), 0, "", "", 0.0);
//		assertNotNull(result);
//		assertThat(result.size(), is(new GreaterOrEqual<>(1)));
//
//	}

	@Test
	public void testFindReportByMonthWithApplicantServiceShouldReturnListOfReportApplicant() throws Exception {
		List<ReportApplicantDto> result = applicantService.findReportByMonth(startDate, endDate);
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

//	@Test
//	public void testUpdateByDtoWithApplicantServiceShouldReturnUpdatedApplicant() throws Exception {
//		ApplicantDto update = applicantService.findApplicantById(applicant.getId());
//		assertNotNull(update);
//		assertThat(update.getFirstNameEN(), is("Anat"));
//
//		Applicant result = new Applicant();
//		result = result.fromApplicantDTO(result, update);
//		result.setFirstNameEN("AnatUpdate");
//		System.out.println(">>>" + result.getFirstNameEN());
//		applicantService.update(result);
//
//		ApplicantDto result2 = applicantService.findApplicantById(update.getId());
//		assertNotNull(result2);
//		assertThat(result2.getFirstNameEN(), is("AnatUpdate"));
//
//	}

	@Test
	public void testGetMaxApplicantIdWithApplicantServiceShouldReturnSetupId() throws Exception {
		ApplicantDto result = applicantService.getMaxApplicantId();
		assertThat(result.getId(), is(applicant.getId()));

	}

}
