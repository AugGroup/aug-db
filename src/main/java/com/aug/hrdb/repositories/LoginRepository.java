package com.aug.hrdb.repositories;

import com.aug.hrdb.dto.LoginForgotDto;
import com.aug.hrdb.entities.Login;

public interface LoginRepository extends GenericRepository<Login, Integer> {

  Login findByUserName(String name);

  Login searchEmpIdToLogin();

  LoginForgotDto findPasswordByEmail(String email);

}