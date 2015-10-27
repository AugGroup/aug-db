package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aug.hrdb.entities.Reservation;
import com.aug.hrdb.repositories.ReservationRepository;
import com.aug.hrdb.services.ReservationService;


@Service(value="reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}
	
	@Override
	public Reservation findById(Integer Id) {
		
		return  reservationRepository.find(Id);
	}

	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		reservationRepository.deleteById(id);

	}

	@Override
	public void update(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository.update(reservation);
	}

	@Override
	public void delete(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository.delete(reservation);
	}

	@Override
	public void create(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository.create(reservation);
	}
}
