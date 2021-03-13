package com.cognizant.CryptozoologyZoo.dto;

import com.cognizant.CryptozoologyZoo.AnimalType;
import com.cognizant.CryptozoologyZoo.config.HabitatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    private String name;
    private AnimalType type;
    private boolean happy=false;
    private HabitatType habitatType;

    public AnimalDto(String name, AnimalType type) {
        this.name = name;
        this.type = type;
        this.happy = false;
    }
}
