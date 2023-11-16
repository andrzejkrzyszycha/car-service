package com.nwboxed.simplespring.controller;

import com.nwboxed.simplespring.dto.CarResponse;
import com.nwboxed.simplespring.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nwboxed.simplespring.mapper.CarMapper.createCarResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CarController {

    private final CarService carService;

    @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarResponse> getCars(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(createCarResponse(carService.findAll()));
    }

}
