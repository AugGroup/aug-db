package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.EducationDto;
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
public class EducationServiceTest {

	@Autowired
	private MasCoreSkillService masCoreSkillService;

	@Autowired
	private MasTechnologyService masTechnologyService;

	@Autowired
	private MasJobLevelService masJobLevelService;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private MasDegreeTypeService masDegreeTypeService;

	@Autowired
	private EducationService educationService;

	private Education education;

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

		// create mas degree
		MasDegreeType masDegreeType = new MasDegreeType();
		masDegreeType.setAuditFlag("C");
		masDegreeType.setCreatedBy(1);
		masDegreeType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreeType.setIsactive(true);
		masDegreeType.setName("Bachelor");
		masDegreeType.setCode("B");
		masDegreeTypeService.create(masDegreeType);

		// create education
		education = new Education();
		education.setAuditFlag("C");
		education.setCreatedBy(1);
		education.setCreatedTimeStamp(Calendar.getInstance().getTime());
		education.setUniversity("Kasetsart University");
		education.setMajor("Computer Engineering");
		education.setMasdegreetype(masDegreeType);
		education.setApplicant(applicant);
		educationService.create(education);

	}

	@Test
	public void testLoadServicesShouldPass() throws Exception {
		assertNotNull(masDegreeTypeService);
		assertNotNull(educationService);
		assertNotNull(masCoreSkillService);
		assertNotNull(masJobLevelService);
		assertNotNull(masTechnologyService);
		assertNotNull(applicantService);

	}

	@Test
	public void testFindWithEducationServiceShouldReturnEducationThatSetUp() throws Exception {
		Education result = educationService.findById(education.getId());
		assertNotNull(result);
		assertThat(result.getUniversity(), is("Kasetsart University"));
		assertThat(result.getMajor(), is("Computer Engineering"));

	}

	@Test
	public void testFindAllWithEducationServiceShouldReturnListOfAllEducation() throws Exception {
		List<Education> result = educationService.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithEducationServiceShouldReturnEducationThatUpdate() throws Exception {
		Education update = educationService.findById(education.getId());
		assertThat(update.getUniversity(), is("Kasetsart University"));
		assertThat(update.getMajor(), is("Computer Engineering"));

		update.setMajor("Computer Science");
		educationService.update(update);

		Education result = educationService.findById(update.getId());
		assertThat(result.getMajor(), is("Computer Science"));

	}

	@Test
	public void testDeleteWithEducationServiceShouldNotFindEducationThatDelete() throws Exception {
		Education delete = educationService.findById(education.getId());
		educationService.delete(delete);

		Education result = educationService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithEducationServiceShouldNotFindEducationThatDelete() throws Exception {
		Education delete = educationService.findById(education.getId());
		educationService.deleteById(delete.getId());

		Education result = educationService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindEducationByIdWithEducationServiceShouldListOfEducationOfThatApplicant() throws Exception {
		List<EducationDto> result = educationService.findEducationById(education.getApplicant().getId());
		assertNotNull(result);
		assertThat(result.get(0).getUniversity(), is("Kasetsart University"));
		assertThat(result.get(0).getMajor(), is("Computer Engineering"));

	}

	@Test
	public void testFindByEducationIdWithEducationServiceShouldReturnEducationThatSetUp() throws Exception {
		EducationDto result = educationService.findByEducationId(education.getId());
		assertNotNull(result);
		assertThat(result.getUniversity(), is("Kasetsart University"));
		assertThat(result.getMajor(), is("Computer Engineering"));

	}

	@Test
	public void testSearchEducationWithEducationServiceShouldListOfEducationOfThatApplicant() throws Exception {
		List<EducationDto> result = educationService.searchEducation(education.getApplicant().getId());
		assertNotNull(result);
		assertThat(result.get(0).getUniversity(), is("Kasetsart University"));
		assertThat(result.get(0).getMajor(), is("Computer Engineering"));

	}

}