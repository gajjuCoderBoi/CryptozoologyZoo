package com.cognizant.CryptozoologyZoo.controller;

import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    ArrayList<AnimalDto> zoo;

    public AnimalController() {
        this.zoo = new ArrayList<>();
    }

    @PostMapping()
    public ResponseEntity<?> addAnimal(@RequestBody AnimalDto animalDto){
        return new ResponseEntity<>(animalDto, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAnimals() {
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

}
