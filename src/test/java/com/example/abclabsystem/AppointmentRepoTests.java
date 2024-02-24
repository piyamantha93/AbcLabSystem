package com.example.abclabsystem;

import com.example.abclabsystem.entity.Appointment;
import com.example.abclabsystem.repos.AppointmentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AppointmentRepoTests {
@Autowired private AppointmentRepo repo;

    @Test
    public void testAddNew(){
        Appointment appointment =new Appointment();
        appointment.setAppointment_id(21);
        appointment.setPatient_id("13");
        appointment.setName("tharindu");
        appointment.setEmail("tharindu@gmail.com");
        appointment.setTest("test");
        appointment.setTime("08:40");
        appointment.setDate("2024.02.27");

        Appointment savedAppointment = repo.save(appointment);
    }


}
