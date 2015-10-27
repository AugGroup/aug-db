package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.Reservation;
import com.aug.hrdb.repositories.ReservationRepository;

@Repository("reservationRepository")
public class ReservationRepositoryImpl extends GenericRepositoryImpl<Reservation, Integer> implements ReservationRepository {

		public ReservationRepositoryImpl() {
		super(Reservation.class);
// TODO Auto-generated constructor stub
		}
}
