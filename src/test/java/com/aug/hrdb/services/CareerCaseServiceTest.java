package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.CareerCase;
import com.aug.hrdb.entities.Client;
import com.aug.hrdb.entities.MasCareerCaseStatus;
import com.aug.hrdb.entities.MasCoreSkill;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class CareerCaseServiceTest {

	@Autowired
	private CareerCaseService careerCaseService;
	
	@Autowired
	private MasCareerCaseStatusService masCareerCaseStatusService;
	
	@Autowired
	private MasCoreSkillService masCoreSkillService;
	
	@Autowired 
	private MasDivisionService masDivisionService;
	
	@Autowired
	private MasJobLevelService masJobLevelService;
	
	@Autowired
	private MasTechnologyService masTechnologyService;
	
	@Autowired
	private ClientService clientService;
	
	private CareerCase careerCase;
	
	@Before
	public void setUp() throws Exception {
		
		MasCareerCaseStatus masCareerCaseStatus = new MasCareerCaseStatus();
		masCareerCaseStatus = new MasCareerCaseStatus();
		masCareerCaseStatus.setName("test career status");
		masCareerCaseStatus.setAuditFlag("C");
		masCareerCaseStatus.setCreatedBy(0);
		masCareerCaseStatus.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masCareerCaseStatusService.create(masCareerCaseStatus);
		
		MasCoreSkill masCoreSkill = new MasCoreSkill();
		masCoreSkill = new MasCoreSkill();
		masCoreSkill.setName("test core skill");
		masCoreSkill.setAuditFlag("C");
		masCoreSkill.setCreatedBy(0);
		masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masCoreSkillService.create(masCoreSkill);
		
		MasDivision masDivision = new MasDivision();
		masDivision = new MasDivision();
		masDivision.setName("TEST");
		masDivision.setCode("TEST");
		masDivision.setIsActive(true);
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(0);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDivisionService.create(masDivision);
		
		MasJobLevel masJobLevel = new MasJobLevel();
		masJobLevel = new MasJobLevel();
		masJobLevel.setName("test joblevel");
		masJobLevel.setCode("004A");
		masJobLevel.setIsActive(true);
		masJobLevel.setAuditFlag("C");
		masJobLevel.setCreatedBy(0);
		masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJobLevelService.create(masJobLevel);
		
		MasTechnology masTechnology = new MasTechnology();
		masTechnology = new MasTechnology();
		masTechnology.setName("test technology");
		masTechnology.setCode("004A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masTechnologyService.create(masTechnology);
		
		Client client = new Client();
		client.setAuditFlag("C");
		client.setCreatedBy(0);
		client.setCreatedTimeStamp(Calendar.getInstance().getTime());
		client.setName("test client");
		clientService.create(client);
		
		careerCase = new CareerCase();
		careerCase.setCareerCaseStatus(masCareerCaseStatus);
		careerCase.setMasCoreSkill(masCoreSkill);
		careerCase.setMasDivision(masDivision);
		careerCase.setMasJobLevel(masJobLevel);
		careerCase.setMasTechnology(masTechnology);
		careerCase.setClient(client);
		careerCase.setDateRequest(Calendar.getInstance().getTime());
		careerCase.setCode("TEST0001");
		careerCase.setAuditFlag("C");
		careerCase.setCreatedBy(0);
		careerCase.setCreatedTimeStamp(Calendar.getInstance().getTime());
				
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadCareerCaseServiceShouldPass() throws Exception {
		assertNotNull(careerCaseService);
	}
	
	@Test
	public void testCreateWithCareerCaseStatusServiceShouldPass() throws Exception {
		
		careerCaseService.create(careerCase);
		Integer insertedId = careerCase.getId();
		
		CareerCase result = careerCaseService.findById(insertedId);
		
		assertThat(result.getCode(), is("TEST0001"));
		
		System.out.println(result.getMasDivision().getCode());
		
	}
	
	@Test
	public void testFindByIdWithCareerCaseServiceShouldPass() throws Exception {
		
		careerCase.setCode("TESTCODE");
		careerCaseService.create(careerCase);
		Integer insertedId = careerCase.getId();
		
		CareerCase result = careerCaseService.findById(insertedId);
		
		assertThat(result.getCode(), is("TESTCODE"));
		
	}
	
	@Test
	public void testFindAllWithCareerCaseServiceShouldPass() throws Exception {
		
		List<CareerCase> careerCases = careerCaseService.findAll();
		
		careerCaseService.create(careerCase);
		
		List<CareerCase> result = careerCaseService.findAll();
		
		assertThat(result.size(), is(careerCases.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithCareerCaseServiceShouldPass() throws Exception {
		
		careerCaseService.create(careerCase);
		Integer insertedId = careerCase.getId();
		
		CareerCase update = careerCaseService.findById(insertedId);
		update.setCode("TEST0002");
		careerCaseService.update(update);
		
		CareerCase result = careerCaseService.findById(update.getId());
		
		assertThat(result.getCode(), is("TEST0002"));
		
	}
	
	@Test
	public void testDeleteWithCareerCaseServiceShouldPass() throws Exception {
		
		careerCaseService.create(careerCase);
		Integer insertedId = careerCase.getId();
		
		CareerCase delete = careerCaseService.findById(insertedId);
		careerCaseService.delete(delete);
		
		CareerCase result = careerCaseService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithCareerCaseServiceShouldPass() throws Exception {
		
		careerCaseService.create(careerCase);
		Integer insertedId = careerCase.getId();
		
		CareerCase delete = careerCaseService.findById(insertedId);
		careerCaseService.deleteById(delete.getId());
		
		CareerCase result = careerCaseService.findById(delete.getId());
		
		assertNull(result);
		
	}

}
