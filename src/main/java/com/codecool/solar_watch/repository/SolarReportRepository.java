package com.codecool.solar_watch.repository;

import com.codecool.solar_watch.entity.SolarReport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarReportRepository extends JpaRepository<SolarReport, Long> {}
