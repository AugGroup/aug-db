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

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.FamilyRepository;
import com.aug.hrdb.repositories.MasRelationTypeRepository;
import com.aug.hrdb.services.FamilyService;
import com.aug.hrdb.services.MasRelationTypeService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class FamilyServiceTest {
	
	
	@Autowired
	private FamilyService familyService;
	@Autowired
	private MasRelationTypeService masRelationTypeService;
	
	

	@Test
	@Rollback(false)
	public void create() {
	
		Family family = new Family();

		family.setFamilyName("Apiva kimkatanom");
		family.setGender("Female");
		family.setAge(25);
		family.setMobile("089-085-1022");
		family.setAddress("1/1");
		family.setOccupation("ITS");
		family.setPosition("Programmer");
		
		MasRelationType masRelationType = masRelationTypeService.find(1);
		family.setMasRelationType(masRelationType);
		
		family.setAuditFlag("C");
		family.setCreatedBy(1);
		family.setCreatedTimeStamp(Calendar.getInstance().getTime());
	
		familyService.create(family);
		
		
		
		
		Family family2 = new Family();

		family2.setFamilyName("Augmentis.co.th");
		family2.setGender("Female");
		family2.setAge(25);
		family2.setMobile("021-085-1022");
		family2.setAddress("1/1");
		family2.setOccupation("ITS");
		family2.setPosition("Programmer");
		
		MasRelationType masRelationType2 = masRelationTypeService.find(1);
		family2.setMasRelationType(masRelationType2);
		
		family2.setAuditFlag("C");
		family2.setCreatedBy(1);
		family2.setCreatedTimeStamp(Calendar.getInstance().getTime());
	
		familyService.create(family2);

	
	}
	
	
	
	
	
	
	@Test
	@Rollback(false)
	public void update() {
	
	
		Family family = familyService.find(4);
		family.setFamilyName("test");
		family.setAuditFlag("U");
		family.setUpdatedBy(1);
		family.setUpdatedTimeStamp(Calendar.getInstance().getTime());
	
		familyService.update(family);
	
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void delete() {
	
		Family family = familyService.find(4);
		familyService.delete(family);
	
	}
	
	
	
	
	@Test
	public void find() {
	
		Family family = familyService.find(3);
		int id = family.getId().intValue();
		Assert.assertEquals(3, id);
	}
	
	
	
	
	
	@Test
	
	public void findAll() {
	
		List<Family> family = familyService.findAll();
		Assert.assertEquals(2, family.size());
		
		for(int i=0;i<family.size();i++){		
			System.out.println("id: "+family.get(i).getId());
		}		
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void deleteByNameQuery(){
		
		Family family = familyService.find(3);
		FamilyDto familyDto = new FamilyDto();
		familyDto.setId(family.getId());
		familyService.deleteByNameQuery(familyDto);
		
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void updateByNameQuery(){
		
		Family family = familyService.find(6);
		FamilyDto familyDto = new FamilyDto();
		familyDto.setId(family.getId());
		familyDto.setFamilyName("test family data");
		familyDto.setAge(family.getAge());
		familyDto.setAddress(family.getAddress());
		familyDto.setMasRelationTypeId(family.getMasRelationType().getId());
		familyDto.setMobile(family.getMobile());
		familyDto.setPosition(family.getPosition());
		familyDto.setOccupation(family.getOccupation());
		familyDto.setGender(family.getGender());
		familyService.updateByNameQuery(familyDto);
	
	}
	
	
	
	@Test
	@Rollback(false)
	public void createFindMasRelationAndEmployee(){
		
		FamilyDto familyDto = new FamilyDto();
		familyDto.setFamilyName("test create data");
		familyDto.setAge(25);
		familyDto.setAddress("HOME");
		familyDto.setMasRelationTypeId(1);
		familyDto.setMobile("089-085-1022");
		familyDto.setPosition("PROGRAMER");
		familyDto.setOccupation("ITS");
		familyDto.setGender("Female");
		familyService.createFindMasRelationAndEmployee(familyDto);

		
	}
	

}
