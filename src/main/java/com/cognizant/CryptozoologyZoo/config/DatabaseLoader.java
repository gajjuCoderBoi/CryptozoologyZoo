package com.cognizant.CryptozoologyZoo.config;

import com.cognizant.CryptozoologyZoo.AnimalType;
import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DatabaseLoader {
    public static ArrayList<AnimalDto> zoo = new ArrayList<>();

    @PostConstruct
    public void init() {
        zoo.addAll(Arrays.asList(
                new AnimalDto("Cat", AnimalType.WALKING),
                new AnimalDto("Fish", AnimalType.SWIMMING)));
    }
}
