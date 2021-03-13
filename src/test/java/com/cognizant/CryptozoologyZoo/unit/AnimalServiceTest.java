package com.cognizant.CryptozoologyZoo.unit;

import com.cognizant.CryptozoologyZoo.Entity.Animal;
import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import com.cognizant.CryptozoologyZoo.repository.AnimalRepository;
import com.cognizant.CryptozoologyZoo.service.AnimalService;
import com.cognizant.CryptozoologyZoo.util.AnimalType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @InjectMocks
    private AnimalService animalService;

    @Mock
    private AnimalRepository animalRepository;

    @Test
    public void addAnimalTest(){
        AnimalDto dummyAnimalDto = new AnimalDto("Superman", AnimalType.WALKING);
        Animal dummyAnimalEntity = new Animal();
        dummyAnimalEntity.setName(dummyAnimalDto.getName());
        dummyAnimalEntity.setType(dummyAnimalDto.getType());
        dummyAnimalEntity.setHappy(dummyAnimalDto.isHappy());
        dummyAnimalEntity.setHabitatType(dummyAnimalDto.getHabitatType());

        animalService.addAnimal(dummyAnimalDto);

        verify(animalRepository).save(dummyAnimalEntity);


    }

}
