/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRole;
import com.aug.hrdb.services.MasRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRoleServiceTest {

	@Autowired private MasRoleService masRoleService;
	int id;
	
	@Before
	public void setMasRole(){
		MasRole masRole = new MasRole();
		masRole.setType("Admin");
		masRole.setIsActive(true);
		masRole.setAuditFlag("C");
		masRole.setCreatedBy(1);
		masRole.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRoleService.create(masRole);
		
		id=masRole.getId();
	}
	
	@Test
	@Rollback(true)
	public void create(){

		MasRole masRole = new MasRole();
		masRole.setType("User");
		masRole.setIsActive(true);	
		masRole.setAuditFlag("C");
		masRole.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masRole.setCreatedTimeStamp(cal.getTime());
		
		masRoleService.create(masRole);
	}
	
	@Test
	@Rollback(true)
	public void update(){

		MasRole masRole = masRoleService.find(id);
		masRole.setType("Admin");
		masRoleService.update(masRole);
		
	}
	
	@Test
	@Rollback(true)
	public void delete(){

		MasRole masRole = masRoleService.find(id);
		masRoleService.delete(masRole);
		
	}
	
	
	@Test
	@Rollback(true)
	public void findAll(){

		List<MasRole> masRole = masRoleService.findAll();
		Assert.assertEquals(4, masRole.size());
	}
	
	@Test
	@Rollback(true)
	public void findById(){
		MasRole masRole = masRoleService.find(id);
		int idMasRole = masRole.getId();
		Assert.assertEquals(idMasRole, id);
	}
}
