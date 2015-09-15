/**
 *
 * @author Pranrajit
 * @date 14 ก.ย. 2558
 */
package services;

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

import com.aug.hrdb.entities.MasDegreetype;
import com.aug.hrdb.services.MasDegreetypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasDegreeTypeServiceTest {

	@Autowired MasDegreetypeService masDegreetypeService;
	
	
	

	@Before
	public void setValue(){
		MasDegreetype masDegreetype=new MasDegreetype();
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-03");
		masDegreetype.setIsactive(true);
		masDegreetype.setAuditFlag("C");
		masDegreetype.setCreatedBy(1);
		masDegreetype.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeService.create(masDegreetype);
		
		
		MasDegreetype masDegreetype1=new MasDegreetype();
		masDegreetype1.setName("DR");
		masDegreetype1.setCode("DE-02");
		masDegreetype1.setIsactive(true);
		masDegreetype1.setAuditFlag("C");
		masDegreetype1.setCreatedBy(1);
		masDegreetype1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeService.create(masDegreetype1);
	
		
		
		
		
		/*MasDegreetype masDegreetype2=new MasDegreetype();
		masDegreetype2.setName("DR");
		masDegreetype2.setCode("DE-02");
		masDegreetype2.setIsactive(true);
		masDegreetype2.setAuditFlag("C");
		masDegreetype2.setCreatedBy(1);
		masDegreetype2.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeService.create(masDegreetype2);*/
	}
	
	
	
	
	
	@Test
	@Rollback(true)
	public void create(){
		MasDegreetype masDegreetype=new MasDegreetype();
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-01");
		masDegreetype.setIsactive(true);
		masDegreetype.setAuditFlag("C");
		masDegreetype.setCreatedBy(1);
		masDegreetype.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeService.create(masDegreetype);
		
		/*MasDegreetype masDegreetype1=new MasDegreetype();
		masDegreetype1.setName("DR");
		masDegreetype1.setCode("DE-02");
		masDegreetype1.setIsactive(true);
		masDegreetype1.setAuditFlag("C");
		masDegreetype1.setCreatedBy(1);
		masDegreetype1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeService.create(masDegreetype1);*/
	
		
		
		
		/*
		MasDegreetype masDegreetype2=new MasDegreetype();
		masDegreetype2.setName("DR");
		masDegreetype2.setCode("DE-02");
		masDegreetype2.setIsactive(true);
		masDegreetype2.setAuditFlag("C");
		masDegreetype2.setCreatedBy(1);
		masDegreetype2.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeService.create(masDegreetype2);*/
		
	}
	
	

	@Test
	@Rollback(true)
	public void update(){
		MasDegreetype masDegreetype=(MasDegreetype)masDegreetypeService.find(2);
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-01");
		masDegreetypeService.update(masDegreetype);
		
		
	}

	@Test
	@Rollback(true)
	public void delete(){
	MasDegreetype masDegreetype=masDegreetypeService.find(1);
	masDegreetypeService.delete(masDegreetype);
		
	}

	
	@Test
	@Rollback(true)
	public void findAll(){
		List<MasDegreetype>masDegreetypes=masDegreetypeService.findAll();
		
		
	}

	
	@Test
	@Rollback(true)
	public void findById(){
		MasDegreetype masDegreetype=masDegreetypeService.find(3);
		int id = masDegreetype.getId();
		Assert.assertEquals(3,id);
		
	}
}
