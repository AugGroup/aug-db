/**
 *
 * @author Preeyaporn
 * @date 27 เม.ย. 2558
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

import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.repositories.MasDivisionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasDivisionRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasDivisionRepository masDivisionRepository;
	
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
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasDivisionRepositoryShouldPass() throws Exception {
		assertNotNull(masDivisionRepository);
	}
	
	@Test
	public void testCreateWithMasDivisionRepositoryShouldPass() throws Exception {
		
		masDivision.setName("test create");
		masDivisionRepository.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision result = masDivisionRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasDivisionRepositoryShouldPass() throws Exception {
		
		masDivision.setName("test findById");
		masDivisionRepository.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision result = masDivisionRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasDivisionRepositoryShouldPass() throws Exception {
		
		List<MasDivision> masDivisions = masDivisionRepository.findAll();
		
		masDivisionRepository.create(masDivision);
		
		List<MasDivision> result = masDivisionRepository.findAll();
		
		assertThat(result.size(), is(masDivisions.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasDivisionRepositoryShouldPass() throws Exception {
		
		masDivisionRepository.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision update = masDivisionRepository.find(insertedId);
		update.setName("test update");
		masDivisionRepository.update(update);
		
		MasDivision result = masDivisionRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasDivisionRepositoryShouldPass() throws Exception {
		
		masDivisionRepository.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision delete = masDivisionRepository.find(insertedId);
		masDivisionRepository.delete(delete);
		
		MasDivision result = masDivisionRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasDivisionRepositoryShouldPass() throws Exception {
		
		masDivisionRepository.create(masDivision);
		Integer insertedId = masDivision.getId();
		
		MasDivision delete = masDivisionRepository.find(insertedId);
		masDivisionRepository.deleteById(delete.getId());
		
		MasDivision result = masDivisionRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}