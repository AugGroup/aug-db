/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
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
import com.aug.hrdb.repositories.MasJobLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasJoblevelRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private MasJobLevelRepository masJobLevelRepository;
	
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
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasJobLevelRepositoryShouldPass() throws Exception {
		assertNotNull(masJobLevelRepository);
	}
	
	@Test
	public void testCreateWithMasJobLevelRepositoryShouldPass() throws Exception {
		
		masJobLevel.setName("test create");
		masJobLevelRepository.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel result = masJobLevelRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasJobLevelRepositoryShouldPass() throws Exception {
		
		masJobLevel.setName("test findById");
		masJobLevelRepository.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel result = masJobLevelRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasJobLevelRepositoryShouldPass() throws Exception {
		
		List<MasJobLevel> masJobLevels = masJobLevelRepository.findAll();
		
		masJobLevelRepository.create(masJobLevel);
		
		List<MasJobLevel> result = masJobLevelRepository.findAll();
		
		assertThat(result.size(), is(masJobLevels.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasJobLevelRepositoryShouldPass() throws Exception {
		
		masJobLevel.setName("test findByCriteria");
		masJobLevelRepository.create(masJobLevel);
		
		List<MasJobLevel> result = masJobLevelRepository.findByCriteria(masJobLevel);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasJobLevelRepositoryShouldPass() throws Exception {
		
		masJobLevelRepository.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel update = masJobLevelRepository.find(insertedId);
		update.setName("test update");
		masJobLevelRepository.update(update);
		
		MasJobLevel result = masJobLevelRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasJobLevelRepositoryShouldPass() throws Exception {
		
		masJobLevelRepository.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel delete = masJobLevelRepository.find(insertedId);
		masJobLevelRepository.delete(delete);
		
		MasJobLevel result = masJobLevelRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasJobLevelRepositoryShouldPass() throws Exception {
		
		masJobLevelRepository.create(masJobLevel);
		Integer insertedId = masJobLevel.getId();
		
		MasJobLevel delete = masJobLevelRepository.find(insertedId);
		masJobLevelRepository.deleteById(delete.getId());
		
		MasJobLevel result = masJobLevelRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}