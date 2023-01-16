package de.neuefische.neuefischespringsecuritydemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String id;
    private String brand;
    private String model;
    private String color;
}
