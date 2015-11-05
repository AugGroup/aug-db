package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.ReportReservationDto;
import com.aug.hrdb.dto.ReservationDto;
import com.aug.hrdb.entities.Reservation;

public interface ReservationService {
	public List<Reservation> findAll();
	public Reservation findById(Integer Id);
	public void deleteById(Integer id);
	public void update(Reservation reservation);
	public void delete(Reservation reservation);
	public void create(Reservation reservation);
	public List<ReservationDto> findByDateRange(String start, String end);
	public ReservationDto findReservationById(Integer id);
	public List<ReservationDto> searchReservation(String reservationBy, Integer masDivision, Integer masReservationType);

	public List<ReportReservationDto> findReservation(Integer roomId,Integer reservationTypeId, Integer divisionId,String reservationBy);

	public List<ReservationDto> findByTimestamp(String newTime, Integer roomId);
	
	public List<ReservationDto> findByBetween(String start, String end, Integer roomId);

	public List<ReservationDto> filterReservation(String start, String end, Integer roomId, Integer reservationTypeId, Integer divisionId, String reserveBy); 
	
}
