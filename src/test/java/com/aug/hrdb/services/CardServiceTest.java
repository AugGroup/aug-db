package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class CardServiceTest {

	@Autowired
	private MasCoreSkillService masCoreSkillService;

	@Autowired
	private MasJobLevelService masJobLevelService;

	@Autowired
	private MasTechnologyService masTechnologyService;

	@Autowired
	private MasDivisionService masDivisionService;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CardService cardService;

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

		// create mas division
		MasDivision masDivision = new MasDivision();
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDivision.setIsActive(true);
		masDivision.setCode("ITS");
		masDivision.setName("Integrate Technology Services");
		masDivisionService.create(masDivision);

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
		employeeService.create(employee);

		// create card
		card = new Card();
		card.setAuditFlag("C");
		card.setCreatedBy(1);
		card.setCreatedTimeStamp(Calendar.getInstance().getTime());
		card.setCard_no("CC0001");
		card.setStartdate(new Date());
		card.setStatus("Test");
		card.setEmployee(employee);
		cardService.create(card);

	}

	@Test
	public void testLoadServicesShouldPass() throws Exception {
		assertNotNull(cardService);
		assertNotNull(masCoreSkillService);
		assertNotNull(masJobLevelService);
		assertNotNull(masDivisionService);
		assertNotNull(masTechnologyService);
		assertNotNull(employeeService);
		assertNotNull(applicantService);

	}

	@Test
	public void testFindWithCardServiceShouldReturnCardThatSetup() throws Exception {
		Card result = cardService.findById(card.getId());
		assertNotNull(result);
		assertThat(result.getCard_no(), is("CC0001"));

	}

	@Test
	public void testFindAllWithCardServiceShouldReturnListOfAllCard() throws Exception {
		List<Card> result = cardService.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithCardServiceShouldReturnCardThatUpdate() throws Exception {
		Card update = cardService.findById(card.getId());
		assertThat(update.getCard_no(), is("CC0001"));
		update.setCard_no("CC9999");
		cardService.update(update);

		Card result = cardService.findById(update.getId());
		assertThat(result.getCard_no(), is("CC9999"));

	}

	@Test
	public void testDeleteWithCardServiceShouldNotFindThatCard() throws Exception {
		Card delete = cardService.findById(card.getId());
		cardService.delete(delete);

		Card result = cardService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithCardServiceShouldNotFindThatCard() throws Exception {
		Card delete = cardService.findById(card.getId());
		cardService.deleteById(delete.getId());

		Card result = cardService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindByCriteriaWithCardServiceShouldReturnListOfCardThatHaveCardNumberSameSetup() throws Exception {
		List<Card> result = cardService.findByCriteria(card);
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testSearchCardWithCardServiceShouldReturnListOfCardThatHaveEmployeeIdSameSetup() throws Exception {
		List<CardDto> result = cardService.searchCard(card.getEmployee().getId());
		assertNotNull(result);
		assertThat(result.get(0).getCard_no(), is("CC0001"));

	}

}
