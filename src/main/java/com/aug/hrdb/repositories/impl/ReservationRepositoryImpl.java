package com.aug.hrdb.repositories.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.dto.ReportReservationDto;
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
			Query query = getCurrentSession().getNamedQuery("GET_RESERVATION_ID");
			query.setParameter("SEARCH_ID", id);
			List<ReservationDto> reserv = query.list();
			return reserv.get(0);
		}

		@Override
		public List<ReservationDto> searchReservation(Reservation reservation) {
			// TODO Auto-generated method stub
			Query query = getCurrentSession().getNamedQuery("SEARCH_RESERVATION");
			query.setParameter("RESERVATION_TYPE", reservation.getMasreservationtype().getId());
			query.setParameter("DIVISION_ID", reservation.getMasDivision().getId());
			query.setParameter("RESERVED_BY", reservation.getReservationBy());
			List<ReservationDto> reservationDtos = query.list();
			return reservationDtos;
		}
		public List<ReservationDto> findByTimestamp(String newTime, Integer roomId) {
			// TODO Auto-generated method stub
			Query query = getCurrentSession()
					.getNamedQuery("GET_RESERVATION_BY_TIMESTAMP")
					.setParameter("NEW", newTime)
					.setParameter("ROOM", roomId);
			List<ReservationDto> list = query.list();
			System.out.println(list.toString());
			return list;

		}

		public List<ReportReservationDto> findReservation(Integer roomId,Integer reservationTypeId, Integer divisionId,String reservationBy) {
			Query query = getCurrentSession().getNamedQuery("REPORT_RESERVATION");	
			String queryStr = query.getQueryString();
			System.out.println(">>>>>>>"+queryStr);
			
			List<ReportReservationDto> results = query.list();
			System.out.println(">>>>>>>"+results);
			return results;
		}


		@Override
		public List<ReservationDto> findByBetween(String start, String end, Integer roomId) {
			Query query = getCurrentSession()
					.getNamedQuery("GET_BETWEEN_RESERVATION")
					.setParameter("START", start)
					.setParameter("END", end)
					.setParameter("ROOM", roomId);
			List<ReservationDto> list = query.list();
			//System.out.println(list.toString());
			return list;
		}

}
