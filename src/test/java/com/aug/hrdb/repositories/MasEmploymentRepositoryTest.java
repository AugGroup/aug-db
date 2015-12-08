/**
 *
 * @author natechanok
 * @date Sep 4, 2015
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

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.repositories.MasEmploymentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasEmploymentRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasEmploymentRepository masEmploymentRepository;
	
	private MasEmployment masEmployment;
	
	@Before
	public void setUp() throws Exception {
		
		masEmployment = new MasEmployment();
		masEmployment.setName("test");
		masEmployment.setCode("B05");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasEmploymentRepositoryShouldPass() throws Exception {
		assertNotNull(masEmploymentRepository);
	}
	
	@Test
	public void testCreateWithMasEmploymentRepositoryShouldPass() throws Exception {
		
		masEmployment.setName("test create");
		masEmploymentRepository.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment result = masEmploymentRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasEmploymentRepositoryShouldPass() throws Exception {
		
		masEmployment.setName("test findById");
		masEmploymentRepository.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment result = masEmploymentRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasEmploymentRepositoryShouldPass() throws Exception {
		
		List<MasEmployment> masEmployments = masEmploymentRepository.findAll();
		
		masEmploymentRepository.create(masEmployment);
		
		List<MasEmployment> result = masEmploymentRepository.findAll();
		
		assertThat(result.size(), is(masEmployments.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasEmploymentRepositoryShouldPass() throws Exception {
		
		masEmployment.setName("test findByCriteria");
		masEmploymentRepository.create(masEmployment);
		
		List<MasEmployment> result = masEmploymentRepository.findByCriteria(masEmployment);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasEmploymentRepositoryShouldPass() throws Exception {
		
		masEmploymentRepository.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment update = masEmploymentRepository.find(insertedId);
		update.setName("test update");
		masEmploymentRepository.update(update);
		
		MasEmployment result = masEmploymentRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasEmploymentRepositoryShouldPass() throws Exception {
		
		masEmploymentRepository.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment delete = masEmploymentRepository.find(insertedId);
		masEmploymentRepository.delete(delete);
		
		MasEmployment result = masEmploymentRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasEmploymentRepositoryShouldPass() throws Exception {
		
		masEmploymentRepository.create(masEmployment);
		Integer insertedId = masEmployment.getId();
		
		MasEmployment delete = masEmploymentRepository.find(insertedId);
		masEmploymentRepository.deleteById(delete.getId());
		
		MasEmployment result = masEmploymentRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}