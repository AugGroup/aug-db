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

import com.aug.hrdb.entities.MasDegreeType;
import com.aug.hrdb.services.MasDegreeTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasDegreeTypeServiceTest {

	@Autowired 
	private MasDegreeTypeService masDegreeTypeService;
	
	private MasDegreeType masDegreeType;
	
	@Before
	public void setUp() throws Exception {
		
		masDegreeType = new MasDegreeType();
		masDegreeType.setName("test");
		masDegreeType.setCode("DE-02");
		masDegreeType.setIsactive(true);
		masDegreeType.setAuditFlag("C");
		masDegreeType.setCreatedBy(1);
		masDegreeType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasDegreeTypeServiceShouldPass() throws Exception {
		assertNotNull(masDegreeTypeService);
	}
	
	@Test
	public void testCreateWithMasDegreeTypeServiceShouldPass() throws Exception {
		
		masDegreeType.setName("test create");
		masDegreeTypeService.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType result = masDegreeTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testfindByIdByIdWithMasDegreeTypeServiceShouldPass() throws Exception {
		
		masDegreeType.setName("test findByIdById");
		masDegreeTypeService.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType result = masDegreeTypeService.findById(insertedId);
		
		assertThat(result.getName(), is("test findByIdById"));
		
	}
	
	@Test
	public void testfindAllWithMasDegreeTypeServiceShouldPass() throws Exception {
		
		List<MasDegreeType> masDegreeTypes = masDegreeTypeService.findAll();
		
		masDegreeTypeService.create(masDegreeType);
		
		List<MasDegreeType> result = masDegreeTypeService.findAll();
		
		assertThat(result.size(), is(masDegreeTypes.size() + 1));
		
	}
	
	@Test
	public void testfindByCriteriaWithMasDegreeTypeServiceShouldPass() throws Exception {
		
		masDegreeType.setName("test findByCriteria");
		masDegreeTypeService.create(masDegreeType);
		
		List<MasDegreeType> result = masDegreeTypeService.findByCriteria(masDegreeType);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasDegreeTypeServiceShouldPass() throws Exception {
		
		masDegreeTypeService.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType update = masDegreeTypeService.findById(insertedId);
		update.setName("test update");
		masDegreeTypeService.update(update);
		
		MasDegreeType result = masDegreeTypeService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasDegreeTypeServiceShouldPass() throws Exception {
		
		masDegreeTypeService.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType delete = masDegreeTypeService.findById(insertedId);
		masDegreeTypeService.delete(delete);
		
		MasDegreeType result = masDegreeTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasDegreeTypeServiceShouldPass() throws Exception {
		
		masDegreeTypeService.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType delete = masDegreeTypeService.findById(insertedId);
		masDegreeTypeService.deleteById(delete.getId());
		
		MasDegreeType result = masDegreeTypeService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}