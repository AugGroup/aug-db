/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
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
import com.aug.hrdb.repositories.MasRoleRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasRoleRepositoryTest {

	@Autowired MasRoleRepository masRoleRepository;
	int id;
	
	@Before
	public void setMasRole(){
		MasRole masRole = new MasRole();
		masRole.setType("Admin");
		masRole.setIsActive(true);
		masRole.setAuditFlag("C");
		masRole.setCreatedBy(1);
		masRole.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masRoleRepository.create(masRole);
		
		id=masRole.getId();
	}
	
	@Test
	@Rollback(true)
	public void create() {

		MasRole masRole = new MasRole();
		masRole.setType("User");
		masRole.setIsActive(true);
		masRole.setAuditFlag("C");
		masRole.setCreatedBy(1);
		masRole.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masRoleRepository.getCurrentSession().save(masRole);

	}

	@Test
	@Rollback(true)
	public void update() {

		MasRole masRole = (MasRole) masRoleRepository.getCurrentSession().get(
				MasRole.class, id);
		masRole.setName("HR");

		masRoleRepository.getCurrentSession().update(masRole);
	}

	@Test
	@Rollback(true)
	public void delete() {

		MasRole masRole = (MasRole) masRoleRepository.getCurrentSession().get(
				MasRole.class, id);

		masRoleRepository.getCurrentSession().delete(masRole);
	}

	@SuppressWarnings("unchecked")
	@Test
	@Rollback(true)
	public void list() {

		Criteria c = masRoleRepository.getCurrentSession().createCriteria(
				MasRole.class);
		List<MasRole> masRoles = c.list();
		Assert.assertEquals(4, masRoles.size());

	}
	
	@Test
	@Rollback(true)
	public void findById(){
		MasRole masRole = masRoleRepository.find(id);
		int idMasRole = masRole.getId();
		Assert.assertEquals(idMasRole, id);
	}
	
}
