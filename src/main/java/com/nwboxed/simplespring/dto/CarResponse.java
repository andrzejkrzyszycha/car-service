package com.nwboxed.simplespring.dto;

import com.nwboxed.simplespring.model.Car;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CarResponse {
    private List<Car> cars;
}
