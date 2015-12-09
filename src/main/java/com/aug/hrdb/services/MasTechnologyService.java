package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasTechnology;

public interface MasTechnologyService {
	
	public void create(MasTechnology masTechnology);
	public void update(MasTechnology masTechnology);
	public void delete(MasTechnology masTechnology);
	public MasTechnology findById(Integer Id);
	public List<MasTechnology> findAll();
	public void deleteById(Integer id);

}