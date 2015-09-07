/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRole;
import com.aug.hrdb.services.MasRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRoleServiceTest {

	@Autowired
	private MasRoleService masRoleService;
	
	@Test
	public void create(){

		MasRole masRole = new MasRole();
		masRole.setType("User");
		masRole.setIsActive(true);
		masRoleService.create(masRole);
	}
	
//	@Test
//	public void update(){
//
//		MasRole masRole = masRoleService.find(2);
//		masRole.setType("Admin");
//		masRoleService.update(masRole);
//		
//	}
//	
//	@Test
//	public void delete(){
//
//		MasRole masRole = masRoleService.find(2);
//		masRoleService.delete(masRole);
//		
//	}
//	
//	
//	@Test
//	public void findAll(){
//
//		List<MasRole> masRole = masRoleService.findAll();
//		Assert.assertEquals(3, masRole.size());
//	}
}
