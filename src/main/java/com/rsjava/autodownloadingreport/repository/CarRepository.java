package com.rsjava.autodownloadingreport.repository;

import com.rsjava.autodownloadingreport.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}

