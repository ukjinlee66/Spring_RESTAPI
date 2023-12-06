package com.inflearn.restAPI.events;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {
        // TODO 입력 받은 이벤트 데이터가 유효한지 검사하는 로직 구현
         if (eventDto.getMaxPrice() < eventDto.getBasePrice() && eventDto.getMaxPrice() > 0) {
                errors.rejectValue("basePrice", "wrongValue", "BasePrice is wrong.");
                errors.rejectValue("maxPrice", "wrongValue", "MaxPrice is wrong.");
         }
        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
         if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
         endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
             endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
             errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong.");
         }
    }
}
