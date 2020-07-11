package com.rsjava.autodownloadingreport.controller;

import com.rsjava.autodownloadingreport.model.Car;
import com.rsjava.autodownloadingreport.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("cars")
    public List<Car> getCars(){
        return carService.getCars();
    }

    @GetMapping("cars/{id}")
    public Car getCar(Long id){
        return carService.getCar(id);
    }

}