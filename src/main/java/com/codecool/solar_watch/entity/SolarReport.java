package com.codecool.solar_watch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "solar_report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolarReport {
    @Id private Long id;

    private LocalDateTime date;
    private LocalDateTime sunset;
    private LocalDateTime sunrise;
}
