package de.neuefische.neuefischespringsecuritydemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<Car> getAll () {
        return carService.getAll();
    }

    @PostMapping
    public Car create (@RequestBody Car car) {
        return carService.create(car);
    }
}
