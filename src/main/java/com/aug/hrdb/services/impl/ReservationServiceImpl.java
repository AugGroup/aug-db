package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ReportReservationDto;
import com.aug.hrdb.dto.ReservationDto;
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

	@Override
	public List<ReservationDto> findByDateRange(String start, String end) {
		// TODO Auto-generated method stub
		return reservationRepository.findByDateRange(start, end);
	}

	@Override
	public ReservationDto findReservationById(Integer id) {
		// TODO Auto-generated method stub
		return reservationRepository.findReservationById(id);
	}

	@Override
	public List<ReservationDto> searchReservation(String reservationBy,Integer masDivision, Integer masReservationType) {
		// TODO Auto-generated method stub
		System.out.println( "do search");
		return reservationRepository.searchReservation(reservationBy,masDivision,masReservationType);
		
	}

	public List<ReservationDto> findByTimestamp(String newTime, Integer roomId) {
		// TODO Auto-generated method stub
		return reservationRepository.findByTimestamp(newTime,roomId);

	}

	public List<ReportReservationDto> findReservation(Integer roomId,Integer reservationTypeId, Integer divisionId, String reservationBy) {
		return reservationRepository.findReservation(roomId, reservationTypeId, divisionId, reservationBy);

	}

	@Override
	public List<ReservationDto> findByBetween(String start, String end, Integer roomId) {
		// TODO Auto-generated method stub
		return reservationRepository.findByBetween(start, end,roomId);

	}

	@Override
	public List<ReservationDto> filterReservation(String start, String end, Integer roomId, Integer reservationTypeId,
			Integer divisionId, String reserveBy) {
		// TODO Auto-generated method stub
		return reservationRepository.filterReservation(start,end,roomId,reservationTypeId,divisionId,reserveBy);
	}
}
