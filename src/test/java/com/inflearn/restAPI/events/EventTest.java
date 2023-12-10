package com.inflearn.restAPI.events;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("paramsForTestFree")
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        // Given
        Event event = Event.builder()
            .basePrice(basePrice)
            .maxPrice(maxPrice)
            .build();

        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    // static 있어야 동작
    private static Stream<Arguments> paramsForTestFree() { // argument source method
        return Stream.of(
            Arguments.of(0, 0, true),
            Arguments.of(100, 0, false),
            Arguments.of(0, 100, false),
            Arguments.of(100, 200, false)
        );
    }

    private static Stream<Arguments> paramsForTestOffline() { // argument source method
        return Stream.of(
            Arguments.of("강남", true),
            Arguments.of(null, false),
            Arguments.of("        ", false)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTestOffline")
    public void testOffline(String location, boolean isOffline) {
        // Given
        Event event = Event.builder()
            .location(location)
            .build();

        //When
        event.update();

        // Then
        assertThat(event.isOffline()).isEqualTo(isOffline);
    }
}