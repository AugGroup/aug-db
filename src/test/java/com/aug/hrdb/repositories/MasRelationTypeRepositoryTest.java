package com.aug.hrdb.repositories;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.MasRelationTypeRepository;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRelationTypeRepositoryTest {
	
@Autowired
private MasRelationTypeRepository masRelationTypeRepository;


int id;

@Before
public void setUp() {
	
	MasRelationType masRelationType = new MasRelationType();
	masRelationType.setRelationType("Parent");
	masRelationType.setAuditFlag("C");
	masRelationType.setCode("REL-03");
	masRelationType.setCreatedBy(1);
	masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
	masRelationType.setIsActive(true);

	masRelationTypeRepository.create(masRelationType);
	id = masRelationType.getId();
	
}

	@Test
	@Rollback(true)
	public void create() {
	
		MasRelationType masRelationType = new MasRelationType();
		masRelationType.setRelationType("Father");
		masRelationType.setAuditFlag("C");
		masRelationType.setCode("REL-03");
		masRelationType.setCreatedBy(1);
		masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRelationType.setIsActive(true);
	
		masRelationTypeRepository.create(masRelationType);
		
		
		
		MasRelationType masRelationType2 = new MasRelationType();
		masRelationType2.setRelationType("Mother");
		masRelationType2.setAuditFlag("C");
		masRelationType2.setCode("REL-04");
		masRelationType2.setCreatedBy(1);
		masRelationType2.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRelationType2.setIsActive(true);
	
		masRelationTypeRepository.create(masRelationType2);
		
		
		
		
		MasRelationType masRelationType3 = new MasRelationType();
		masRelationType3.setRelationType("Son");
		masRelationType3.setAuditFlag("C");
		masRelationType3.setCode("REL-05");
		masRelationType3.setCreatedBy(1);
		masRelationType3.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRelationType3.setIsActive(true);
	
		masRelationTypeRepository.create(masRelationType3);
	
	
	
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void update() {
	
	
		MasRelationType masRelationType = masRelationTypeRepository.find(id);
		masRelationType.setRelationType("Daughter");
		masRelationType.setAuditFlag("U");
		masRelationType.setUpdatedBy(1);
		masRelationType.setUpdatedTimeStamp(Calendar.getInstance().getTime());
	
		masRelationTypeRepository.update(masRelationType);
	
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void delete() {
	
		MasRelationType masRelationType = masRelationTypeRepository.find(id);
		masRelationTypeRepository.delete(masRelationType);
	
	}
	
	
	
	
	@Test
	public void find() {
	
		MasRelationType masRelationType = masRelationTypeRepository.find(id);
		Assert.assertEquals(id, id);
	
	
	}
	
	
	@Test
	public void findAll() {
	
		List<MasRelationType> masRelationTypeList = masRelationTypeRepository.findAll();
		
	
	
	}
	
	
	
	
	@Test
	public void findByName() {
	
		MasRelationType masRelationType = masRelationTypeRepository.findByName("Parent");
		Assert.assertEquals("Parent", masRelationType.getRelationType());
	
	}

}
