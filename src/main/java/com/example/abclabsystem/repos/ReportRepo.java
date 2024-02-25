package com.example.abclabsystem.repos;


import com.example.abclabsystem.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {

    Report findByDate(String date);
}
