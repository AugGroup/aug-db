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

import com.aug.hrdb.entities.MasReservationType;
import com.aug.hrdb.services.MasReservationTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasReservationTypeServiceTest {
	
	@Autowired
	private MasReservationTypeService masReservationTypeService;
	
	private MasReservationType masReservationType;
	
	@Before
	public void setUp() throws Exception {
		
		masReservationType = new MasReservationType();
		masReservationType.setName("test");
		masReservationType.setCode("01");
		masReservationType.setIsactive(true);
		masReservationType.setAuditFlag("C");
		masReservationType.setCreatedBy(1);
		masReservationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasReservationTypeServiceShouldPass() throws Exception {
		assertNotNull(masReservationTypeService);
	}
	
	@Test
	public void testCreateWithMasReservationTypeServiceShouldPass() throws Exception {
		
		masReservationType.setName("test create");
		masReservationTypeService.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType result = masReservationTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasReservationTypeServiceShouldPass() throws Exception {
		
		masReservationType.setName("test findById");
		masReservationTypeService.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType result = masReservationTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasReservationTypeServiceShouldPass() throws Exception {
		
		List<MasReservationType> masReservationTypes = masReservationTypeService.findAll();
		
		masReservationTypeService.create(masReservationType);
		
		List<MasReservationType> result = masReservationTypeService.findAll();
		
		assertThat(result.size(), is(masReservationTypes.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasReservationTypeServiceShouldPass() throws Exception {
		
		masReservationTypeService.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType update = masReservationTypeService.findById(insertedId);
		update.setName("test update");
		masReservationTypeService.update(update);
		
		MasReservationType result = masReservationTypeService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasReservationTypeServiceShouldPass() throws Exception {
		
		masReservationTypeService.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType delete = masReservationTypeService.findById(insertedId);
		masReservationTypeService.delete(delete);
		
		MasReservationType result = masReservationTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasReservationTypeServiceShouldPass() throws Exception {
		
		masReservationTypeService.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType delete = masReservationTypeService.findById(insertedId);
		masReservationTypeService.deleteById(delete.getId());
		
		MasReservationType result = masReservationTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}