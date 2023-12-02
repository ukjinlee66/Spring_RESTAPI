package com.inflearn.restAPI.events;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EventTest {
    @Test
    public void builder() {
        Event event = Event.builder()
            .name("Inflearn Spring REST API")
            .description("REST API development with Spring")
            .build();
        System.out.println(event);
        assertThat(event).isNotNull();
    }

    @Test
    public void JavaBean() {
        // Given
        Event event = new Event();
        String name = "Event";
        event.setName(name);

        // When
        String description = "Spring";
        event.setDescription(description);

        // Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

}