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

import com.aug.hrdb.entities.MasCareerCaseStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
public class MasCareerCaseStatusServiceTest {

	@Autowired
	private MasCareerCaseStatusService masCareerCaseStatusService; 
	
	private MasCareerCaseStatus masCareerCaseStatus;
	
	@Before
	public void setUp() throws Exception {
		
		masCareerCaseStatus = new MasCareerCaseStatus();
		masCareerCaseStatus.setName("test");
		masCareerCaseStatus.setAuditFlag("C");
		masCareerCaseStatus.setCreatedBy(0);
		masCareerCaseStatus.setCreatedTimeStamp(Calendar.getInstance().getTime());
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasCereerCaseStatusServiceShouldPass() throws Exception {
		assertNotNull(masCareerCaseStatusService);
	}
	
	@Test
	public void testCreateWithMasCareerCaseStatusServiceShouldPass() throws Exception {
		
		masCareerCaseStatus.setName("test create");
		masCareerCaseStatusService.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus result = masCareerCaseStatusService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
	}
	
	@Test
	public void testFindByIdWithMasCareerCaseStatusServiceShouldPass() throws Exception {
		
		masCareerCaseStatus.setName("test findById");
		masCareerCaseStatusService.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus result = masCareerCaseStatusService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
	}
	
	@Test
	public void testFindAllWithMasCareerCaseStatusServiceShouldPass() throws Exception {
		
		List<MasCareerCaseStatus> masCareerCaseStatuses = masCareerCaseStatusService.findAll();
		
		masCareerCaseStatusService.create(masCareerCaseStatus);
		
		List<MasCareerCaseStatus> result = masCareerCaseStatusService.findAll();
		
		assertThat(result.size(), is(masCareerCaseStatuses.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasCareerCaseStatusServiceShouldPass() throws Exception {
		
		masCareerCaseStatusService.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus update = masCareerCaseStatusService.findById(insertedId);
		update.setName("test update");
		masCareerCaseStatusService.update(update);
		
		MasCareerCaseStatus result = masCareerCaseStatusService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasCareerCaseStatusServiceShouldPass() throws Exception {
		
		masCareerCaseStatusService.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus delete = masCareerCaseStatusService.findById(insertedId);
		masCareerCaseStatusService.delete(delete);
		
		MasCareerCaseStatus result = masCareerCaseStatusService.findById(delete.getId());
		
		assertNull(result);
	}
	
	@Test
	public void testDeleteByIdWithMasCareerCaseStatusServiceShouldPass() throws Exception {
		
		masCareerCaseStatusService.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus delete = masCareerCaseStatusService.findById(insertedId);
		masCareerCaseStatusService.deleteById(delete.getId());
		
		MasCareerCaseStatus result = masCareerCaseStatusService.findById(delete.getId());
		
		assertNull(result);
	}
}