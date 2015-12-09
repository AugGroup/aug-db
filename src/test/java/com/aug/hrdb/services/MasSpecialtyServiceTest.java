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

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.services.MasSpecialtyService;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasSpecialtyServiceTest {

	@Autowired
	private MasSpecialtyService masSpecialtyService;
	
	private MasSpecialty masSpecialty;

	@Before
	public void setUp() throws Exception {
		
		masSpecialty = new MasSpecialty();
		masSpecialty.setName("test");
		masSpecialty.setCode("01");
		masSpecialty.setIsActive(true);
		masSpecialty.setAuditFlag("C");
		masSpecialty.setCreatedBy(1);	
		masSpecialty.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasSpecialtyServiceShouldPass() throws Exception {
		assertNotNull(masSpecialtyService);
	}
	
	@Test
	public void testCreateWithMasSpecialtyServiceShouldPass() throws Exception {
		
		masSpecialty.setName("test create");
		masSpecialtyService.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty result = masSpecialtyService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasSpecialtyServiceShouldPass() throws Exception {
		
		masSpecialty.setName("test findByIdById");
		masSpecialtyService.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty result = masSpecialtyService.findById(insertedId);
		
		assertThat(result.getName(), is("test findByIdById"));
		
	}
	
	@Test
	public void testFindAllWithMasSpecialtyServiceShouldPass() throws Exception {
		
		List<MasSpecialty> masSpecialtys = masSpecialtyService.findAll();
		
		masSpecialtyService.create(masSpecialty);
		
		List<MasSpecialty> result = masSpecialtyService.findAll();
		
		assertThat(result.size(), is(masSpecialtys.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasSpecialtyServiceShouldPass() throws Exception {
		
		masSpecialty.setName("test findByCriteria");
		masSpecialtyService.create(masSpecialty);
		
		List<MasSpecialty> result = masSpecialtyService.findByCriteria(masSpecialty);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasSpecialtyServiceShouldPass() throws Exception {
		
		masSpecialtyService.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty update = masSpecialtyService.findById(insertedId);
		update.setName("test update");
		masSpecialtyService.update(update);
		
		MasSpecialty result = masSpecialtyService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasSpecialtyServiceShouldPass() throws Exception {
		
		masSpecialtyService.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty delete = masSpecialtyService.findById(insertedId);
		masSpecialtyService.delete(delete);
		
		MasSpecialty result = masSpecialtyService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasSpecialtyServiceShouldPass() throws Exception {
		
		masSpecialtyService.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty delete = masSpecialtyService.findById(insertedId);
		masSpecialtyService.deleteById(delete.getId());
		
		MasSpecialty result = masSpecialtyService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}