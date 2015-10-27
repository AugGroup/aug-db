package services;

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
import com.aug.hrdb.entities.Reservation;
import com.aug.hrdb.entities.Room;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.ReservationService;
import com.aug.hrdb.services.RoomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class ReservationServiceTest {
	@Autowired 
	private ReservationService reservationService ;
	
	@Autowired 
	private RoomService roomService ;
	
	@Autowired 
	private EmployeeService employeeService ;
	
	private Reservation reservation;
	
	
	@Before
	public void setUp(){
	Employee employee = employeeService.findById(1);
	reservation = new Reservation();
	reservation.setDescription("meeting");
	reservation.setEmployee(employee);
	reservation.setDateReservation(new Date());
	reservation.setStartTime(new Date());
	reservation.setEndTime(new Date());
	reservation.setAuditFlag("C");
	reservation.setCreatedBy(1);
	reservation.setCreatedTimeStamp(Calendar.getInstance().getTime());
	
	Room room = new Room();
	room.setName("room1");
	room.setCapacity(3);
	room.setDescription("meeting");
	room.setAuditFlag("C");
	room.setCreatedBy(1);
	room.setCreatedTimeStamp(Calendar.getInstance().getTime());
	roomService.create(room);
	reservation.setRoom(room);
	
	}
	
	@Test
	public void testInsertReservationService() throws Exception { 
		
		reservationService.create(reservation);
		Integer id = reservation.getId();
		Reservation result = reservationService.findById(id);
		assertThat(result.getRoom().getName(), is("room1"));
				
		
	}
	
	@Test
	public void testUpdateReservationService() throws Exception {
		reservationService.create(reservation);
		Integer id = reservation.getId();
		
		Reservation updateReservation = reservationService.findById(id);
		updateReservation.getRoom().setName("room2");
		reservationService.update(updateReservation);
		
		Reservation result = reservationService.findById(id);
		assertThat(result.getRoom().getName(), is("room2"));
				
	}
	
	@Test
	public void testDeleteByIdReservationService() throws Exception {
		reservationService.create(reservation);
		Integer id = reservation.getId();
		
		reservationService.deleteById(id);
		Reservation result = reservationService.findById(id);
		assertNull(result);
	}
	
	@Test
	
	public void testDeleteReservationService() throws Exception {
		reservationService.create(reservation);
		Integer id = reservation.getId();
		
		reservationService.delete(reservation);
		Reservation result = reservationService.findById(id);
		assertNull(result);
	}
	@Test
	public void testFindByIdReservationService() throws Exception {
		reservationService.create(reservation);
		Integer id = reservation.getId();
		Reservation result = reservationService.findById(id);
		assertThat(result.getRoom().getName(),is("room1"));

		
	}
	@Test
	public void testfindAllReservationService(){	
		reservationService.create(reservation);
		List<Reservation> reservations = reservationService.findAll();
		Assert.assertEquals(1, reservations.size());
	}
}

