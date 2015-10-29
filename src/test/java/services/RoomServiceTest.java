package services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
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

import com.aug.hrdb.entities.Room;
import com.aug.hrdb.services.ReservationService;
import com.aug.hrdb.services.RoomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class RoomServiceTest {
	@Autowired 
	private ReservationService reservationService ;
	
	@Autowired 
	private RoomService roomService ;
	
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
		roomService.create(room);
		id = room.getId();
	}
	
	@Test
	public void testInsertRoomService() throws Exception { 
		Room result = roomService.findById(id);
		assertThat(result.getName(), is("room1"));
				
		
	}
	
	@Test
	public void testUpdateRoomService() throws Exception {
		Room updateRoom = roomService.findById(id);
		updateRoom.setName("room2");
		roomService.update(updateRoom);
		
		Room result = roomService.findById(id);
		assertThat(result.getName(), is("room2"));
				
	}
	
	@Test
	public void testDeleteByIdRoomService() throws Exception {
		roomService.deleteById(id);
		Room result = roomService.findById(id);
		assertNull(result);
	}
	
	@Test
	
	public void testDeleteRoomService() throws Exception {
		roomService.delete(room);
		Room result = roomService.findById(id);
		assertNull(result);
	}
	@Test
	public void testFindByIdRoomService() throws Exception {
		Room result = roomService.findById(id);
		assertThat(result.getName(),is("room1"));

		
	}
	@Test
	public void testfindAllReservationService(){	
		List<Room> rooms = roomService.findAll();
		Assert.assertEquals(4, rooms.size());
	}
}
