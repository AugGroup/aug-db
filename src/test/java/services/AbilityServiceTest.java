/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.services.AbilityService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasSpecialtyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AbilityServiceTest {
	
	@Autowired AbilityService abilityService;
	@Autowired EmployeeService employeeService;
	@Autowired MasSpecialtyService masSpecialtyService;
	
	@Test
	@Rollback(false)
	public void createAbility() {
		
		Employee employee=employeeService.findById(1);
		MasSpecialty masSpecialty=masSpecialtyService.findById(1);
		Ability ability=new Ability();
		ability.setRank(10);
		ability.setAuditFlag("C");
		ability.setCreatedBy(1);
		ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
		ability.setEmployee(employee);
		ability.setMasspecialty(masSpecialty);
		abilityService.create(ability);
		
	}
	
	/*@Test
	@Rollback(false)
	public void updateAbility() {
	
	Ability ability=(Ability)abilityService.find(1);
	ability.setRank(2);
	abilityService.update(ability);
	}*/

/*	
	@Test
	public void deleteAbility(){
		Ability ability=abilityService.find(1);
		abilityService.delete(ability);
	}*/
	
	/*
	@Test
	public void findAllDataAbility(){

		List<Ability> ability = abilityService.findAll();
		Assert.assertEquals(1, ability.size());
	}*/
	
	
	/*
	@SuppressWarnings("deprecation")
	@Test
	public void findDatabyIdAbility(){

		Ability ability =(Ability) abilityService.find(1);
		int id = ability.getId();
		Assert.assertEquals(1,id);
		
		
		
	}*/
	
}
