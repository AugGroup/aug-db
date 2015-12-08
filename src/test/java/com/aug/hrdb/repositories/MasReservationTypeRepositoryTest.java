package com.aug.hrdb.repositories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
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
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasReservationTypeRepositoryTest {
	@Autowired
	private MasReservationTypeRepository masReservationTypeRepository;
	
	int id;
	
	private MasReservationType masReservationType;
	
	@Before
	public void setUp() {
		masReservationType = new MasReservationType();
		masReservationType.setName("meeting");
		masReservationType.setCode("01");
		masReservationType.setIsactive(true);
		masReservationType.setAuditFlag("C");
		masReservationType.setCreatedBy(1);
		masReservationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masReservationTypeRepository.create(masReservationType);
		id = masReservationType.getId();
	}
	

	@Test
	public void testInsertMasReservationTypeRepository() throws Exception { 
		
		MasReservationType result = masReservationTypeRepository.find(id);
		assertThat(result.getName(), is("meeting"));
		assertThat(result.getCode(), is("01"));
		assertThat(result.getAuditFlag(), is("C"));
				
	}
	
	@Test
	public void testUpdateMasReservationTypeRepository() throws Exception {
		MasReservationType updateMasReservationType = masReservationTypeRepository.find(id);
		updateMasReservationType.setName("update");
		masReservationTypeRepository.update(updateMasReservationType);
		
		MasReservationType result = masReservationTypeRepository.find(id);
		assertThat(result.getName(), is("update"));
				
	}
	
	@Test
	public void testDeleteByIdMasReservationTypeRepository() throws Exception {
		
		masReservationTypeRepository.deleteById(id);
		MasReservationType result = masReservationTypeRepository.find(id);
		assertNull(result);
	}
	
	@Test
	
	public void testDeleteMasReservationTypeRepository() throws Exception {

		masReservationTypeRepository.delete(masReservationType);
		MasReservationType result = masReservationTypeRepository.find(id);
		assertNull(result);
	}
	@Test
	public void testFindByIdMasReservationTypeRepository() throws Exception {
		
		MasReservationType result = masReservationTypeRepository.find(id);
		assertThat(result.getName(),is("meeting"));

	}
	@Test
	public void testfindAllMasReservationTypeRepository(){	
		
		List<MasReservationType> masReservationTypes = masReservationTypeRepository.findAll();
		Assert.assertEquals(4, masReservationTypes.size());
	}
}
