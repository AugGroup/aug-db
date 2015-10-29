package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.ReservationDto;
import com.aug.hrdb.entities.Reservation;

public interface ReservationRepository  extends GenericRepository<Reservation, Integer>{

	List<ReservationDto> findByDateRange(String start, String end);

    ReservationDto findReservationById(Integer id);

	
}
 
