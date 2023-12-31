package com.example.simplespring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity(name = "car")
@AllArgsConstructor
public class Car {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "colour")
    private String colour;
}
