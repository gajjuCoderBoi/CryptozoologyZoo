package com.cognizant.CryptozoologyZoo.integration;

import com.cognizant.CryptozoologyZoo.util.AnimalType;
import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import com.cognizant.CryptozoologyZoo.util.HabitatType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ZooControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private String getAnimalJsonString() throws JsonProcessingException {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setName("Elephant");
        animalDto.setType(AnimalType.WALKING);
        animalDto.setHabitatType(HabitatType.FOREST);
        return objectMapper.writeValueAsString(animalDto);
    }

    @Test
    public void addAnimalTest() throws Exception {
        RequestBuilder rq = post("/animal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getAnimalJsonString());

        mockMvc.perform(rq)
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("happy").value(true))
                    .andDo(print());
    }

    @Test
    public void getAllAnimalsTest() throws Exception {
        // Setup
        RequestBuilder requestBuilder = get("/animal/list")
                .accept(MediaType.APPLICATION_JSON);
        // Execution
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }

    @Test
    public void feedAnimalMakeHappyTest() throws Exception {
        AnimalDto dummyAnimal = new AnimalDto();
        dummyAnimal.setHappy(true);
        RequestBuilder rq = patch("/animal/feed/Cat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dummyAnimal))
                ;

        mockMvc.perform(rq)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("I'm Happy Now. "))
        ;
    }

    @Test
    public void feedAnimalMakeHappyTestCatNotFound() throws Exception {
        AnimalDto dummyAnimal = new AnimalDto();
        dummyAnimal.setHappy(true);
        RequestBuilder rq = patch("/animal/feed/Camel")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dummyAnimal));

        mockMvc.perform(rq)
                .andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(content().string("Animal not found."));
    }


    @Test
    public void feedAnimalMakeHappyTestAnimalNotHappy() throws Exception {
        AnimalDto dummyAnimal = new AnimalDto();
        dummyAnimal.setHappy(false);
        RequestBuilder rq = patch("/animal/feed/Cat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dummyAnimal));

        mockMvc.perform(rq)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("I'm not Happy. "));
    }

    @Test
    public void updateAnimalHabitatTest() throws Exception {
        AnimalDto dummyAnimal = new AnimalDto();
        dummyAnimal.setHabitatType(HabitatType.FOREST);

        RequestBuilder rq = put("/animal/Cat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dummyAnimal));

        mockMvc.perform(rq)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("I'm good habitat place. "));
    }

    @Test
    public void updateAnimalHabitatTestCamelNotFound() throws Exception {
        RequestBuilder rq = put("/animal/Camel")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}");

        mockMvc.perform(rq)
                .andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(content().string("Animal not found."));
    }


    @Test
    public void updateAnimalHabitatTestAnimalNotHappy() throws Exception {
        AnimalDto dummyAnimal = new AnimalDto();
        dummyAnimal.setHabitatType(HabitatType.OCEAN);
        RequestBuilder rq = put("/animal/Cat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dummyAnimal));

        mockMvc.perform(rq)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("I'm not Happy with this Habitat! "));
    }
}
