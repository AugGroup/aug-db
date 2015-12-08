/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
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

import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.services.MasDivisionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasDivisionServiceTest {

	@Autowired
	private MasDivisionService masDivisionService;
	
	private MasDivision masDivision;
	
	@Before
	public void setUp() throws Exception {
		
		masDivision = new MasDivision();
		masDivision.setName("test");
		masDivision.setIsActive(true);
		masDivision.setCode("01");
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasDivisionServiceShouldPass() throws Exception {
		assertNotNull(masDivisionService);
	}
	
	@Test
	public void testCreateWithMasDivisionServiceShouldPass() throws Exception {
		
		masDivision.setName("test create");
		masDivisionService.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision result = masDivisionService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testfindByIdByIdWithMasDivisionServiceShouldPass() throws Exception {
		
		masDivision.setName("test findByIdById");
		masDivisionService.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision result = masDivisionService.findById(insertedId);
		
		assertThat(result.getName(), is("test findByIdById"));
		
	}
	
	@Test
	public void testfindAllWithMasDivisionServiceShouldPass() throws Exception {
		
		List<MasDivision> masDivisions = masDivisionService.findAll();
		
		masDivisionService.create(masDivision);
		
		List<MasDivision> result = masDivisionService.findAll();
		
		assertThat(result.size(), is(masDivisions.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasDivisionServiceShouldPass() throws Exception {
		
		masDivisionService.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision update = masDivisionService.findById(insertedId);
		update.setName("test update");
		masDivisionService.update(update);
		
		MasDivision result = masDivisionService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasDivisionServiceShouldPass() throws Exception {
		
		masDivisionService.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision delete = masDivisionService.findById(insertedId);
		masDivisionService.delete(delete);
		
		MasDivision result = masDivisionService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasDivisionServiceShouldPass() throws Exception {
		
		masDivisionService.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision delete = masDivisionService.findById(insertedId);
		masDivisionService.deleteById(delete.getId());
		
		MasDivision result = masDivisionService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}