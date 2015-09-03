package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.Login;
import com.aug.hrdb.repositories.LoginRepository;


//import com.aug.hr.entity.Official;

@Repository
public class LoginRepositoryImpl extends GenericRepositoryImpl<Login, Integer> implements LoginRepository {

	public LoginRepositoryImpl() {
		super(Login.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Login findByUserName(String name) {
		 Criteria c = getCurrentSession().createCriteria(Login.class);
		 c.add(Restrictions.eq("username", name));
		 List<Login> hlist = c.list();
		 if (hlist.size() > 0) return hlist.get(0);
		 else return null;
	}

/*	@Override
	public Login deleteById(Integer id) {
		Login login = (Login) getCurrentSession().load(Login.class, id);
		getCurrentSession().delete(login);
		return login;
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public Login searhEmpIdtoLogin() {
		Query query = getCurrentSession().getNamedQuery("searchIdEmptoLogin");
		List<Login> login = query.list();
		return login.get(0);
	}

}
