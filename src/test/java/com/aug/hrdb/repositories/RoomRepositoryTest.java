package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.entities.Room;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class RoomRepositoryTest {

  @Autowired
  private RoomRepository roomRepository;

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
    roomRepository.create(room);
    
  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(roomRepository);
  }

  @Test
  public void testFindWithRoomRepositoryShouldReturnRoomThatSetup() throws Exception {
    Room result = roomRepository.find(room.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("NAME"));
    assertThat(result.getColor(), is("#CCCCCC"));
    assertThat(result.getDescription(), is("DESC"));

  }

  @Test
  public void testFindAllWithRoomRepositoryShouldReturnListOfAllRoom() throws Exception {
    List<Room> result = roomRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithRoomRepositoryShouldReturnRoomThatUpdate() throws Exception {
    Room update = roomRepository.find(room.getId());
    assertThat(update.getName(), is("NAME"));
    assertThat(update.getColor(), is("#CCCCCC"));
    assertThat(update.getDescription(), is("DESC"));

    update.setColor("#CC9999");
    roomRepository.update(update);

    Room result = roomRepository.find(update.getId());
    assertThat(result.getColor(), is("#CC9999"));

  }

  @Test
  public void testDeleteWithRoomRepositoryShouldNotFindThatRoom() throws Exception {
    Room delete = roomRepository.find(room.getId());
    roomRepository.delete(delete);

    Room result = roomRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithRoomRepositoryShouldNotFindThatRoom() throws Exception {
    Room delete = roomRepository.find(room.getId());
    roomRepository.deleteById(delete.getId());

    Room result = roomRepository.find(delete.getId());
    assertNull(result);

  }
  
}