package com.cognizant.CryptozoologyZoo.controller;

import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.cognizant.CryptozoologyZoo.config.DatabaseLoader.zoo;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @PostMapping()
    public ResponseEntity<?> addAnimal(@RequestBody AnimalDto animalDto){
        zoo.add(animalDto);
        return new ResponseEntity<>(animalDto, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAnimals() {
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @PatchMapping("/feed/{name}")
    public ResponseEntity<?> feedAnimal(@PathVariable String name, @RequestBody AnimalDto animalFeed){
        AnimalDto animalDto = zoo.stream()
                .filter(animal->animal.getName().equals(name))
                .findAny()
                .orElse(null);

        if(animalDto == null ) {
            return new ResponseEntity<>("Animal not found.", HttpStatus.NOT_FOUND);
        }
            animalDto.setHappy(animalFeed.isHappy());
            return new ResponseEntity<>(animalDto.isHappy() ? "I'm Happy Now. " : "I'm not Happy. ", HttpStatus.OK);
    }

}
