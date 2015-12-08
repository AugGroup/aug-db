/**
 *
 * @author Pranrajit
 * @date 14 ก.ย. 2558
 */
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

import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.services.MasLeaveTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasLeaveTypeServiceTest {
	
	@Autowired 
	private MasLeaveTypeService masLeaveTypeService;
	
	private MasLeaveType masLeaveType;
	
	@Before
	public void setUp() throws Exception {
		
		masLeaveType = new MasLeaveType();
		masLeaveType.setName("test");
		masLeaveType.setCode("MD-01");
		masLeaveType.setIsactive(true);
		masLeaveType.setAuditFlag("C");
		masLeaveType.setCreatedBy(1);
		masLeaveType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasLeaveTypeServiceShouldPass() throws Exception {
		assertNotNull(masLeaveTypeService);
	}
	
	@Test
	public void testCreateWithMasLeaveTypeServiceShouldPass() throws Exception {
		
		masLeaveType.setName("test create");
		masLeaveTypeService.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType result = masLeaveTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasLeaveTypeServiceShouldPass() throws Exception {
		
		masLeaveType.setName("test findByIdById");
		masLeaveTypeService.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType result = masLeaveTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test findByIdById"));
		
	}
	
	@Test
	public void testFindAllWithMasLeaveTypeServiceShouldPass() throws Exception {
		
		List<MasLeaveType> masLeaveTypes = masLeaveTypeService.findAll();
		
		masLeaveTypeService.create(masLeaveType);
		
		List<MasLeaveType> result = masLeaveTypeService.findAll();
		
		assertThat(result.size(), is(masLeaveTypes.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasLeaveTypeServiceShouldPass() throws Exception {
		
		masLeaveType.setName("test findByCriteria");
		masLeaveTypeService.create(masLeaveType);
		
		List<MasLeaveType> result = masLeaveTypeService.findByCriteria(masLeaveType);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasLeaveTypeServiceShouldPass() throws Exception {
		
		masLeaveTypeService.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType update = masLeaveTypeService.findById(insertedId);
		update.setName("test update");
		masLeaveTypeService.update(update);
		
		MasLeaveType result = masLeaveTypeService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasLeaveTypeServiceShouldPass() throws Exception {
		
		masLeaveTypeService.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType delete = masLeaveTypeService.findById(insertedId);
		masLeaveTypeService.delete(delete);
		
		MasLeaveType result = masLeaveTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasLeaveTypeServiceShouldPass() throws Exception {
		
		masLeaveTypeService.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType delete = masLeaveTypeService.findById(insertedId);
		masLeaveTypeService.deleteById(delete.getId());
		
		MasLeaveType result = masLeaveTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}