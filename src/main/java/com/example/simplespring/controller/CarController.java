package com.example.simplespring.controller;

import com.example.simplespring.dto.CarDto;
import com.example.simplespring.dto.CarResponseDto;
import com.example.simplespring.mapper.CarMapper;
import com.example.simplespring.model.Car;
import com.example.simplespring.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CarController {

    private final CarService carService;

    @GetMapping(value = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> getCarById(@PathVariable("id") String id){
        Car car = carService.getCar(Long.valueOf(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found."));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CarMapper.toDto(car));
    }

    @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarResponseDto> getCars(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CarMapper.createCarResponse(carService.findAll()));
    }

    @PostMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCar(){
        //TODO

    }

    @PostMapping(value = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCar(){
        //TODO

    }

}
