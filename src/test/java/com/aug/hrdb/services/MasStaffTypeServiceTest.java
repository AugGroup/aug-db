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

import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.services.MasStaffTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasStaffTypeServiceTest {
	
	@Autowired 
	private MasStaffTypeService masStaffTypeService;
	
	private MasStaffType masStaffType;

	@Before
	public void setUp() throws Exception {
		
		masStaffType = new MasStaffType();
		masStaffType.setName("test");
		masStaffType.setAuditFlag("C");
		masStaffType.setCode("STAFF-02");
		masStaffType.setCreatedBy(1);
		masStaffType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masStaffType.setIsActive(true);
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasStaffTypeServiceShouldPass() throws Exception {
		assertNotNull(masStaffTypeService);
	}
	
	@Test
	public void testCreateWithMasStaffTypeServiceShouldPass() throws Exception {
		
		masStaffType.setName("test create");
		masStaffTypeService.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType result = masStaffTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasStaffTypeServiceShouldPass() throws Exception {
		
		masStaffType.setName("test findById");
		masStaffTypeService.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType result = masStaffTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasStaffTypeServiceShouldPass() throws Exception {
		
		List<MasStaffType> masStaffTypes = masStaffTypeService.findAll();
		
		masStaffTypeService.create(masStaffType);
		
		List<MasStaffType> result = masStaffTypeService.findAll();
		
		assertThat(result.size(), is(masStaffTypes.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasStaffTypeServiceShouldPass() throws Exception {
		
		masStaffTypeService.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType update = masStaffTypeService.findById(insertedId);
		update.setName("test update");
		masStaffTypeService.update(update);
		
		MasStaffType result = masStaffTypeService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasStaffTypeServiceShouldPass() throws Exception {
		
		masStaffTypeService.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType delete = masStaffTypeService.findById(insertedId);
		masStaffTypeService.delete(delete);
		
		MasStaffType result = masStaffTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasStaffTypeServiceShouldPass() throws Exception {
		
		masStaffTypeService.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType delete = masStaffTypeService.findById(insertedId);
		masStaffTypeService.deleteById(delete.getId());
		
		MasStaffType result = masStaffTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}