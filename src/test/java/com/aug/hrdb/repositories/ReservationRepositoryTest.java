package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.entities.*;
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
public class ReservationRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private MasDivisionRepository masDivisionRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private RoomRepository roomRepository;

  @Autowired
  private MasReservationTypeRepository masReservationTypeRepository;

  @Autowired
  private ReservationRepository reservationRepository;
  
  private Reservation reservation;

  @Before
  public void setUp() throws Exception {
    // create applicant
    MasCoreSkill masCoreSkill = new MasCoreSkill();
    masCoreSkill.setAuditFlag("C");
    masCoreSkill.setCreatedBy(1);
    masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masCoreSkill.setIsActive(true);
    masCoreSkill.setCode("ITS");
    masCoreSkill.setName("ITS");
    masCoreSkillRepository.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJobLevelRepository.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyRepository.create(masTechnology);

    Applicant applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setFirstNameEN("Anat");
    applicant.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
    applicant.setJoblevel(masJobLevelRepository.find(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
    applicantRepository.create(applicant);

    // create mas division
    MasDivision masDivision = new MasDivision();
    masDivision.setAuditFlag("C");
    masDivision.setCreatedBy(1);
    masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masDivision.setIsActive(true);
    masDivision.setCode("ITS");
    masDivision.setName("Integrate Technology Services");
    masDivisionRepository.create(masDivision);

    // create employee
    Employee employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeRepository.create(employee);

    //create room
    Room room = new Room();
    room.setAuditFlag("C");
    room.setCreatedBy(1);
    room.setCreatedTimeStamp(Calendar.getInstance().getTime());
    room.setCapacity(10);
    room.setName("ROOM NAME");
    room.setColor("#CCCCCC");
    room.setDescription("DESC");
    roomRepository.create(room);

    // create mas reservation type
    MasReservationType masReservationType = new MasReservationType();
    masReservationType.setName("TYPE NAME");
    masReservationType.setCode("01");
    masReservationType.setIsactive(true);
    masReservationType.setAuditFlag("C");
    masReservationType.setCreatedBy(1);
    masReservationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masReservationTypeRepository.create(masReservationType);

    //create reservation
    reservation = new Reservation();
    reservation.setAuditFlag("C");
    reservation.setCreatedBy(1);
    reservation.setCreatedTimeStamp(Calendar.getInstance().getTime());
    reservation.setEmployee(employee);
    reservation.setMasDivision(masDivision);
    reservation.setMasreservationtype(masReservationType);
    reservation.setRoom(room);
    reservation.setDescription("DESC");
    reservationRepository.create(reservation);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(roomRepository);
    assertNotNull(reservationRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);
    assertNotNull(masReservationTypeRepository);

  }

  @Test
  public void testFindWithReservationRepositoryShouldReturnReservationThatSetup() throws Exception {
    Reservation result = reservationRepository.find(reservation.getId());
    assertNotNull(result);
    assertThat(result.getDescription(), is("DESC"));
    assertThat(result.getRoom().getName(), is("ROOM NAME"));
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getMasreservationtype().getName(), is("TYPE NAME"));
    assertThat(result.getMasDivision().getCode(), is("ITS"));

  }

  @Test
  public void testFindAllWithReservationRepositoryShouldReturnListOfAllReservation() throws Exception {
    List<Reservation> result = reservationRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithReservationRepositoryShouldReturnReservationThatUpdate() throws Exception {
    Reservation update = reservationRepository.find(reservation.getId());
    assertThat(update.getDescription(), is("DESC"));

    update.setDescription("UPDATE DESC");
    reservationRepository.update(update);

    Reservation result = reservationRepository.find(update.getId());
    assertThat(result.getDescription(), is("UPDATE DESC"));

  }

  @Test
  public void testDeleteWithReservationRepositoryShouldNotFindThatReservation() throws Exception {
    Reservation delete = reservationRepository.find(reservation.getId());
    reservationRepository.delete(delete);

    Reservation result = reservationRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithReservationRepositoryShouldNotFindThatReservation() throws Exception {
    Reservation delete = reservationRepository.find(reservation.getId());
    reservationRepository.deleteById(delete.getId());

    Reservation result = reservationRepository.find(delete.getId());
    assertNull(result);

  }

}