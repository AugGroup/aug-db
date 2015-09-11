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
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.AbilityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AbilityRepositoryTest {

	@Autowired AbilityRepository abilityRepository;
	
	@Test
	@Rollback(false)
	public void createAbility(){
		
		
		Employee employee=new Employee();
		employee.setId(1);
		
		MasSpecialty masspecialty=new MasSpecialty();
		masspecialty.setId(1);
		masspecialty.setName("JAVA");
		
		Ability ability=new Ability();
		ability.setRank(10);
		ability.setAuditFlag("C");
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
		Ability ability=(Ability)abilityRepository.getCurrentSession().get(Ability.class,2);
		ability.setRank(2);
		abilityRepository.getCurrentSession().update(ability);
	
	}
	*/
	/*@Test
	@Rollback(false)
	public void deleteAbility(){
	
		Ability ability = (Ability) abilityRepository.getCurrentSession().get(Ability.class,1);
		abilityRepository.getCurrentSession().delete(ability);
	}
	*/
	
	/*
	@Test
	public void listAbility(){
		
		Criteria c = abilityRepository.getCurrentSession().createCriteria(Ability.class);
		List<Ability> AbilityList = c.list();
		Assert.assertEquals(1, AbilityList.size());
		
	}
	*/
	
/*	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void findAllAbility(){
		
		Criteria c = abilityRepository.getCurrentSession().createCriteria(Ability.class);
		List<Ability> AbilityList = c.list();
		Assert.assertEquals(2, AbilityList.size());
		
		
	}
	*/
}
