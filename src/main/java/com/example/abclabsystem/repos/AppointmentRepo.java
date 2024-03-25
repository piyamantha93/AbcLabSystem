package com.example.abclabsystem.repos;

import com.example.abclabsystem.entity.Appointment;
import com.example.abclabsystem.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {


    Appointment findByDate(String date);
}
