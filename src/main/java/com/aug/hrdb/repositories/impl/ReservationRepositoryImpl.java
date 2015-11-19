
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
					//.setParameter("ROOMID", roomId);
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
		public List<ReservationDto> searchReservation(String reservationBy, Integer masDivision, Integer masReservationType) {
			// TODO Auto-generated method stub
			System.out.println("reservationBy : "+reservationBy+"\n masDivision : "+masDivision+"\n masReservationType : "+masReservationType);
			Query query = getCurrentSession().getNamedQuery("SEARCH_RESERVATION");	
			String queryStr = query.getQueryString();

			if (reservationBy != null && !reservationBy.isEmpty() ) {
				queryStr = query.getQueryString();
				queryStr += " AND CONCAT(FIRSTNAME_EN,' ',LASTNAME_EN) LIKE :RESERVATIONBY ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
				query.setParameter("RESERVATIONBY", "'%" + reservationBy + "%'");
			}
			
			if (masReservationType != null) {
				queryStr = query.getQueryString();
				queryStr += " AND r.RESERVATION_TYPE_ID = :RESERVATION_TYPEID ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
				query.setParameter("RESERVATION_TYPEID", masReservationType);
			}
			if (masDivision != null) {
				queryStr = query.getQueryString();
				queryStr += " AND r.DIVISION_ID = :DIVISIONID";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
				query.setParameter("DIVISIONID", masDivision);
			}
			
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
			
			if (reservationBy != null && !reservationBy.isEmpty()) {
				query.setParameter("RESERVATIONBY", "%" + reservationBy + "%");
			}
			if (masReservationType != null) {
				query.setParameter("RESERVATION_TYPEID", masReservationType);
			}
			if (masDivision != null) {
				query.setParameter("DIVISIONID", masDivision);
			}
			List<ReservationDto> reservationDtos = query.list();
			System.out.println("query string : "+queryStr);
			System.out.println(reservationDtos.toString());
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

			if (roomId > 0) {
				queryStr = query.getQueryString();
				queryStr += " AND room.ID = :ROOM_ID ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportReservationDto.class);
			}
			if (reservationTypeId > 0) {
				queryStr = query.getQueryString();
				queryStr += " AND masreservationtype.ID = :RESERVATION_TYPE_ID ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportReservationDto.class);
			}
			if (divisionId > 0) {
				queryStr = query.getQueryString();
				queryStr += " AND masdivision.ID = :DIVISION_ID";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportReservationDto.class);
			}
			
			if (roomId > 0) {
				query.setParameter("ROOM_ID", roomId);
			}
			if (reservationTypeId > 0) {
				query.setParameter("RESERVATION_TYPE_ID", reservationTypeId);
			}
			if (divisionId > 0) {
				query.setParameter("DIVISION_ID", divisionId);
			}
			
			query.setParameter("FIRST_NAME", "%" + reservationBy + "%");
			List<ReportReservationDto> results = query.list();
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

		@Override
		public List<ReservationDto> filterReservation(String start, String end, Integer roomId,
				Integer reservationTypeId, Integer divisionId, String reserveBy) {
			// TODO Auto-generated method stub
			System.out.println("reserveBy : " + reserveBy);
			Query query = getCurrentSession().getNamedQuery("FILTER_RESERVATIONS");
			String queryStr = query.getQueryString();
			if (roomId != null) {
				queryStr = query.getQueryString();
				queryStr += " AND ROOM_ID =:ROOMSID ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
				query.setParameter("ROOMSID", roomId);
			}
			if (reservationTypeId != null) {
				queryStr = query.getQueryString();
				queryStr += " AND RESERVATION_TYPE_ID = :RESERVATION_TYPE ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
				query.setParameter("RESERVATION_TYPE", reservationTypeId);
			}
			if (divisionId != null) {
				queryStr = query.getQueryString();
				queryStr += " AND DIVISION_ID = :DIVISIONID";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
				query.setParameter("DIVISIONID", divisionId);
			}
			if (reserveBy != null && !reserveBy.isEmpty()) {
				queryStr = query.getQueryString();
				queryStr += " AND CONCAT(FIRSTNAME_EN,' ',LASTNAME_EN) LIKE :RESERVED_BY ";
				query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
				query.setParameter("RESERVED_BY", "%"+reserveBy+"%");
			}
			
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReservationDto.class);
			query.setParameter("START", start);
			query.setParameter("END", end);
			if (roomId != null) {
				query.setParameter("ROOMSID", roomId);
			}
			if (reservationTypeId != null) {
				query.setParameter("RESERVATION_TYPE", reservationTypeId);
			}
			if (divisionId != null) {
				query.setParameter("DIVISIONID", divisionId);
			}
			if (reserveBy != null && !reserveBy.isEmpty()) {
				query.setParameter("RESERVED_BY", "%"+reserveBy+"%");
			}

			List<ReservationDto> list = query.list();
			System.out.println(list.toString());
			return list;
		}
}
