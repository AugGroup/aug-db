package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.JoblevelDto;
import com.aug.hrdb.dto.ReportApplicantDto;
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
public class ApplicantRepositoryTest {

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private MasCoreSkillRepository masCoreSkillRepository;

	@Autowired
	private MasTechnologyRepository masTechnologyRepository;

	@Autowired
	private MasJobLevelRepository masJobLevelRepository;

	@Autowired
	private MasDegreeTypeRepository masDegreeTypeRepository;

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
		masCoreSkillRepository.create(masCoreSkill);

		MasJobLevel masJobLevel = new MasJobLevel();
		masJobLevel.setAuditFlag("C");
		masJobLevel.setCreatedBy(1);
		masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJobLevel.setIsActive(true);
		masJobLevel.setCode("C");
		masJobLevel.setName("Consultant");
		masJobLevel.setTag("t");
		masJobLevelRepository.create(masJobLevel);

		MasTechnology masTechnology = new MasTechnology();
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(1);
		masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masTechnology.setIsActive(true);
		masTechnology.setCode("1");
		masTechnology.setName("Java");
		masTechnologyRepository.create(masTechnology);

		applicant = new Applicant();
		applicant.setAuditFlag("C");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
		applicant.setJoblevel(masJobLevelRepository.find(masJobLevel.getId()));
		applicant.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
		applicant.setFirstNameEN("Anat");
		applicant.setTrackingStatus("Interview");
		applicant.setApplyDate(Calendar.getInstance().getTime());
		applicantRepository.create(applicant);

		//create mas degree
		masDegreeType = new MasDegreeType();
		masDegreeType.setName("Bachelor");
		masDegreeType.setCode("B");
		masDegreeType.setIsactive(true);
		masDegreeType.setAuditFlag("C");
		masDegreeType.setCreatedBy(1);
		masDegreeType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreeTypeRepository.create(masDegreeType);

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
	public void testLoadRepositoryShouldPass() throws Exception {
		assertNotNull(applicantRepository);
		assertNotNull(masCoreSkillRepository);
		assertNotNull(masJobLevelRepository);
		assertNotNull(masTechnologyRepository);

	}

	@Test
	public void testFindWithApplicantRepositoryShouldReturnSetupApplicant() throws Exception {
		Applicant result = applicantRepository.find(applicant.getId());
		assertNotNull(result);
		assertThat(result.getFirstNameEN(), is("Anat"));

	}

	@Test
	public void testFindAllWithApplicantRepositoryShouldReturnListOfApplicant() throws Exception {
		List<Applicant> result = applicantRepository.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithApplicantRepositoryShouldReturnApplicantThatUpdated() throws Exception {
		Applicant update = applicantRepository.find(applicant.getId());
		update.setFirstNameEN("AnatUpdate");
		applicantRepository.update(update);

		Applicant result = applicantRepository.find(update.getId());
		assertNotNull(result);
		assertThat(result.getId(), is(update.getId()));
		assertThat(result.getFirstNameEN(), is("AnatUpdate"));

	}

	@Test
	public void testDeleteWithApplicantRepositoryShouldNotFindApplicantThatDelete() throws Exception {
		Applicant delete = applicantRepository.find(applicant.getId());
		applicantRepository.delete(delete);

		Applicant result = applicantRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithApplicantRepositoryShouldNotFindApplicantThatDelete() throws Exception {
		Applicant delete = applicantRepository.find(applicant.getId());
		applicantRepository.deleteById(delete.getId());

		Applicant result = applicantRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindApplicantByIdWithApplicantRepositoryShouldReturnSetupApplicant() throws Exception {
		ApplicantDto result = applicantRepository.findApplicantById(applicant.getId());
		assertNotNull(result);
		assertThat(result.getFirstNameEN(), is("Anat"));

	}

	@Test
	public void testFindAllApplicantWithApplicantRepositoryShouldReturnListOfAllApplicant() throws Exception {
		List<ApplicantDto> result = applicantRepository.findAllApplicant();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testFindByJobLevelWithApplicantRepositoryShouldReturnListOfApplicantThatHaveSetupJobLevel() throws Exception {
		List<ApplicantDto> result = applicantRepository.findByJoblevel(applicant.getJobLevel().getName());
		assertNotNull(result);
		assertThat(result.get(0).getJoblevelStr(), is("Consultant"));

	}

	@Test
	public void testFindByTrackingStatusWithApplicantRepositoryShouldReturnListOfApplicantThatHaveTrackingStatusSameSetup() throws Exception {
		List<ApplicantDto> result = applicantRepository.findByTrackingStatus(applicant.getTrackingStatus());
		assertNotNull(result);
		assertThat(result.get(0).getTrackingStatus(), is("Interview"));

	}

	@Test
	public void testCheckTagWithApplicantRepositoryShouldReturnListOfJobLevelThatHaveTagSameSetup() throws Exception {
		List<JoblevelDto> result = applicantRepository.checkTag(applicant.getJobLevel().getTag());
		assertNotNull(result);
		assertThat(result.get(0).getTag(), is("t"));

	}

	@Test
	public void testReportApplicantWithApplicantRepositoryShouldReturnListOfReportApplicant() throws Exception {
		List<ReportApplicantDto> result = applicantRepository.reportApplicant();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

//	wait education
//	@Test
//	public void testFindReportByCriteriaWithApplicantRepositoryShouldReturnListOfReportApplicant() throws Exception {
//		List<ReportApplicantDto> result = applicantRepository.findReportByCriteria(applicant.getTechnology().getId(),
//																				applicant.getJobLevel().getId(), 0, "", "", 0.0);
//		assertNotNull(result);
//		assertThat(result.size(), is(new GreaterOrEqual<>(1)));
//
//	}

	@Test
	public void testFindReportByMonthWithApplicantRepositoryShouldReturnListOfReportApplicant() throws Exception {
		List<ReportApplicantDto> result = applicantRepository.findReportByMonth(startDate, endDate);
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

//	@Test
//	public void testUpdateByDtoWithApplicantRepositoryShouldReturnUpdatedApplicant() throws Exception {
//		ApplicantDto update = applicantRepository.findApplicantById(applicant.getId());
//		assertNotNull(update);
//		assertThat(update.getFirstNameEN(), is("Anat"));
//
//		Applicant result = new Applicant();
//		result = result.fromApplicantDTO(result, update);
//		result.setFirstNameEN("AnatUpdate");
//		System.out.println(">>>" + result.getFirstNameEN());
//		applicantRepository.update(result);
//
//		ApplicantDto result2 = applicantRepository.findApplicantById(update.getId());
//		assertNotNull(result2);
//		assertThat(result2.getFirstNameEN(), is("AnatUpdate"));
//
//	}

	@Test
	public void testGetMaxApplicantIdWithApplicantRepositoryShouldReturnSetupId() throws Exception {
		ApplicantDto result = applicantRepository.getMaxApplicantId();
		assertThat(result.getId(), is(applicant.getId()));

	}

}
