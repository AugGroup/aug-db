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

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.services.MasTechnologyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasTechnologyServiceTest {
	
	@Autowired
	private MasTechnologyService masTechnologyService;
	
	private MasTechnology masTechnology;
	
	@Before
	public void setUp() throws Exception {
		
		masTechnology = new MasTechnology();
		masTechnology.setName("test");
		masTechnology.setCode("004A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasTechnologyServiceShouldPass() throws Exception {
		assertNotNull(masTechnologyService);
	}
	
	@Test
	public void testCreateWithMasTechnologyServiceShouldPass() throws Exception {
		
		masTechnology.setName("test create");
		masTechnologyService.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology result = masTechnologyService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasTechnologyServiceShouldPass() throws Exception {
		
		masTechnology.setName("test findById");
		masTechnologyService.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology result = masTechnologyService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasTechnologyServiceShouldPass() throws Exception {
		
		List<MasTechnology> masTechnologys = masTechnologyService.findAll();
		
		masTechnologyService.create(masTechnology);
		
		List<MasTechnology> result = masTechnologyService.findAll();
		
		assertThat(result.size(), is(masTechnologys.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasTechnologyServiceShouldPass() throws Exception {
		
		masTechnologyService.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology update = masTechnologyService.findById(insertedId);
		update.setName("test update");
		masTechnologyService.update(update);
		
		MasTechnology result = masTechnologyService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasTechnologyServiceShouldPass() throws Exception {
		
		masTechnologyService.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology delete = masTechnologyService.findById(insertedId);
		masTechnologyService.delete(delete);
		
		MasTechnology result = masTechnologyService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasTechnologyServiceShouldPass() throws Exception {
		
		masTechnologyService.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology delete = masTechnologyService.findById(insertedId);
		masTechnologyService.deleteById(delete.getId());
		
		MasTechnology result = masTechnologyService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}