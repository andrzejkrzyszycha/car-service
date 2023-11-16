package com.example.simplespring;

import com.example.simplespring.model.Car;
import com.example.simplespring.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getAllCars_success() throws Exception {
        List<Car> cars = Arrays.asList(
                new Car(1L, "bmw", "red"),
                new Car(2L, "audi", "red"),
                new Car(3L, "skoda", "red")
        );

        when(carService.findAll()).thenReturn(cars);

        mockMvc.perform(
                get("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.cars").isArray());

    }

    @Test
    public void getCar_success() throws Exception {
        Long carId = 1L;

        Optional<Car> car = Optional.of(new Car(carId, "bmw", "red"));

        when(carService.getCar(any())).thenReturn(car);

        mockMvc.perform(
                        get("/api/v1/cars/" + carId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.type").exists())
                .andExpect(jsonPath("$.colour").exists());

    }

    @Test
    public void getCar_notFound() throws Exception {
        long carId = 1L;

        mockMvc.perform(
                        get("/api/v1/cars/" + carId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(status().reason("Car not found."));

    }
}