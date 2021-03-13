package com.cognizant.CryptozoologyZoo.Entity;

import com.cognizant.CryptozoologyZoo.util.AnimalType;
import com.cognizant.CryptozoologyZoo.util.HabitatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private AnimalType type;
    private boolean happy=false;
    private HabitatType habitatType;
}
