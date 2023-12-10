package com.inflearn.restAPI.events;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.EntityModel;

public class EventResource extends EntityModel<Event> {

    public EventResource(Event content) {
        super(content);
        add(linkTo(EventController.class).slash(content.getId()).withSelfRel());
    }
}
