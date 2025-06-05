package com.codecool.solar_watch.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "solar_report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolarReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private LocalDateTime sunset;
    private LocalDateTime sunrise;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
