package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.LoginForgotDto;
import com.aug.hrdb.entities.Login;

public interface LoginService {

  void create(Login login);

  void update(Login login);

  void delete(Login login);

  Login find(Integer id);

  List<Login> findAll();

  void deleteById(Integer id);

  Login findByUserName(String name);

  Login searchEmpIdToLogin();

  LoginForgotDto findPasswordByEmail(String email);

}