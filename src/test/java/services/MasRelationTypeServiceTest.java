package services;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.services.MasRelationTypeService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRelationTypeServiceTest {

	@Autowired
	private MasRelationTypeService masRelationTypeService;
	
	
	@Test
	@Rollback(false)
	public void create() {

		MasRelationType masRelationType = new MasRelationType();
		masRelationType.setRelationType("Son");
		masRelationType.setAuditFlag("C");
		masRelationType.setCode("REL-06");
		masRelationType.setCreatedBy(1);
		masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRelationType.setIsActive(true);

		masRelationTypeService.create(masRelationType);

	}
	
	
	
	@Test
	@Rollback(false)
	public void update() {

		MasRelationType masRelationType = masRelationTypeService.find(4);
		masRelationType.setRelationType("Daughter");
		masRelationType.setAuditFlag("U");
		masRelationType.setUpdatedBy(1);
		masRelationType.setUpdatedTimeStamp(Calendar.getInstance().getTime());

		masRelationTypeService.update(masRelationType);

	}
	
	
	
	@Test
	@Rollback(false)
	public void delete() {

		MasRelationType masRelationType = masRelationTypeService.find(4);
		masRelationTypeService.delete(masRelationType);

	}
	
	
	
	@Test
	public void find() {

		MasRelationType masRelationType = masRelationTypeService.find(1);
		int id = masRelationType.getId().intValue();
		Assert.assertEquals(1, id);


	}
	
	
	@Test
	public void findAll() {

		List<MasRelationType> masRelationTypeList = masRelationTypeService.findAll();
		Assert.assertEquals(2, masRelationTypeList.size());
		
		for(int i=0;i<masRelationTypeList.size();i++){		
			System.out.println("id: "+masRelationTypeList.get(i).getId());
		}


	}
	
	
	

	@Test
	@Rollback(false)
	public void findByName() {
	
		MasRelationType masRelationType = masRelationTypeService.findByName("Mother");
		Assert.assertEquals("Mother", masRelationType.getRelationType());
	
	}
	
	
	
	

	
}
