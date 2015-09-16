package services;

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
import com.aug.hrdb.services.MasRelationTypeService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRelationTypeServiceTest {

	@Autowired
	private MasRelationTypeService masRelationTypeService;
	
	int id;
	
	@Before
	public void setUp() {
		
		MasRelationType masRelationType = new MasRelationType();
		masRelationType.setRelationType("Parent");
		masRelationType.setAuditFlag("C");
		masRelationType.setCode("REL-06");
		masRelationType.setCreatedBy(1);
		masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRelationType.setIsActive(true);

		masRelationTypeService.create(masRelationType);
		
		id = masRelationType.getId();
	}
	
	
	@Test
	@Rollback(true)
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
	@Rollback(true)
	public void update() {

		MasRelationType masRelationType = masRelationTypeService.find(id);
		masRelationType.setRelationType("Daughter");
		masRelationType.setAuditFlag("U");
		masRelationType.setUpdatedBy(1);
		masRelationType.setUpdatedTimeStamp(Calendar.getInstance().getTime());

		masRelationTypeService.update(masRelationType);

	}
	
	
	
	@Test
	@Rollback(true)
	public void delete() {

		MasRelationType masRelationType = masRelationTypeService.find(id);
		masRelationTypeService.delete(masRelationType);

	}
	
	
	
	@Test
	@Rollback(true)
	public void find() {

		MasRelationType masRelationType = masRelationTypeService.find(id);
		Assert.assertEquals(id, id);


	}
	
	
	@Test
	@Rollback(true)
	public void findAll() {

		List<MasRelationType> masRelationTypeList = masRelationTypeService.findAll();
		
	}
	
	
	

	@Test
	@Rollback(true)
	public void findByName() {
	
		MasRelationType masRelationType = masRelationTypeService.findByName("Parent");
		Assert.assertEquals("Parent", masRelationType.getRelationType());
	
	}
	
	
	
	

	
}
