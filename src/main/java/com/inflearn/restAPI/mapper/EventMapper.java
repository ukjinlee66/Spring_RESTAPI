package com.inflearn.restAPI.mapper;

import com.inflearn.restAPI.events.Event;
import com.inflearn.restAPI.events.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : EventMapper
 * @since : 12/15/23
 */
@Mapper(componentModel = "spring",
    unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE,
    unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface EventMapper {
    EventDto eventToEventDto(Event event);

    Event eventDtoToEvent(EventDto eventDto);
}
