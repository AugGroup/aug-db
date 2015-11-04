package repositories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasReservationType;
import com.aug.hrdb.entities.Reservation;
import com.aug.hrdb.entities.Room;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasReservationTypeRepository;
import com.aug.hrdb.repositories.ReservationRepository;
import com.aug.hrdb.repositories.RoomRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class ReservationRepositoryTest {
	
	@Autowired 
	private ReservationRepository reservationRepository ;
	
	@Autowired 
	private RoomRepository roomRepository ;
	
	@Autowired 
	private MasReservationTypeRepository masReservationTypeRepository ;
	
	@Autowired 
	private EmployeeRepository employeeRepository ;
	
	private Reservation reservation;
	
	int id;
	
	@Before
	public void setUp(){
	Employee employee = employeeRepository.find(1);
	reservation = new Reservation();
	reservation.setDescription("meeting");
	reservation.setEmployee(employee);
	reservation.setDateReservation(new Date());
	reservation.setStart(new Date());
	reservation.setEnd(new Date());/*
	reservation.setAuditFlag("C");
	reservation.setCreatedBy(1);
	reservation.setCreatedTimeStamp(Calendar.getInstance().getTime());*/
	
	 MasReservationType masReservationType = new MasReservationType();
	 masReservationType.setName("meeting");
	 masReservationType.setIsactive(true);
	 masReservationType.setCode("01");
	 masReservationType.setAuditFlag("C");
	 masReservationType.setCreatedBy(1);
	 masReservationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
	 masReservationTypeRepository.create(masReservationType);
	 MasReservationType masReservType = masReservationTypeRepository.find(1);

	Room room = new Room();
	room.setName("room1");
	room.setCapacity(3);
	room.setDescription("meeting");
	room.setAuditFlag("C");
	room.setCreatedBy(1);
	room.setCreatedTimeStamp(Calendar.getInstance().getTime());
	roomRepository.create(room);
	reservation.setRoom(room);
	reservation.setMasreservationtype(masReservType);
	reservationRepository.create(reservation);
	id = reservation.getId();
	}
	
	@Test
	public void testInsertReservationRepository() throws Exception { 
		
		Reservation result = reservationRepository.find(id);
		assertThat(result.getRoom().getName(), is("room1"));
			
	}
	
	@Test
	public void testUpdateReservationRepository() throws Exception {
		Reservation updateReservation = reservationRepository.find(id);
		updateReservation.getRoom().setName("room2");
		reservationRepository.update(updateReservation);
		
		Reservation result = reservationRepository.find(id);
		assertThat(result.getRoom().getName(), is("room2"));
				
	}
	
	@Test
	public void testDeleteByIdReservationRepository() throws Exception {
		reservationRepository.deleteById(id);
		Reservation result = reservationRepository.find(id);
		assertNull(result);
	}
	
	@Test
	
	public void testDeleteReservationRepository() throws Exception {
		reservationRepository.delete(reservation);
		Reservation result = reservationRepository.find(id);
		assertNull(result);
	}
	@Test
	public void testFindByIdReservationRepository() throws Exception {
		Integer id = reservation.getId();
		Reservation result = reservationRepository.find(id);
		assertThat(result.getRoom().getName(),is("room1"));

	}
	@Test
	public void testfindAllReservationRepository(){	
		List<Reservation> reservations = reservationRepository.findAll();
		Assert.assertEquals(5, reservations.size());
	}
}
