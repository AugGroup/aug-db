package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Room;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class RoomServiceTest {

  @Autowired
  private RoomService roomService;

  private Room room;

  @Before
  public void setUp() throws Exception {
    //create room
    room = new Room();
    room.setAuditFlag("C");
    room.setCreatedBy(1);
    room.setCreatedTimeStamp(Calendar.getInstance().getTime());
    room.setCapacity(10);
    room.setName("NAME");
    room.setColor("#CCCCCC");
    room.setDescription("DESC");
    roomService.create(room);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(roomService);
  }

  @Test
  public void testFindWithRoomServiceShouldReturnRoomThatSetup() throws Exception {
    Room result = roomService.findById(room.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("NAME"));
    assertThat(result.getColor(), is("#CCCCCC"));
    assertThat(result.getDescription(), is("DESC"));

  }

  @Test
  public void testFindAllWithRoomServiceShouldReturnListOfAllRoom() throws Exception {
    List<Room> result = roomService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithRoomServiceShouldReturnRoomThatUpdate() throws Exception {
    Room update = roomService.findById(room.getId());
    assertThat(update.getName(), is("NAME"));
    assertThat(update.getColor(), is("#CCCCCC"));
    assertThat(update.getDescription(), is("DESC"));

    update.setColor("#CC9999");
    roomService.update(update);

    Room result = roomService.findById(update.getId());
    assertThat(result.getColor(), is("#CC9999"));

  }

  @Test
  public void testDeleteWithRoomServiceShouldNotFindThatRoom() throws Exception {
    Room delete = roomService.findById(room.getId());
    roomService.delete(delete);

    Room result = roomService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithRoomServiceShouldNotFindThatRoom() throws Exception {
    Room delete = roomService.findById(room.getId());
    roomService.deleteById(delete.getId());

    Room result = roomService.findById(delete.getId());
    assertNull(result);

  }

}