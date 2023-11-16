package com.nwboxed.simplespring.service;

import com.nwboxed.simplespring.model.Car;
import com.nwboxed.simplespring.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public Optional<Car> getCar(Long id) {
        return carRepository.findById(id);
    }
    public List<Car> findAll() {
        return carRepository.findAll();
    }

}
