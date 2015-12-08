package com.aug.hrdb.repositories;

import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.MasSpecialtyRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasSpecialtyRepositoryTest {
	
	@Autowired
	private MasSpecialtyRepository masSpecialtyRepository;
	
	
	@Test
	@Rollback(true)
	public void createMasSpecialty(){
		MasSpecialty masSpecialty=new MasSpecialty();
		masSpecialty.setName("Java");
		masSpecialty.setCode("01");
		masSpecialty.setIsActive(true);
		masSpecialty.setAuditFlag("C");
		masSpecialty.setCreatedBy(1);	
		masSpecialty.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masSpecialtyRepository.create(masSpecialty);
	}

	
	
	@Test
	@Rollback(true)
	public void updateMasSpecialty(){
		
		MasSpecialty masSpecialty = (MasSpecialty)masSpecialtyRepository.find(1);
		masSpecialty.setName(".net");
		masSpecialty.setCode("02");
		masSpecialty.setIsActive(true);
		masSpecialty.setAuditFlag("C");
		masSpecialty.setCreatedBy(1);	
		masSpecialty.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masSpecialtyRepository.update(masSpecialty);
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void deleteMasSpecialty(){
		
		MasSpecialty masSpecialty = (MasSpecialty) masSpecialtyRepository.getCurrentSession().get(MasSpecialty.class,1);
		masSpecialtyRepository.getCurrentSession().delete(masSpecialty);
	}

	
	
	

	
	@Test
	public void findByIdMasSpecialty(){
		
		MasSpecialty masSpecialty = (MasSpecialty) masSpecialtyRepository.getCurrentSession().get(MasSpecialty.class, 1);		
		int id = masSpecialty.getId();
		Assert.assertEquals(1, id);
		
	}

}
