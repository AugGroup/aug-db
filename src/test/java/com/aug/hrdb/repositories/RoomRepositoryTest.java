package com.aug.hrdb.repositories;

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
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.ReservationRepository;
import com.aug.hrdb.repositories.RoomRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class RoomRepositoryTest {
	@Autowired 
	private ReservationRepository reservationRepository ;
	
	@Autowired 
	private RoomRepository roomRepository ;
	
	private Room room;
	
	int id;
	
	@Before
	public void setUp(){
		room = new Room();
		room.setDescription("meeting");
		room.setCapacity(4);
		room.setName("room1");
		room.setAuditFlag("C");
		room.setCreatedBy(1);
		room.setCreatedTimeStamp(Calendar.getInstance().getTime());
		roomRepository.create(room);
		id = room.getId();
	}
	
	@Test
	public void testInsertRoomRepository() throws Exception { 
		Room result = roomRepository.find(id);
		assertThat(result.getName(), is("room1"));
				
	}
	
	@Test
	public void testUpdateRoomRepository() throws Exception {
		Room updateRoom = roomRepository.find(id);
		updateRoom.setName("room2");
		roomRepository.update(updateRoom);
		
		Room result = roomRepository.find(id);
		assertThat(result.getName(), is("room2"));
				
	}
	
	@Test
	public void testDeleteByIdRoomRepository() throws Exception {
		roomRepository.deleteById(id);
		Room result = roomRepository.find(id);
		assertNull(result);
	}
	
	@Test
	
	public void testDeleteRoomRepository() throws Exception {
		roomRepository.delete(room);
		Room result = roomRepository.find(id);
		assertNull(result);
	}
	@Test
	public void testFindByIdRoomRepository() throws Exception {
		Room result = roomRepository.find(id);
		assertThat(result.getName(),is("room1"));

		
	}
	@Test
	public void testfindAllReservationRepository(){	
		List<Room> rooms = roomRepository.findAll();
		Assert.assertEquals(4, rooms.size());
	}
}
