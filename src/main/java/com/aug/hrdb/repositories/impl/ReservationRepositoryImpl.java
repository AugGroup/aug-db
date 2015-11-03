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
		public List<ReservationDto> findByTimestamp(String newTime) {
			// TODO Auto-generated method stub
			Query query = getCurrentSession()
					.getNamedQuery("GET_RESERVATION_BY_TIMESTAMP")
					.setParameter("NEW", newTime);
			List<ReservationDto> list = query.list();
			System.out.println(list.toString());
			return list;

		}
		public List<ReportReservationDto> findReservation(Integer roomId,Integer reservationTypeId, Integer divisionId,String reservationBy) {
			Query query = getCurrentSession().getNamedQuery("REPORT_RESERVATION");	
			String queryStr = query.getQueryString();
			
			if (roomId > 0) {
				queryStr = query.getQueryString();
				queryStr += " AND room.ID = :ROOMID ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportReservationDto.class);
				
			}
			if (reservationTypeId > 0) {
				queryStr = query.getQueryString();
				queryStr += " AND reservation.ID = :RESERVATIONTYPEID ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportReservationDto.class);
			}
			if (divisionId > 0) {
				queryStr = query.getQueryString();
				queryStr += " AND division.ID = :DIVISIONID";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportReservationDto.class);
			}
			
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportReservationDto.class);
			if (roomId > 0) {
				query.setParameter("ROOM_ID", roomId);
			}
			if (reservationTypeId > 0) {
				query.setParameter("RESERVATION_TYPE_ID", reservationTypeId);
			}
			if (divisionId > 0) {
				query.setParameter("DIVISION_ID", divisionId);
			}
			
			query.setParameter("RESERVATION_BY", "%" + reservationBy + "%");
			
			List<ReportReservationDto> results = query.list();
	
			return results;
		}
}
