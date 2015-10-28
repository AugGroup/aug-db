package com.aug.hrdb.repositories.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.ReservationDto;
import com.aug.hrdb.entities.Reservation;
import com.aug.hrdb.repositories.ReservationRepository;

@Repository("reservationRepository")
public class ReservationRepositoryImpl extends GenericRepositoryImpl<Reservation, Integer> implements ReservationRepository {

		public ReservationRepositoryImpl() {
		super(Reservation.class);
// TODO Auto-generated constructor stub
		}

		@Override
		public List<ReservationDto> findByDateRange(String start, String end) {
			// TODO Auto-generated method stub
			
			Query query = getCurrentSession()
//					.createSQLQuery("select ID as id, START_TIME as start, END_TIME as end, DESCRIPTION as title "+
//					"from reservation r WHERE r.`START_TIME` BETWEEN STR_TO_DATE('"+start+"','%Y-%m-%d') and STR_TO_DATE('"+end+"','%Y-%m-%d');");
					.getNamedQuery("GET_RESERVATIONS")
					.setParameter("START", start)
					.setParameter("END", end);

		
			
			List<ReservationDto> list = query.list();
			System.out.println(list.toString());
			return list;
		}
}
