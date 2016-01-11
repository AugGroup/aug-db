package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.LoginForgotDto;
import com.aug.hrdb.entities.Login;
import com.aug.hrdb.repositories.LoginRepository;

@SuppressWarnings("unchecked")
@Repository(value = "loginRepository")
public class LoginRepositoryImpl extends GenericRepositoryImpl<Login, Integer> implements LoginRepository {

  public LoginRepositoryImpl() {
    super(Login.class);
  }

  @Override
  public Login findByUserName(String name) {
    Criteria c = getCurrentSession().createCriteria(Login.class);
    c.add(Restrictions.eq("username", name));
    List<Login> hlist = c.list();

    if (hlist.size() > 0)
      return hlist.get(0);
    else
      return null;

  }

  @Override
  public Login searchEmpIdToLogin() {
    Query query = getCurrentSession().getNamedQuery("searchIdEmptoLogin");
    List<Login> login = query.list();

    return login.get(0);

  }

  @Override
  public LoginForgotDto findPasswordByEmail(String email) {
    Query query = getCurrentSession().getNamedQuery("searchPasswordByEmail");
    query.setParameter("EMAIL", email);
    List<LoginForgotDto> loginDto = query.list();

    return loginDto.get(0);

  }

}