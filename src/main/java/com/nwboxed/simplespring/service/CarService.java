package com.nwboxed.simplespring.service;

import com.nwboxed.simplespring.model.Car;
import com.nwboxed.simplespring.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

}
