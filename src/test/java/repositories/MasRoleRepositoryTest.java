/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRole;
import com.aug.hrdb.repositories.MasRoleRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRoleRepositoryTest {

	@Autowired MasRoleRepository masRoleRepository;
	
	@Test
	public void create() {

		MasRole masRole = new MasRole();
		masRole.setType("User");
		masRole.setIsActive(true);

		masRoleRepository.getCurrentSession().save(masRole);

	}

//	@Test
//	public void update() {
//
//		MasRole masRole = (MasRole) masRoleRepository.getCurrentSession().get(
//				MasRole.class, 1);
//		masRole.setName("IT");
//
//		masRoleRepository.getCurrentSession().update(masRole);
//	}
//
//	@Test
//	public void Delete() {
//
//		MasRole masRole = (MasRole) masRoleRepository.getCurrentSession().get(
//				MasRole.class, 1);
//
//		masRoleRepository.getCurrentSession().delete(masRole);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	public void list() {
//
//		Criteria c = masRoleRepository.getCurrentSession().createCriteria(
//				MasRole.class);
//		List<MasRole> masRoles = c.list();
//		Assert.assertEquals(0, masRoles.size());
//
//	}
}
