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

import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.MasRelationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasRelationTypeRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasRelationTypeRepository masRelationTypeRepository;

	private MasRelationType masRelationType;
	
	@Before
	public void setUp() throws Exception {
		
		masRelationType = new MasRelationType();
		masRelationType.setRelationType("test");
		masRelationType.setAuditFlag("C");
		masRelationType.setCode("REL-03");
		masRelationType.setCreatedBy(1);
		masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRelationType.setIsActive(true);
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasRelationTypeShouldPass() throws Exception {
		assertNotNull(masRelationTypeRepository);
	}
	
	@Test
	public void testCreateWithMasRelationTypeRepositoryShouldPass() throws Exception {
		
		masRelationType.setName("test create");
		masRelationTypeRepository.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType result = masRelationTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasRelationTypeRepositoryShouldPass() throws Exception {
		
		masRelationType.setName("test findById");
		masRelationTypeRepository.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType result = masRelationTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasRelationTypeRepositoryShouldPass() throws Exception {
		
		List<MasRelationType> masRelationTypes = masRelationTypeRepository.findAll();
		
		masRelationTypeRepository.create(masRelationType);
		
		List<MasRelationType> result = masRelationTypeRepository.findAll();
		
		assertThat(result.size(), is(masRelationTypes.size() + 1));
		
	}
	
	@Test
	public void testFindByNameWithMasRelationTypeRepositoryShouldPass() throws Exception {
		
		masRelationType.setRelationType("test findByName");
		masRelationTypeRepository.create(masRelationType);
		
		MasRelationType result = masRelationTypeRepository.findByName(masRelationType.getRelationType());
		
		assertThat(result.getRelationType(), is("test findByName"));
		
	}
	
	@Test
	public void testUpdateWithMasRelationTypeRepositoryShouldPass() throws Exception {
		
		masRelationTypeRepository.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType update = masRelationTypeRepository.find(insertedId);
		update.setName("test update");
		masRelationTypeRepository.update(update);
		
		MasRelationType result = masRelationTypeRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasRelationTypeRepositoryShouldPass() throws Exception {
		
		masRelationTypeRepository.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType delete = masRelationTypeRepository.find(insertedId);
		masRelationTypeRepository.delete(delete);
		
		MasRelationType result = masRelationTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasRelationTypeRepositoryShouldPass() throws Exception {
		
		masRelationTypeRepository.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType delete = masRelationTypeRepository.find(insertedId);
		masRelationTypeRepository.deleteById(delete.getId());
		
		MasRelationType result = masRelationTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}