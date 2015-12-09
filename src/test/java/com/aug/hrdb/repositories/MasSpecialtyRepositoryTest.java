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

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.MasSpecialtyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasSpecialtyRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasSpecialtyRepository masSpecialtyRepository;
	
	private MasSpecialty masSpecialty;
	
	@Before
	public void setUp() throws Exception {
		
		masSpecialty = new MasSpecialty();
		masSpecialty.setName("test");
		masSpecialty.setCode("01");
		masSpecialty.setIsActive(true);
		masSpecialty.setAuditFlag("C");
		masSpecialty.setCreatedBy(1);	
		masSpecialty.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasSpecialtyRepositoryShouldPass() throws Exception {
		assertNotNull(masSpecialtyRepository);
	}
	
	@Test
	public void testCreateWithMasSpecialtyRepositoryShouldPass() throws Exception {
		
		masSpecialty.setName("test create");
		masSpecialtyRepository.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty result = masSpecialtyRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasSpecialtyRepositoryShouldPass() throws Exception {
		
		masSpecialty.setName("test findById");
		masSpecialtyRepository.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty result = masSpecialtyRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasSpecialtyRepositoryShouldPass() throws Exception {
		
		List<MasSpecialty> masSpecialtys = masSpecialtyRepository.findAll();
		
		masSpecialtyRepository.create(masSpecialty);
		
		List<MasSpecialty> result = masSpecialtyRepository.findAll();
		
		assertThat(result.size(), is(masSpecialtys.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasSpecialtyRepositoryShouldPass() throws Exception {
		
		masSpecialty.setName("test findByCriteria");
		masSpecialtyRepository.create(masSpecialty);
		
		List<MasSpecialty> result = masSpecialtyRepository.findByCriteria(masSpecialty);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasSpecialtyRepositoryShouldPass() throws Exception {
		
		masSpecialtyRepository.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty update = masSpecialtyRepository.find(insertedId);
		update.setName("test update");
		masSpecialtyRepository.update(update);
		
		MasSpecialty result = masSpecialtyRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasSpecialtyRepositoryShouldPass() throws Exception {
		
		masSpecialtyRepository.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty delete = masSpecialtyRepository.find(insertedId);
		masSpecialtyRepository.delete(delete);
		
		MasSpecialty result = masSpecialtyRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasSpecialtyRepositoryShouldPass() throws Exception {
		
		masSpecialtyRepository.create(masSpecialty);
		Integer insertedId = masSpecialty.getId();
		
		MasSpecialty delete = masSpecialtyRepository.find(insertedId);
		masSpecialtyRepository.deleteById(delete.getId());
		
		MasSpecialty result = masSpecialtyRepository.find(delete.getId());
		
		assertNull(result);
		
	}

}