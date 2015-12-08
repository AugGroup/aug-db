/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
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

import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.services.MasDivisionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
public class MasDivisionServiceTest {

	@Autowired
	private MasDivisionService masDivisionServices;
	
	int id;
	@Before
	public void setValue(){
		MasDivision masDivision = new MasDivision();
		masDivision.setName("CEO");
		masDivision.setIsActive(true);
		masDivision.setCode("01");

		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masDivisionServices.create(masDivision);
			
		id = masDivision.getId();
	}
	@Test
	@Rollback(true)
	public void createDatamasDivision(){

		MasDivision masDivision = new MasDivision();
		masDivision.setName("PHP");
		masDivision.setCode("004A");
		masDivision.setIsActive(true);
		
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masDivision.setCreatedTimeStamp(cal.getTime());
		
		masDivisionServices.create(masDivision);
	}
	
	@Test
	@Rollback(true)
	public void updateDatamasDivision(){

		MasDivision masDivision = masDivisionServices.findById(id);
		masDivision.setName("JAVA");
		masDivisionServices.update(masDivision);
		
	}
	
	@Test
	@Rollback(true)
	public void deleteDatamasDivision(){

		MasDivision masDivision = masDivisionServices.findById(id);
		masDivisionServices.delete(masDivision);
		
	}
	
	@Test
	@Rollback(true)
	public void findbyIdmasDivision(){

		MasDivision  masDivision = masDivisionServices.findById(id);
		int id = masDivision.getId();
		Assert.assertEquals(id,id);
		
	}
}
