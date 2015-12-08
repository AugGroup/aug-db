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

import com.aug.hrdb.entities.MasCoreSkill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
public class MasCoreSkillServiceTest {

	@Autowired
	private MasCoreSkillService masCoreSkillService;
	
	private MasCoreSkill masCoreSkill;
	
	@Before
	public void setUp() throws Exception {
		
		masCoreSkill = new MasCoreSkill();
		masCoreSkill.setName("test");
		masCoreSkill.setAuditFlag("C");
		masCoreSkill.setCreatedBy(0);
		masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasCoreSkillServiceShouldPass() throws Exception {
		assertNotNull(masCoreSkillService);
	}
	
	@Test
	public void testCreateWithmasCoreSkillServiceShouldPass() throws Exception {
		
		masCoreSkill.setName("test create");
		masCoreSkillService.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill result = masCoreSkillService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testfindByIdByIdWithmasCoreSkillServiceShouldPass() throws Exception {
		
		masCoreSkill.setName("test findByIdById");
		masCoreSkillService.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill result = masCoreSkillService.findById(insertedId);
		
		assertThat(result.getName(), is("test findByIdById"));
		
	}
	
	@Test
	public void testfindAllWithmasCoreSkillServiceShouldPass() throws Exception {
		
		List<MasCoreSkill> masCoreSkills = masCoreSkillService.findAll();
		
		masCoreSkillService.create(masCoreSkill);
		
		List<MasCoreSkill> result = masCoreSkillService.findAll();
		
		assertThat(result.size(), is(masCoreSkills.size() + 1));
		
	}
	
	@Test
	public void testfindByIdByCriteriaWithmasCoreSkillServiceShouldPass() throws Exception {
		
		masCoreSkill.setName("test findByIdByCriteria");
		masCoreSkillService.create(masCoreSkill);
		
		List<MasCoreSkill> result = masCoreSkillService.findByCriteria(masCoreSkill);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithmasCoreSkillServiceShouldPass() throws Exception {
		
		masCoreSkillService.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill update = masCoreSkillService.findById(insertedId);
		update.setName("test update");
		masCoreSkillService.update(update);
		
		MasCoreSkill result = masCoreSkillService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithmasCoreSkillServiceShouldPass() throws Exception {
		
		masCoreSkillService.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill delete = masCoreSkillService.findById(insertedId);
		masCoreSkillService.delete(delete);
		
		MasCoreSkill result = masCoreSkillService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithmasCoreSkillServiceShouldPass() throws Exception {
		
		masCoreSkillService.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill delete = masCoreSkillService.findById(insertedId);
		masCoreSkillService.deleteById(delete.getId());
		
		MasCoreSkill result = masCoreSkillService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}
