package com.rsjava.autodownloadingreport.service;


import com.rsjava.autodownloadingreport.model.Car;
import com.rsjava.autodownloadingreport.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public Car getCar(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No car by id" + id));
    }
}