package repositories;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.repositories.MasStaffTypeRepository;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasStaffTypeRepositoryTest {
	
	@Autowired
	private MasStaffTypeRepository masStaffTypeRepository;
	
	@Test
	@Rollback(false)
	public void create() {

		MasStaffType masStaffType = new MasStaffType();
		masStaffType.setName("Augmentis");
		masStaffType.setAuditFlag("C");
		masStaffType.setCode("STAFF-03");
		masStaffType.setCreatedBy(1);
		masStaffType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masStaffType.setIsActive(true);

		masStaffTypeRepository.create(masStaffType);

	}
	
	
	@Test
	@Rollback(false)
	public void updateMasStaffType(){

		MasStaffType masStaffType =  masStaffTypeRepository.find(2);
		masStaffType.setCode("STAFF-04");
		masStaffType.setAuditFlag("U");
		masStaffType.setUpdatedBy(1);
		masStaffType.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		masStaffTypeRepository.update(masStaffType);
		
	}
	
	
	@Test
	@Rollback(false)
	public void deleteMasStaffType(){
		
		MasStaffType masStaffType = masStaffTypeRepository.find(1);;
		masStaffTypeRepository.delete(masStaffType);
		
	}
	
	
	
	@Test
	public void listMasStaffType(){
		
		List<MasStaffType> masStaffTypeList = masStaffTypeRepository.findAll();
		Assert.assertEquals(1, masStaffTypeList.size());
		
		for(int i=0;i<masStaffTypeList.size();i++){		
			System.out.println("id: "+masStaffTypeList.get(i).getId());
		}
		
	}
	
	
	@Test
	public void findByIdMasTechnology(){
		
		MasStaffType masStaffType = masStaffTypeRepository.find(3);	
		int id = masStaffType.getId();
		Assert.assertEquals(3, id);
		System.out.println("id: "+id);
		
	}
	

}
