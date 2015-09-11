/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;







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

import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.AbilityRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasSpecialtyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AbilityRepositoryTest {

	@Autowired AbilityRepository abilityRepository;
	@Autowired EmployeeRepository employeeRepository;
	@Autowired MasSpecialtyRepository MasSpecialtyRepository;
	
	@Test
	@Rollback(false)
	public void createAbility(){
		
		
		Employee employee=employeeRepository.find(1);
		MasSpecialty masspecialty=MasSpecialtyRepository.find(1);
		

		
		Ability ability=new Ability();
		ability.setRank(10);
		ability.setAuditFlag("C");
		ability.setCreatedBy(1);
		ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
		ability.setEmployee(employee);
		ability.setMasspecialty(masspecialty);
		abilityRepository.create(ability);
	
	}
	
	
	
	/*@Test
	@Rollback(false)
	public void updateAbility(){
		Ability ability= abilityRepository.find(5);
		ability.setRank(2);
		
		abilityRepository.update(ability);
	
	}*/
	
	/*@Test
	@Rollback(false)
	public void deleteAbility(){
	
		Ability ability = (Ability) abilityRepository.getCurrentSession().get(Ability.class,5);
		abilityRepository.getCurrentSession().delete(ability);
	}
	*/
	
	
	
	
	
	/*@Test
	public void listAbility(){
		
		Criteria c = abilityRepository.getCurrentSession().createCriteria(Ability.class);
		List<Ability> AbilityList = c.list();
		Assert.assertEquals(1, AbilityList.size());
		
	}*/
	
	/*
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void findAllAbility(){
		
		Criteria c = abilityRepository.getCurrentSession().createCriteria(Ability.class);
		List<Ability> AbilityList = c.list();
		Assert.assertEquals(1, AbilityList.size());
		
		
	}*/
	
}
