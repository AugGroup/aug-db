package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasCoreSkill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasCoreSkillRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasCoreSkillRepository masCoreSkillRepository;
	
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
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasCoreskillRepositoryShouldPass() throws Exception {
		assertNotNull(masCoreSkillRepository);
	}
	
	@Test
	public void testCreateWithMasCoreSkillRepositoryShouldPass() throws Exception {
		
		masCoreSkill.setName("test create");
		masCoreSkillRepository.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill result = masCoreSkillRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasCoreSkillRepositoryShouldPass() throws Exception {
		
		masCoreSkill.setName("test findById");
		masCoreSkillRepository.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill result = masCoreSkillRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasCoreSkillRepositoryShouldPass() throws Exception {
		
		List<MasCoreSkill> masCoreSkills = masCoreSkillRepository.findAll();
		
		masCoreSkillRepository.create(masCoreSkill);
		
		List<MasCoreSkill> result = masCoreSkillRepository.findAll();
		
		assertThat(result.size(), is(masCoreSkills.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasCoreSkillRepositoryShouldPass() throws Exception {
		
		masCoreSkill.setName("test findByCriteria");
		masCoreSkillRepository.create(masCoreSkill);
		
		List<MasCoreSkill> result = masCoreSkillRepository.findByCriteria(masCoreSkill);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasCoreSkillRepositoryShouldPass() throws Exception {
		
		masCoreSkillRepository.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill update = masCoreSkillRepository.find(insertedId);
		update.setName("test update");
		masCoreSkillRepository.update(update);
		
		MasCoreSkill result = masCoreSkillRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasCoreSkillRepositoryShouldPass() throws Exception {
		
		masCoreSkillRepository.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill delete = masCoreSkillRepository.find(insertedId);
		masCoreSkillRepository.delete(delete);
		
		MasCoreSkill result = masCoreSkillRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasCoreSkillRepositoryShouldPass() throws Exception {
		
		masCoreSkillRepository.create(masCoreSkill);
		Integer insertedId = masCoreSkill.getId();
		
		MasCoreSkill delete = masCoreSkillRepository.find(insertedId);
		masCoreSkillRepository.deleteById(delete.getId());
		
		MasCoreSkill result = masCoreSkillRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}


























