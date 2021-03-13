package com.cognizant.CryptozoologyZoo.repository;

import com.cognizant.CryptozoologyZoo.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
