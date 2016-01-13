package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.ReportReservationDto;
import com.aug.hrdb.dto.ReservationDto;
import com.aug.hrdb.entities.Reservation;

public interface ReservationService {

  List<Reservation> findAll();

  Reservation findById(Integer Id);

  void deleteById(Integer id);

  void update(Reservation reservation);

  void delete(Reservation reservation);

  void create(Reservation reservation);

  List<ReservationDto> findByDateRange(String start, String end);

  ReservationDto findReservationById(Integer id);

  List<ReservationDto> searchReservation(String reservationBy, Integer masDivision, Integer masReservationType);

  List<ReportReservationDto> findReservation(Integer roomId, Integer reservationTypeId, Integer divisionId, String reservationBy);

  List<ReservationDto> findByTimestamp(String newTime, Integer roomId);

  List<ReservationDto> findByBetween(String start, String end, Integer roomId);

  List<ReservationDto> filterReservation(String start, String end, Integer roomId, Integer reservationTypeId, Integer divisionId, String reserveBy);

}