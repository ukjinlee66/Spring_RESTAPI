package com.inflearn.restAPI.index;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.inflearn.restAPI.events.EventController;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : IndexController
 * @since : 12/13/23
 */
@RestController
public class IndexController {

    @GetMapping("/api")
    public RepresentationModel index() {
        var index = new RepresentationModel();
        index.add(linkTo(EventController.class).withRel("events"));
        return index;
    }
}
