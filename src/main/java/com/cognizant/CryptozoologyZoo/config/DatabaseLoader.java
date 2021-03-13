package com.cognizant.CryptozoologyZoo.config;

import com.cognizant.CryptozoologyZoo.util.AnimalType;
import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import com.cognizant.CryptozoologyZoo.util.HabitatType;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseLoader {
    public static ArrayList<AnimalDto> zoo = new ArrayList<>();
    public static Map<AnimalType, HabitatType> animalTypeHabitatTypeMap = new HashMap<>();

    @PostConstruct
    public void init() {
        zoo.addAll(Arrays.asList(
                new AnimalDto("Cat", AnimalType.WALKING),
                new AnimalDto("Fish", AnimalType.SWIMMING)));

        animalTypeHabitatTypeMap.put(AnimalType.FLYING, HabitatType.NEST);
        animalTypeHabitatTypeMap.put(AnimalType.SWIMMING, HabitatType.OCEAN);
        animalTypeHabitatTypeMap.put(AnimalType.WALKING, HabitatType.FOREST);
    }
}
