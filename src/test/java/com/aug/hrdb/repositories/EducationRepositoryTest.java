package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class EducationRepositoryTest {

	@Autowired
	private MasCoreSkillRepository masCoreSkillRepository;

	@Autowired
	private MasTechnologyRepository masTechnologyRepository;

	@Autowired
	private MasJobLevelRepository masJobLevelRepository;

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private MasDegreeTypeRepository masDegreeTypeRepository;

	@Autowired
	private EducationRepository educationRepository;

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

		// create mas degree
		MasDegreeType masDegreeType = new MasDegreeType();
		masDegreeType.setAuditFlag("C");
		masDegreeType.setCreatedBy(1);
		masDegreeType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreeType.setIsactive(true);
		masDegreeType.setName("Bachelor");
		masDegreeType.setCode("B");
		masDegreeTypeRepository.create(masDegreeType);

		// create education
		education = new Education();
		education.setAuditFlag("C");
		education.setCreatedBy(1);
		education.setCreatedTimeStamp(Calendar.getInstance().getTime());
		education.setUniversity("Kasetsart University");
		education.setMajor("Computer Engineering");
		education.setMasdegreetype(masDegreeType);
		education.setApplicant(applicant);
		educationRepository.create(education);

	}

	@Test
	public void testLoadRepositoriesShouldPass() throws Exception {
		assertNotNull(masDegreeTypeRepository);
		assertNotNull(educationRepository);
		assertNotNull(masTechnologyRepository);
		assertNotNull(masJobLevelRepository);
		assertNotNull(masCoreSkillRepository);
		assertNotNull(applicantRepository);

	}

	@Test
	public void testFindWithEducationRepositoryShouldReturnEducationThatSetUp() throws Exception {
		Education result = educationRepository.find(education.getId());
		assertNotNull(result);
		assertThat(result.getUniversity(), is("Kasetsart University"));
		assertThat(result.getMajor(), is("Computer Engineering"));

	}

	@Test
	public void testFindAllWithEducationRepositoryShouldReturnListOfAllEducation() throws Exception {
		List<Education> result = educationRepository.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithEducationRepositoryShouldReturnEducationThatUpdate() throws Exception {
		Education update = educationRepository.find(education.getId());
		assertThat(update.getUniversity(), is("Kasetsart University"));
		assertThat(update.getMajor(), is("Computer Engineering"));

		update.setMajor("Computer Science");
		educationRepository.update(update);

		Education result = educationRepository.find(update.getId());
		assertThat(result.getMajor(), is("Computer Science"));

	}

	@Test
	public void testDeleteWithEducationRepositoryShouldNotFindEducationThatDelete() throws Exception {
		Education delete = educationRepository.find(education.getId());
		educationRepository.delete(delete);

		Education result = educationRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithEducationRepositoryShouldNotFindEducationThatDelete() throws Exception {
		Education delete = educationRepository.find(education.getId());
		educationRepository.deleteById(delete.getId());

		Education result = educationRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindEducationByIdWithEducationRepositoryShouldListOfEducationOfThatApplicant() throws Exception {
		List<EducationDto> result = educationRepository.findEducationById(education.getApplicant().getId());
		assertNotNull(result);
		assertThat(result.get(0).getUniversity(), is("Kasetsart University"));
		assertThat(result.get(0).getMajor(), is("Computer Engineering"));

	}

	@Test
	public void testFindByEducationIdWithEducationRepositoryShouldReturnEducationThatSetUp() throws Exception {
		EducationDto result = educationRepository.findByEducationId(education.getId());
		assertNotNull(result);
		assertThat(result.getUniversity(), is("Kasetsart University"));
		assertThat(result.getMajor(), is("Computer Engineering"));

	}

	@Test
	public void testSearchEducationWithEducationRepositoryShouldListOfEducationOfThatApplicant() throws Exception {
		List<EducationDto> result = educationRepository.searchEducation(education.getApplicant().getId());
		assertNotNull(result);
		assertThat(result.get(0).getUniversity(), is("Kasetsart University"));
		assertThat(result.get(0).getMajor(), is("Computer Engineering"));

	}

}