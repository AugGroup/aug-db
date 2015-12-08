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

import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.services.MasLocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasLocationServiceTest {
	
	@Autowired 
	private MasLocationService masLocationService;
	
	private MasLocation masLocation;
	
	@Before
	public void setUp() throws Exception {
		
		masLocation = new MasLocation();
		masLocation.setName("test");
		masLocation.setCode("test01");
		masLocation.setIsActive(true);
		masLocation.setAuditFlag("C");
		masLocation.setCreatedBy(1);
		masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasLocationServiceShouldPass() throws Exception {
		assertNotNull(masLocationService);
	}
	
	@Test
	public void testCreateWithMasLocationServiceShouldPass() throws Exception {
		
		masLocation.setName("test create");
		masLocationService.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation result = masLocationService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasLocationServiceShouldPass() throws Exception {
		
		masLocation.setName("test findById");
		masLocationService.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation result = masLocationService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasLocationServiceShouldPass() throws Exception {
		
		List<MasLocation> masLocations = masLocationService.findAll();
		
		masLocationService.create(masLocation);
		
		List<MasLocation> result = masLocationService.findAll();
		
		assertThat(result.size(), is(masLocations.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasLocationServiceShouldPass() throws Exception {
		
		masLocation.setName("test findByCriteria");
		masLocationService.create(masLocation);
		
		List<MasLocation> result = masLocationService.findByCriteria(masLocation);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testFindByLocationCodeWithMasLocationServiceShouldPass() throws Exception {
		
		masLocation.setCode("test findByCode");
		masLocationService.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation result = masLocationService.findById(insertedId);
		
		assertThat(result.getCode(), is("test findByCode"));
		
	}
	
	@Test
	public void testUpdateWithMasLocationServiceShouldPass() throws Exception {
		
		masLocationService.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation update = masLocationService.findById(insertedId);
		update.setName("test update");
		masLocationService.update(update);
		
		MasLocation result = masLocationService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasLocationServiceShouldPass() throws Exception {
		
		masLocationService.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation delete = masLocationService.findById(insertedId);
		masLocationService.delete(delete);
		
		MasLocation result = masLocationService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasLocationServiceShouldPass() throws Exception {
		
		masLocationService.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation delete = masLocationService.findById(insertedId);
		masLocationService.deleteById(delete.getId());
		
		MasLocation result = masLocationService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}