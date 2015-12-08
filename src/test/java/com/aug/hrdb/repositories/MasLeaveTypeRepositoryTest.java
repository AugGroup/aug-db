/**
 *
 * @author Pranrajit
 * @date 11 ก.ย. 2558
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

import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.repositories.MasLeaveTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasLeaveTypeRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private MasLeaveTypeRepository masLeaveTypeRepository;
	
	private MasLeaveType masLeaveType;
		
	@Before
	public void setUp() throws Exception {
		
		masLeaveType = new MasLeaveType();
		masLeaveType.setName("test");
		masLeaveType.setCode("MD-01");
		masLeaveType.setIsactive(true);
		masLeaveType.setAuditFlag("C");
		masLeaveType.setCreatedBy(1);
		masLeaveType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasLeaveTypeRepositoryShouldPass() throws Exception {
		assertNotNull(masLeaveTypeRepository);
	}
	
	@Test
	public void testCreateWithMasLeaveTypeRepositoryShouldPass() throws Exception {
		
		masLeaveType.setName("test create");
		masLeaveTypeRepository.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType result = masLeaveTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasLeaveTypeRepositoryShouldPass() throws Exception {
		
		masLeaveType.setName("test findById");
		masLeaveTypeRepository.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType result = masLeaveTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasLeaveTypeRepositoryShouldPass() throws Exception {
		
		List<MasLeaveType> masLeaveTypes = masLeaveTypeRepository.findAll();
		
		masLeaveTypeRepository.create(masLeaveType);
		
		List<MasLeaveType> result = masLeaveTypeRepository.findAll();
		
		assertThat(result.size(), is(masLeaveTypes.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasLeaveTypeRepositoryShouldPass() throws Exception {
		
		masLeaveType.setName("test findByCriteria");
		masLeaveTypeRepository.create(masLeaveType);
		
		List<MasLeaveType> result = masLeaveTypeRepository.findByCriteria(masLeaveType);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasLeaveTypeRepositoryShouldPass() throws Exception {
		
		masLeaveTypeRepository.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType update = masLeaveTypeRepository.find(insertedId);
		update.setName("test update");
		masLeaveTypeRepository.update(update);
		
		MasLeaveType result = masLeaveTypeRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasLeaveTypeRepositoryShouldPass() throws Exception {
		
		masLeaveTypeRepository.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType delete = masLeaveTypeRepository.find(insertedId);
		masLeaveTypeRepository.delete(delete);
		
		MasLeaveType result = masLeaveTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasLeaveTypeRepositoryShouldPass() throws Exception {
		
		masLeaveTypeRepository.create(masLeaveType);
		Integer insertedId = masLeaveType.getId();
		
		MasLeaveType delete = masLeaveTypeRepository.find(insertedId);
		masLeaveTypeRepository.deleteById(delete.getId());
		
		MasLeaveType result = masLeaveTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}