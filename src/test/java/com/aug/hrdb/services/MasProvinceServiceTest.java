/**
 *
 * @author natechanok
 * @date Sep 11, 2015
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

import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.services.MasProvinceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasProvinceServiceTest {
	
	@Autowired 
	private MasProvinceService masProvinceService;
	
	private MasProvince masProvince;
	
	@Before
	public void setUp() throws Exception {
		
		masProvince = new MasProvince();
		masProvince.setName("test");
		masProvince.setCode("PRO-01");
		masProvince.setIsActive(true);
		masProvince.setAuditFlag("C");
		masProvince.setCreatedBy(1);
		masProvince.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasProvinceServiceShouldPass() throws Exception {
		assertNotNull(masProvinceService);
	}
	
	@Test
	public void testCreateWithMasProvinceServiceShouldPass() throws Exception {
		
		masProvince.setName("test create");
		masProvinceService.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince result = masProvinceService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasProvinceServiceShouldPass() throws Exception {
		
		masProvince.setName("test findById");
		masProvinceService.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince result = masProvinceService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasProvinceServiceShouldPass() throws Exception {
		
		List<MasProvince> masProvinces = masProvinceService.findAll();
		
		masProvinceService.create(masProvince);
		
		List<MasProvince> result = masProvinceService.findAll();
		
		assertThat(result.size(), is(masProvinces.size() + 1));
		
	}
	
	@Test
	public void testFindByLocationCodeWithMasProvinceServiceShouldPass() throws Exception {
		
		masProvince.setCode("test findByCode");
		masProvinceService.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince result = masProvinceService.findById(insertedId);
		
		assertThat(result.getCode(), is("test findByCode"));
		
	}
	
	@Test
	public void testUpdateWithMasProvinceServiceShouldPass() throws Exception {
		
		masProvinceService.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince update = masProvinceService.findById(insertedId);
		update.setName("test update");
		masProvinceService.update(update);
		
		MasProvince result = masProvinceService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasProvinceServiceShouldPass() throws Exception {
		
		masProvinceService.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince delete = masProvinceService.findById(insertedId);
		masProvinceService.delete(delete);
		
		MasProvince result = masProvinceService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasProvinceServiceShouldPass() throws Exception {
		
		masProvinceService.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince delete = masProvinceService.findById(insertedId);
		masProvinceService.deleteById(delete.getId());
		
		MasProvince result = masProvinceService.findById(delete.getId());
		
		assertNull(result);
		
	}

}