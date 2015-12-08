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

import com.aug.hrdb.entities.MasCareerCaseStatus;
import com.aug.hrdb.repositories.MasCareerCaseStatusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasCareerCaseStatusRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasCareerCaseStatusRepository masCareerCaseStatusRepository;
	
	MasCareerCaseStatus masCareerCaseStatus;
	
	@Before
	public void setUp() throws Exception {
		
		masCareerCaseStatus = new MasCareerCaseStatus();
		masCareerCaseStatus.setName("test");
		masCareerCaseStatus.setAuditFlag("C");
		masCareerCaseStatus.setCreatedBy(0);
		masCareerCaseStatus.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasCareerCaseStatusRepositoryShouldPass() throws Exception {
		assertNotNull(masCareerCaseStatusRepository);
	}
	
	@Test
	public void testCreateWithMasCareerCaseStatusRepositoryShouldPass() throws Exception {
		
		masCareerCaseStatus.setName("test create");
		masCareerCaseStatusRepository.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus result = masCareerCaseStatusRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByidWithMasCareerCaseStatusRepositoryShouldPass() throws Exception {
		
		masCareerCaseStatus.setName("test findById");
		masCareerCaseStatusRepository.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus result = masCareerCaseStatusRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasCareerCaseStatusRepositoryShouldPass() throws Exception {
		
		List<MasCareerCaseStatus> masCareerCaseStatuses = masCareerCaseStatusRepository.findAll();
		
		masCareerCaseStatusRepository.create(masCareerCaseStatus);
		
		List<MasCareerCaseStatus> result = masCareerCaseStatusRepository.findAll();
		
		assertThat(result.size(), is(masCareerCaseStatuses.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasCareerCaseStatusRepositoryShouldPass() throws Exception {
		
		masCareerCaseStatusRepository.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus update = masCareerCaseStatusRepository.find(insertedId);
		update.setName("test update");
		masCareerCaseStatusRepository.update(update);
		
		MasCareerCaseStatus result = masCareerCaseStatusRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasCareerCaseStatusRepositoryShouldPass() throws Exception {
		
		masCareerCaseStatusRepository.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus delete = masCareerCaseStatusRepository.find(insertedId);
		masCareerCaseStatusRepository.delete(delete);
		
		MasCareerCaseStatus result = masCareerCaseStatusRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasCareerCaseStatusRepositoryShouldPass() throws Exception {
		
		masCareerCaseStatusRepository.create(masCareerCaseStatus);
		Integer insertedId = masCareerCaseStatus.getId();
		
		MasCareerCaseStatus delete = masCareerCaseStatusRepository.find(insertedId);
		masCareerCaseStatusRepository.deleteById(delete.getId());
		
		MasCareerCaseStatus result = masCareerCaseStatusRepository.find(delete.getId());
		
		assertNull(result);
	}
	
}