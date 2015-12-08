/**
 *
 * @author natechanok
 * @date Sep 4, 2015
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

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.services.MasEmploymentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasEmploymentServiceTest {
	
	@Autowired
	private MasEmploymentService masEmploymentService;
	
	private MasEmployment masEmployment;
	
	@Before
	public void setUp() throws Exception {
		
		masEmployment = new MasEmployment();
		masEmployment.setName("test");
		masEmployment.setCode("B05");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasEmploymentServiceShouldPass() throws Exception {
		assertNotNull(masEmploymentService);
	}
	
	@Test
	public void testCreateWithMasEmploymentServiceShouldPass() throws Exception {
		
		masEmployment.setName("test create");
		masEmploymentService.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment result = masEmploymentService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasEmploymentServiceShouldPass() throws Exception {
		
		masEmployment.setName("test findByIdById");
		masEmploymentService.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment result = masEmploymentService.findById(insertedId);
		
		assertThat(result.getName(), is("test findByIdById"));
		
	}
	
	@Test
	public void testFindAllWithMasEmploymentServiceShouldPass() throws Exception {
		
		List<MasEmployment> masEmployments = masEmploymentService.findAll();
		
		masEmploymentService.create(masEmployment);
		
		List<MasEmployment> result = masEmploymentService.findAll();
		
		assertThat(result.size(), is(masEmployments.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasEmploymentServiceShouldPass() throws Exception {
		
		masEmployment.setName("test findByCriteria");
		masEmploymentService.create(masEmployment);
		
		List<MasEmployment> result = masEmploymentService.findByCriteria(masEmployment);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasEmploymentServiceShouldPass() throws Exception {
		
		masEmploymentService.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment update = masEmploymentService.findById(insertedId);
		update.setName("test update");
		masEmploymentService.update(update);
		
		MasEmployment result = masEmploymentService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasEmploymentServiceShouldPass() throws Exception {
		
		masEmploymentService.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment delete = masEmploymentService.findById(insertedId);
		masEmploymentService.delete(delete);
		
		MasEmployment result = masEmploymentService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasEmploymentServiceShouldPass() throws Exception {
		
		masEmploymentService.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment delete = masEmploymentService.findById(insertedId);
		masEmploymentService.deleteById(delete.getId());
		
		MasEmployment result = masEmploymentService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}