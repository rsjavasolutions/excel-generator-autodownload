package com.rsjava.autodownloadingreport.data;

import com.rsjava.autodownloadingreport.model.Car;
import com.rsjava.autodownloadingreport.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CarData implements CommandLineRunner {

    private final CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("Audi", "A4", "Grey", true, LocalDate.now());
        Car car2 = new Car("BMW", "F10", "Black", false, LocalDate.now().minusDays(20));
        Car car3 = new Car("Ford", "Mondeo", "Grey", true, LocalDate.now().minusYears(10));
        Car car4 = new Car("Mercedes", "CLS", "Gold", true, LocalDate.now().minusYears(5));
        Car car5 = new Car("Ford", "Mustang", "Black", false, LocalDate.now().minusMonths(2));
        Car car6 = new Car("Skoda", "Fabia", "Light-blue", true, LocalDate.now().minusYears(10));
        Car car7 = new Car("Volkswagen", "Polo", "Grey", true, LocalDate.now().minusYears(8));
        Car car8 = new Car("Volvo", "V60", "Black", false, LocalDate.now());
        Car car9 = new Car("Dodge", "Challenger", "White", false, LocalDate.now().minusYears(1));

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
        carRepository.save(car5);
        carRepository.save(car6);
        carRepository.save(car7);
        carRepository.save(car8);
        carRepository.save(car9);
    }
}
