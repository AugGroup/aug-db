package com.aug.hrdb.repositories;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@Transactional
public class MasTechnologyRepositoryTest {
	
	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
	
	int id;
	
	@Before
	public void setValue(){
		MasTechnology masTech = new MasTechnology();
		masTech.setName("PHP");
		masTech.setCode("004A");
		masTech.setIsActive(true);
		
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		
		masTechnologyRepository.create(masTech);
		id = masTech.getId();
	}
	
	@Test
	public void createMasTechnology(){
		
		
		MasTechnology masTech = new MasTechnology();
		masTech.setName("java");
		masTech.setCode("001A");
		masTech.setIsActive(true);
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTech);
		
	}
	
	
	@Test
	@Rollback(true)
	public void updateMasTechnology(){
		
		MasTechnology masTech = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, id);
		masTech.setName("SAP");
		masTechnologyRepository.update(masTech);
		
	}
	
	
	@Test
	@Rollback(true)
	public void deleteMasTechnology(){
		
		MasTechnology masTech = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, id);
		masTechnologyRepository.delete(masTech);;
		
	}
	
	
	@Test
	@Rollback(true)
	public void findByIdMasTechnology(){
		
		MasTechnology masTechnology = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, id);		
		int id = masTechnology.getId();
		Assert.assertEquals(id, id);
		
	}
	

	@Test
	@Rollback(true)
	public void list() {

		Criteria c = masTechnologyRepository.getCurrentSession().createCriteria(
				MasTechnology.class);
		List<MasTechnology> masTechnologies = c.list();
		
	}
}
