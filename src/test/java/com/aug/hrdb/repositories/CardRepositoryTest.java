package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.CardDto;
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
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class CardRepositoryTest {

	@Autowired
	private MasCoreSkillRepository masCoreSkillRepository;

	@Autowired
	private MasJobLevelRepository masJobLevelRepository;

	@Autowired
	private MasTechnologyRepository masTechnologyRepository;

	@Autowired
	private MasDivisionRepository masDivisionRepository;

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CardRepository cardRepository;

	private Card card;

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

		// create mas division
		MasDivision masDivision = new MasDivision();
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDivision.setIsActive(true);
		masDivision.setCode("ITS");
		masDivision.setName("Integrate Technology Services");
		masDivisionRepository.create(masDivision);

		// create employee
		Employee employee = new Employee();
		employee.setAuditFlag("C");
		employee.setCreatedBy(1);
		employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
		employee.setEmployeeCode("TEST0001");
		employee.setStatusEmp("Employee");
		employee.setTelHome("02-9998877");
		employee.setApplicant(applicant);
		employee.setMasDivision(masDivision);
		employeeRepository.create(employee);

		// create card
		card = new Card();
		card.setAuditFlag("C");
		card.setCreatedBy(1);
		card.setCreatedTimeStamp(Calendar.getInstance().getTime());
		card.setCard_no("CC0001");
		card.setStartdate(new Date());
		card.setStatus("Test");
		card.setEmployee(employee);
		cardRepository.create(card);

	}

	@Test
	public void testLoadRepositoriesShouldPass() throws Exception {
		assertNotNull(cardRepository);
		assertNotNull(masCoreSkillRepository);
		assertNotNull(masJobLevelRepository);
		assertNotNull(masDivisionRepository);
		assertNotNull(masTechnologyRepository);
		assertNotNull(employeeRepository);
		assertNotNull(applicantRepository);

	}

	@Test
	public void testFindWithCardRepositoryShouldReturnCardThatSetup() throws Exception {
		Card result = cardRepository.find(card.getId());
		assertNotNull(result);
		assertThat(result.getCard_no(), is("CC0001"));

	}

	@Test
	public void testFindAllWithCardRepositoryShouldReturnListOfAllCard() throws Exception {
		List<Card> result = cardRepository.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithCardRepositoryShouldReturnCardThatUpdate() throws Exception {
		Card update = cardRepository.find(card.getId());
		assertThat(update.getCard_no(), is("CC0001"));
		update.setCard_no("CC9999");
		cardRepository.update(update);

		Card result = cardRepository.find(update.getId());
		assertThat(result.getCard_no(), is("CC9999"));

	}

	@Test
	public void testDeleteWithCardRepositoryShouldNotFindThatCard() throws Exception {
		Card delete = cardRepository.find(card.getId());
		cardRepository.delete(delete);

		Card result = cardRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithCardRepositoryShouldNotFindThatCard() throws Exception {
		Card delete = cardRepository.find(card.getId());
		cardRepository.deleteById(delete.getId());

		Card result = cardRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindByCriteriaWithCardRepositoryShouldReturnListOfCardThatHaveCardNumberSameSetup() throws Exception {
		List<Card> result = cardRepository.findByCriteria(card);
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testSearchCardWithCardRepositoryShouldReturnListOfCardThatHaveEmployeeIdSameSetup() throws Exception {
		List<CardDto> result = cardRepository.searchCard(card.getEmployee().getId());
		assertNotNull(result);
		assertThat(result.get(0).getCard_no(), is("CC0001"));

	}

}
