package repositories;

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
import com.aug.hrdb.repositories.MasRelationTypeRepository;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRelationTypeRepositoryTest {
	
@Autowired
private MasRelationTypeRepository masRelationTypeRepository;



	@Test
	@Rollback(false)
	public void create() {
	
		MasRelationType masRelationType = new MasRelationType();
		masRelationType.setRelationType("Farther");
		masRelationType.setAuditFlag("C");
		masRelationType.setCode("REL-03");
		masRelationType.setCreatedBy(1);
		masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRelationType.setIsActive(true);
	
		masRelationTypeRepository.create(masRelationType);
	
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void update() {
	
	
		MasRelationType masRelationType = masRelationTypeRepository.find(3);
		masRelationType.setRelationType("Daughter");
		masRelationType.setAuditFlag("U");
		masRelationType.setUpdatedBy(1);
		masRelationType.setUpdatedTimeStamp(Calendar.getInstance().getTime());
	
		masRelationTypeRepository.update(masRelationType);
	
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void delete() {
	
		MasRelationType masRelationType = masRelationTypeRepository.find(3);
		masRelationTypeRepository.delete(masRelationType);
	
	}
	
	
	
	
	@Test
	public void find() {
	
		MasRelationType masRelationType = masRelationTypeRepository.find(1);
		int id = masRelationType.getId().intValue();
		Assert.assertEquals(1, id);
	
	
	}
	
	
	@Test
	public void findAll() {
	
		List<MasRelationType> masRelationTypeList = masRelationTypeRepository.findAll();
		Assert.assertEquals(1, masRelationTypeList.size());
		
		for(int i=0;i<masRelationTypeList.size();i++){		
			System.out.println("id: "+masRelationTypeList.get(i).getId());
		}
	
	
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void findByName() {
	
		MasRelationType masRelationType = masRelationTypeRepository.findByName("Farther");
		Assert.assertEquals("Farther", masRelationType.getRelationType());
	
	}

}
