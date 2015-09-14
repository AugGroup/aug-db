/**
 *
 * @author Pranrajit
 * @date 14 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasDegreetype;
import com.aug.hrdb.services.MasDegreetypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasDegreeTypeServiceTest {

	@Autowired MasDegreetypeService masDegreetypeService;
	
	@Test
	public void create(){
		MasDegreetype masDegreetype=new MasDegreetype();
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-02");
		masDegreetype.setIsactive(true);
		masDegreetype.setAuditFlag("C");
		masDegreetype.setCreatedBy(1);
		masDegreetype.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeService.create(masDegreetype);
	}
	
	

	/*@Test
	public void update(){
		MasDegreetype masDegreetype=(MasDegreetype)masDegreetypeService.find(1);
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-01");
		masDegreetypeService.update(masDegreetype);
		
		
	}*/
/*
	@Test
	public void delete(){
	MasDegreetype masDegreetype=masDegreetypeService.find(1);
	masDegreetypeService.delete(masDegreetype);
		
	}*/

	/*@SuppressWarnings("deprecation")
	@Test
	public void findAll(){
		List<MasDegreetype>masDegreetypes=masDegreetypeService.findAll();
		Assert.assertEquals(4,masDegreetypes.size());
		
	}*/

	/*@SuppressWarnings("deprecation")
	@Test
	public void findById(){
		MasDegreetype masDegreetype=masDegreetypeService.find(1);
		int id = masDegreetype.getId();
		Assert.assertEquals(1,id);
		
	}*/
}
