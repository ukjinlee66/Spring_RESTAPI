package com.inflearn.restAPI.events;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EventControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createEvent() throws Exception {
        Event event = Event.builder()
            .name("Spring")
            .description("REST API Development with Spring")
            .beginEnrollmentDateTime(LocalDateTime.of(2020, 11, 23, 14, 21))
            .closeEnrollmentDateTime(LocalDateTime.of(2020, 11, 25, 14, 21))
            .beginEventDateTime(LocalDateTime.of(2020, 11, 23, 14, 21))
            .endEventDateTime(LocalDateTime.of(2020, 11, 23, 20, 21))
            .basePrice(100)
            .maxPrice(200)
            .limitOfEnrollment(100)
            .location("강남역 D2 스타텁 팩토리")
            .build();
        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(event))
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("id").exists());
    }
}
