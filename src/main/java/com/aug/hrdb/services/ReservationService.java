package com.aug.hrdb.services;

import java.util.List;
import com.aug.hrdb.entities.Reservation;

public interface ReservationService {
	public List<Reservation> findAll();
	public Reservation findById(Integer Id);
	public void deleteById(Integer id);
	public void update(Reservation reservation);
	public void delete(Reservation reservation);
	public void create(Reservation reservation);
}
