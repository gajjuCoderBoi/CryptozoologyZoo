package com.cognizant.CryptozoologyZoo.dto;

import com.cognizant.CryptozoologyZoo.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimalDto {
    private String name;
    private AnimalType type;

}
