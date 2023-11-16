package com.nwboxed.simplespring.mapper;

import com.nwboxed.simplespring.dto.CarResponse;
import com.nwboxed.simplespring.model.Car;

import java.util.List;

public class CarMapper {

    public static CarResponse createCarResponse(List<Car> cars){
        return CarResponse.builder().cars(cars).build();
    }
}
