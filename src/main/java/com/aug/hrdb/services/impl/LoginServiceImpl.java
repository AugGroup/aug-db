package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.LoginForgotDto;
import com.aug.hrdb.entities.Login;
import com.aug.hrdb.repositories.LoginRepository;
import com.aug.hrdb.services.LoginService;

@Transactional
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {

  @Autowired
  private LoginRepository loginRepository;

  @Override
  public void create(Login login) {
    loginRepository.create(login);
  }

  @Override
  public void update(Login login) {
    loginRepository.update(login);
  }

  @Override
  public void delete(Login login) {
    loginRepository.delete(login);
  }

  @Override
  public Login find(Integer id) {
    return loginRepository.find(id);
  }

  @Override
  public List<Login> findAll() {
    return loginRepository.findAll();
  }

  @Override
  public Login findByUserName(String name) {
    return loginRepository.findByUserName(name);
  }

  @Override
  public LoginForgotDto findPasswordByEmail(String email) {
    return loginRepository.findPasswordByEmail(email);
  }

  @Override
  public void deleteById(Integer id) {
    loginRepository.deleteById(id);
  }

  @Override
  public Login searchEmpIdToLogin() {
    return loginRepository.searchEmpIdToLogin();
  }

}