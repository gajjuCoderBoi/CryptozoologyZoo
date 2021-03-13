package com.cognizant.CryptozoologyZoo.config;

import com.cognizant.CryptozoologyZoo.AnimalType;
import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseLoader {
    public static ArrayList<AnimalDto> zoo = new ArrayList<>();
    public static Map<AnimalType, HabitatType> habitat = new HashMap<>();

    @PostConstruct
    public void init() {
        zoo.addAll(Arrays.asList(
                new AnimalDto("Cat", AnimalType.WALKING),
                new AnimalDto("Fish", AnimalType.SWIMMING)));
    }
}
