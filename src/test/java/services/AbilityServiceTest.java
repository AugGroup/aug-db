/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.services.AbilityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AbilityServiceTest {
	
	@Autowired AbilityService abilityService;
	
	@Test
	@Rollback(false)
	public void createAbility() {
		Ability ability=new Ability();
		ability.setRank(10);
		abilityService.create(ability);
		
	}
	
	/*@Test
	@Rollback(false)
	public void updateAbility() {
	
	Ability ability=(Ability)abilityService.find(2);
	ability.setRank(2);
	abilityService.update(ability);
	}
*/
	
	/*@Test
	public void deleteAbility(){
		Ability ability=abilityService.find(3);
		abilityService.delete(ability);
	}
	*/
	
	/*@Test
	public void findAllDataAbility(){

		List<Ability> ability = abilityService.findAll();
		Assert.assertEquals(2, ability.size());
	}
	*/
	
	
/*	@Test
	public void findDatabyIdAbility(){

		Ability ability =(Ability) abilityService.find(2);
		int id = ability.getId();
		Assert.assertEquals(2,id);
		
		
		
	}*/
	
}
