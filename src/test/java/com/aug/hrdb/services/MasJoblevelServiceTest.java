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

import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.services.MasJobLevelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasJoblevelServiceTest {

	@Autowired
	private MasJobLevelService masJobLevelService;
	
	private MasJobLevel masJobLevel;
	
	@Before
	public void setUp() throws Exception {
		
		masJobLevel = new MasJobLevel();
		masJobLevel.setName("test");
		masJobLevel.setCode("004A");
		masJobLevel.setIsActive(true);
		masJobLevel.setAuditFlag("C");
		masJobLevel.setCreatedBy(0);
		masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasJobLevelServiceShouldPass() throws Exception {
		assertNotNull(masJobLevelService);
	}
	
	@Test
	public void testCreateWithMasJobLevelServiceShouldPass() throws Exception {
		
		masJobLevel.setName("test create");
		masJobLevelService.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel result = masJobLevelService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasJobLevelServiceShouldPass() throws Exception {
		
		masJobLevel.setName("test findByIdById");
		masJobLevelService.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel result = masJobLevelService.findById(insertedId);
		
		assertThat(result.getName(), is("test findByIdById"));
		
	}
	
	@Test
	public void testFindAllWithMasJobLevelServiceShouldPass() throws Exception {
		
		List<MasJobLevel> masJobLevels = masJobLevelService.findAll();
		
		masJobLevelService.create(masJobLevel);
		
		List<MasJobLevel> result = masJobLevelService.findAll();
		
		assertThat(result.size(), is(masJobLevels.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasJobLevelServiceShouldPass() throws Exception {
		
		masJobLevel.setName("test findByCriteria");
		masJobLevelService.create(masJobLevel);
		
		List<MasJobLevel> result = masJobLevelService.findByCriteria(masJobLevel);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasJobLevelServiceShouldPass() throws Exception {
		
		masJobLevelService.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel update = masJobLevelService.findById(insertedId);
		update.setName("test update");
		masJobLevelService.update(update);
		
		MasJobLevel result = masJobLevelService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasJobLevelServiceShouldPass() throws Exception {
		
		masJobLevelService.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel delete = masJobLevelService.findById(insertedId);
		masJobLevelService.delete(delete);
		
		MasJobLevel result = masJobLevelService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasJobLevelServiceShouldPass() throws Exception {
		
		masJobLevelService.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel delete = masJobLevelService.findById(insertedId);
		masJobLevelService.deleteById(delete.getId());
		
		MasJobLevel result = masJobLevelService.findById(delete.getId());
		
		assertNull(result);
		
	}

}