package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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

import com.aug.hrdb.entities.MasReservationType;
import com.aug.hrdb.repositories.MasReservationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasReservationTypeRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasReservationTypeRepository masReservationTypeRepository;
	
	private MasReservationType masReservationType;
	
	@Before
	public void setUp() throws Exception {
		
		masReservationType = new MasReservationType();
		masReservationType.setName("test");
		masReservationType.setCode("01");
		masReservationType.setIsactive(true);
		masReservationType.setAuditFlag("C");
		masReservationType.setCreatedBy(1);
		masReservationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasReservationTypeRepositoryShouldPass() throws Exception {
		assertNotNull(masReservationTypeRepository);
	}
	
	@Test
	public void testCreateWithMasReservationTypeRepositoryShouldPass() throws Exception {
		
		masReservationType.setName("test create");
		masReservationTypeRepository.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType result = masReservationTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasReservationTypeRepositoryShouldPass() throws Exception {
		
		masReservationType.setName("test findById");
		masReservationTypeRepository.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType result = masReservationTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasReservationTypeRepositoryShouldPass() throws Exception {
		
		List<MasReservationType> masReservationTypes = masReservationTypeRepository.findAll();
		
		masReservationTypeRepository.create(masReservationType);
		
		List<MasReservationType> result = masReservationTypeRepository.findAll();
		
		assertThat(result.size(), is(masReservationTypes.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasReservationTypeRepositoryShouldPass() throws Exception {
		
		masReservationTypeRepository.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType update = masReservationTypeRepository.find(insertedId);
		update.setName("test update");
		masReservationTypeRepository.update(update);
		
		MasReservationType result = masReservationTypeRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasReservationTypeRepositoryShouldPass() throws Exception {
		
		masReservationTypeRepository.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType delete = masReservationTypeRepository.find(insertedId);
		masReservationTypeRepository.delete(delete);
		
		MasReservationType result = masReservationTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasReservationTypeRepositoryShouldPass() throws Exception {
		
		masReservationTypeRepository.create(masReservationType);
		Integer insertedId = masReservationType.getId();
		
		MasReservationType delete = masReservationTypeRepository.find(insertedId);
		masReservationTypeRepository.deleteById(delete.getId());
		
		MasReservationType result = masReservationTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}
