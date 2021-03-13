package com.cognizant.CryptozoologyZoo.service;

import com.cognizant.CryptozoologyZoo.Entity.Animal;
import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import com.cognizant.CryptozoologyZoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalDto addAnimal(AnimalDto animalDto){
        Animal savedAnimal = new Animal();
        savedAnimal.setName(animalDto.getName());
        savedAnimal.setType(animalDto.getType());
        savedAnimal.setHappy(animalDto.isHappy());
        savedAnimal.setHabitatType(animalDto.getHabitatType());

        animalRepository.save(savedAnimal);

        return entityToDto(savedAnimal);

    }

    private AnimalDto entityToDto(Animal animal){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setName(animal.getName());
        animalDto.setType(animal.getType());
        animalDto.setHappy(animal.isHappy());
        animalDto.setHabitatType(animal.getHabitatType());

        return animalDto;
    }

}
