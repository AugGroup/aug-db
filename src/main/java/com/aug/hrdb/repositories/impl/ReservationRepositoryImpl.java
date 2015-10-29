package com.aug.hrdb.repositories.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ReservationDto;
import com.aug.hrdb.entities.Reservation;
import com.aug.hrdb.repositories.ReservationRepository;

@Repository("reservationRepository")
@Transactional
public class ReservationRepositoryImpl extends GenericRepositoryImpl<Reservation, Integer> implements ReservationRepository {

		public ReservationRepositoryImpl() {
		super(Reservation.class);
// TODO Auto-generated constructor stub
		}

		@Override
		public List<ReservationDto> findByDateRange(String start, String end) {
			// TODO Auto-generated method stub
			
			Query query = getCurrentSession()
					.getNamedQuery("GET_RESERVATIONS")
					.setParameter("START", start)
					.setParameter("END", end);
			List<ReservationDto> list = query.list();
			System.out.println(list.toString());
			return list;
		}

		@Override
		public ReservationDto findReservationById(Integer id) {
			// TODO Auto-generated method stub
			System.out.println("in repo");
			Query query = getCurrentSession().getNamedQuery("GET_RESERVATION_ID");
			query.setParameter("SEARCH_ID", id);
			List<ReservationDto> reserv = query.list();
			System.out.println("repo : "+reserv.get(0).toString());
			System.out.println("after query");
			return reserv.get(0);
		}
}
