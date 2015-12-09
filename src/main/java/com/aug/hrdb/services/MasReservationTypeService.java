package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasReservationType;

public interface MasReservationTypeService {
	
	public void create(MasReservationType masReservationType );
	public void update(MasReservationType masReservationType);
	public void delete(MasReservationType masReservationType);
	public MasReservationType findById(Integer Id);
	public List<MasReservationType> findAll();
	public void deleteById(Integer id);
	
}