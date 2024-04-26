package com.riwi.taller_02.Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "events")
@Data //Data create getter and setters, to string
@AllArgsConstructor //Create contructor full
@NoArgsConstructor //Create constructor empty
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private LocalDate date;
    private String location;
    private int capacity;
}
