package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.ReportReservationDto;
import com.aug.hrdb.dto.ReservationDto;
import com.aug.hrdb.entities.Reservation;

public interface ReservationRepository  extends GenericRepository<Reservation, Integer>{

	List<ReservationDto> findByDateRange(String start, String end);

    ReservationDto findReservationById(Integer id);

	List<ReservationDto> searchReservation(Reservation reservation);

    List<ReservationDto> findByTimestamp(String newTime);
    
	List<ReportReservationDto> findReservation(Integer roomId,Integer reservationTypeId,Integer divisionId,String reservationBy);

}
 
