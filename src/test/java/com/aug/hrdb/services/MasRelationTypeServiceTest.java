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

import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.services.MasRelationTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasRelationTypeServiceTest {

	@Autowired
	private MasRelationTypeService masRelationTypeService;
	
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
	public void testLoadMasRelationTypeServiceShouldPass() throws Exception {
		assertNotNull(masRelationTypeService);
	}
	
	@Test
	public void testCreateWithMasRelationTypeServiceShouldPass() throws Exception {
		
		masRelationType.setName("test create");
		masRelationTypeService.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType result = masRelationTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasRelationTypeServiceShouldPass() throws Exception {
		
		masRelationType.setName("test findById");
		masRelationTypeService.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType result = masRelationTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasRelationTypeServiceShouldPass() throws Exception {
		
		List<MasRelationType> masRelationTypes = masRelationTypeService.findAll();
		
		masRelationTypeService.create(masRelationType);
		
		List<MasRelationType> result = masRelationTypeService.findAll();
		
		assertThat(result.size(), is(masRelationTypes.size() + 1));
		
	}
	
	@Test
	public void testFindByNameWithMasRelationTypeServiceShouldPass() throws Exception {
		
		masRelationType.setRelationType("test findByName");
		masRelationTypeService.create(masRelationType);
		
		MasRelationType result = masRelationTypeService.findByName(masRelationType.getRelationType());
		
		assertThat(result.getRelationType(), is("test findByName"));
		
	}
	
	@Test
	public void testUpdateWithMasRelationTypeServiceShouldPass() throws Exception {
		
		masRelationTypeService.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType update = masRelationTypeService.findById(insertedId);
		update.setName("test update");
		masRelationTypeService.update(update);
		
		MasRelationType result = masRelationTypeService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasRelationTypeServiceShouldPass() throws Exception {
		
		masRelationTypeService.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType delete = masRelationTypeService.findById(insertedId);
		masRelationTypeService.delete(delete);
		
		MasRelationType result = masRelationTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasRelationTypeServiceShouldPass() throws Exception {
		
		masRelationTypeService.create(masRelationType);
		Integer insertedId = masRelationType.getId();
		
		MasRelationType delete = masRelationTypeService.findById(insertedId);
		masRelationTypeService.deleteById(delete.getId());
		
		MasRelationType result = masRelationTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}