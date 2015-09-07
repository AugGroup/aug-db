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

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.FamilyRepository;
import com.aug.hrdb.repositories.MasRelationTypeRepository;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class FamilyRepositoryTest {
	
	@Autowired
	private FamilyRepository familyRepository;
	@Autowired
	private MasRelationTypeRepository masRelationTypeRepository;
	
	

	@Test
	@Rollback(false)
	public void create() {
	
		Family family = new Family();

		family.setFamilyName("Apiva kim");
		family.setGender("Female");
		family.setAge(25);
		family.setMobile("089-085-1022");
		family.setAddress("1/1");
		family.setOccupation("ITS");
		family.setPosition("Programmer");
		
		MasRelationType masRelationType = masRelationTypeRepository.find(1);
		family.setMasRelationType(masRelationType);
		
		family.setAuditFlag("C");
		family.setCreatedBy(1);
		family.setCreatedTimeStamp(Calendar.getInstance().getTime());
	
		familyRepository.create(family);
		
		
		
		
		Family family2 = new Family();

		family2.setFamilyName("Augmentis");
		family2.setGender("Female");
		family2.setAge(25);
		family2.setMobile("029-085-1022");
		family2.setAddress("1/1");
		family2.setOccupation("ITS");
		family2.setPosition("Programmer");
		
		MasRelationType masRelationType2 = masRelationTypeRepository.find(1);
		family2.setMasRelationType(masRelationType2);
		
		family2.setAuditFlag("C");
		family2.setCreatedBy(1);
		family2.setCreatedTimeStamp(Calendar.getInstance().getTime());
	
		familyRepository.create(family2);

	
	}
	
	
	
	
	
	
	@Test
	@Rollback(false)
	public void update() {
	
	
		Family family = familyRepository.find(2);
		family.setFamilyName("Augmentis test");
		family.setAuditFlag("U");
		family.setUpdatedBy(1);
		family.setUpdatedTimeStamp(Calendar.getInstance().getTime());
	
		familyRepository.update(family);
	
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void delete() {
	
		Family family = familyRepository.find(2);
		familyRepository.delete(family);
	
	}
	
	
	
	
	@Test
	public void find() {
	
		Family family = familyRepository.find(1);
		int id = family.getId().intValue();
		Assert.assertEquals(1, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Family> family = familyRepository.findAll();
		Assert.assertEquals(1, family.size());
		
		for(int i=0;i<family.size();i++){		
			System.out.println("id: "+family.get(i).getId());
		}
	
	
	}
	
	
	
	@Test
	@Rollback(false)
	public void deleteByNameQuery(){
		
		Family family = familyRepository.find(1);
		FamilyDto familyDto = new FamilyDto();
		familyDto.setId(family.getId());
		familyRepository.deleteByNameQuery(familyDto);
		
	}
	
	
	
	@Test
	@Rollback(false)
	public void updateByNameQuery(){
		
		Family family = familyRepository.find(5);
		FamilyDto familyDto = new FamilyDto();
		familyDto.setId(family.getId());
		familyDto.setFamilyName("test data");
		familyDto.setAge(family.getAge());
		familyDto.setAddress(family.getAddress());
		familyDto.setMasRelationTypeId(family.getMasRelationType().getId());
		familyDto.setMobile(family.getMobile());
		familyDto.setPosition(family.getPosition());
		familyDto.setOccupation(family.getOccupation());
		familyDto.setGender(family.getGender());
		familyRepository.updateByNameQuery(familyDto);
	
	}
	
	

}
