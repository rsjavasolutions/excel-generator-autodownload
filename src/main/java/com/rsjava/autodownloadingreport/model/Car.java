package com.rsjava.autodownloadingreport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String color;
    private Boolean isUsed;
    private LocalDate buildDate;

    public Car(String brand, String model, String color, Boolean isUsed, LocalDate buildDate) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.isUsed = isUsed;
        this.buildDate = buildDate;
    }
}
