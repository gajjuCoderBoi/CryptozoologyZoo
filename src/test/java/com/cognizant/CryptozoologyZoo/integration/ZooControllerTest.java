package com.cognizant.CryptozoologyZoo.integration;

import com.cognizant.CryptozoologyZoo.AnimalType;
import com.cognizant.CryptozoologyZoo.dto.AnimalDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ZooControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addAnimalTest() throws Exception {
        AnimalDto dummyAnimal = new AnimalDto();
        dummyAnimal.setName("Superman");
        dummyAnimal.setType(AnimalType.WALKING);
        RequestBuilder rq = post("/animal")
                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dummyAnimal));

        mockMvc
                .perform(rq)
                    .andExpect(status().isCreated())
                    .andExpect(content().json(objectMapper.writeValueAsString(dummyAnimal)))
                    .andDo(print())

        ;

    }

}
