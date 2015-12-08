/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package com.aug.hrdb.services;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.services.MasEmploymentService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasEmploymentServiceTest {
	
	@Autowired
	private MasEmploymentService masEmploymentService;
	
	int id;
	
	@Before
	public void setUp(){
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("BBBBB");
		masEmployment.setCode("B05");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masEmploymentService.create(masEmployment);
		id = masEmployment.getId();
		
	}
	
	@Test
	@Rollback(true)
	public void create() {
		
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("WWWWW");
		masEmployment.setCode("001W");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masEmploymentService.create(masEmployment);
		
	}
	
	@Test
	@Rollback(true)
	public void update(){
		
		MasEmployment masEmployment = (MasEmployment)masEmploymentService.findById(id);
		masEmployment.setName("BBBBB");
		masEmploymentService.update(masEmployment);
		
	}
	
	@Test
	@Rollback(true)
	public void delete() {
		
		MasEmployment masEmployment = (MasEmployment)masEmploymentService.findById(id);
		masEmploymentService.delete(masEmployment);
		
	}
	
	@Test
	@Rollback(true)
	public void findAll(){
		
		List<MasEmployment> masEmployments = masEmploymentService.findAll();
		
	}
	
	
	@Test
	@Rollback(true)
	public void findById() {
		
		MasEmployment masEmployment = masEmploymentService.findById(id);	
		int id = masEmployment.getId();
		Assert.assertEquals("BBBBB",masEmployment.getName());
	}
	
}
