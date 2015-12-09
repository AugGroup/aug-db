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

import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.repositories.MasStaffTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasStaffTypeRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasStaffTypeRepository masStaffTypeRepository;
	
	private MasStaffType masStaffType;
	
	@Before
	public void setUp() throws Exception {
		
		masStaffType = new MasStaffType();
		masStaffType.setName("test");
		masStaffType.setAuditFlag("C");
		masStaffType.setCode("STAFF-03");
		masStaffType.setCreatedBy(1);
		masStaffType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masStaffType.setIsActive(true);
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasStaffTypeRepositoryShouldPass() throws Exception {
		assertNotNull(masStaffTypeRepository);
	}
	
	@Test
	public void testCreateWithMasStaffTypeRepositoryShouldPass() throws Exception {
		
		masStaffType.setName("test create");
		masStaffTypeRepository.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType result = masStaffTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasStaffTypeRepositoryShouldPass() throws Exception {
		
		masStaffType.setName("test findById");
		masStaffTypeRepository.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType result = masStaffTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasStaffTypeRepositoryShouldPass() throws Exception {
		
		List<MasStaffType> masStaffTypes = masStaffTypeRepository.findAll();
		
		masStaffTypeRepository.create(masStaffType);
		
		List<MasStaffType> result = masStaffTypeRepository.findAll();
		
		assertThat(result.size(), is(masStaffTypes.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasStaffTypeRepositoryShouldPass() throws Exception {
		
		masStaffTypeRepository.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType update = masStaffTypeRepository.find(insertedId);
		update.setName("test update");
		masStaffTypeRepository.update(update);
		
		MasStaffType result = masStaffTypeRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasStaffTypeRepositoryShouldPass() throws Exception {
		
		masStaffTypeRepository.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType delete = masStaffTypeRepository.find(insertedId);
		masStaffTypeRepository.delete(delete);
		
		MasStaffType result = masStaffTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasStaffTypeRepositoryShouldPass() throws Exception {
		
		masStaffTypeRepository.create(masStaffType);
		Integer insertedId = masStaffType.getId();
		
		MasStaffType delete = masStaffTypeRepository.find(insertedId);
		masStaffTypeRepository.deleteById(delete.getId());
		
		MasStaffType result = masStaffTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}

}