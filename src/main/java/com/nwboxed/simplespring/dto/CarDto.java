package com.nwboxed.simplespring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {

    private Long id;

    private String type;

    private String colour;
}
