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

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.services.MasAddressTypeService;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasAddressTypeServiceTest {
	
	@Autowired
	private MasAddressTypeService masAddressTypeService;
	
	MasAddressType masAddressType;
	
	@Before
	public void setUp() throws Exception {
		
		masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsActive(true);
		masAddressType.setAuditFlag("C");
		masAddressType.setCreatedBy(1);
		masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasAddressTypeServiceShouldPass() throws Exception {
		assertNotNull(masAddressTypeService);
	}
	
	@Test
	public void testCreateWithMasAddressTypeServiceShouldPass() throws Exception {
	
		masAddressType.setName("test create");
		masAddressTypeService.create(masAddressType);
		Integer insertedId = masAddressType.getId();
		
		MasAddressType result = masAddressTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasAddressTypeServiceShouldPass() throws Exception {
		
		masAddressType.setName("find by id");
		masAddressTypeService.create(masAddressType);
		Integer insertedId = masAddressType.getId();
		
		MasAddressType result = masAddressTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("find by id"));
		
	}
	
	@Test
	public void testFindAllWithMasAddressTypeServiceShouldPass() throws Exception {
		
		List<MasAddressType> findAll = masAddressTypeService.findAll();
		
		masAddressTypeService.create(masAddressType);
		
		List<MasAddressType> result = masAddressTypeService.findAll();
		
		assertThat(result.size(), is(findAll.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasAddressTypeServiceShouldPass() throws Exception {
		
		masAddressType.setName("find criteria");
		masAddressTypeService.create(masAddressType);
		
		List<MasAddressType> result = masAddressTypeService.findByCriteria(masAddressType);

		assertThat(result.size(), is(1));
	}
	
	@Test
	public void testUpdateWithMasAddressTypeServiceShouldPass() throws Exception {
		
		masAddressTypeService.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		MasAddressType update = masAddressTypeService.findById(insertId);
		update.setName("update address");
		masAddressTypeService.create(update);
		
		MasAddressType result = masAddressTypeService.findById(update.getId());
		
		assertThat(result.getName(), is("update address"));
		
	}
	
	@Test
	public void testDeleteWithMasAddressTypeServiceShouldPass() throws Exception {
		
		masAddressTypeService.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		masAddressTypeService.delete(masAddressType);
		
		MasAddressType result = masAddressTypeService.findById(insertId);

		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasAddressTypeServiceShouldPass() throws Exception {
		
		masAddressTypeService.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		masAddressTypeService.deleteById(insertId);
		
		MasAddressType result = masAddressTypeService.findById(insertId);

		assertNull(result);
		
	}

}


















