package com.example.simplespring.dto;

import com.example.simplespring.model.Car;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CarResponseDto {
    private List<Car> cars;
}
