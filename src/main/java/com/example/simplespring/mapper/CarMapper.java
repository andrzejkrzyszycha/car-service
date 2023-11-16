package com.example.simplespring.mapper;

import com.example.simplespring.dto.CarDto;
import com.example.simplespring.dto.CarResponseDto;
import com.example.simplespring.model.Car;

import java.util.List;

public class CarMapper {

    public static CarDto toDto(Car car){
        return CarDto.builder()
                .id(car.getId())
                .type(car.getType())
                .colour(car.getColour())
                .build();
    }

    public static CarResponseDto createCarResponse(List<Car> cars){
        return CarResponseDto.builder().cars(cars).build();
    }
}
