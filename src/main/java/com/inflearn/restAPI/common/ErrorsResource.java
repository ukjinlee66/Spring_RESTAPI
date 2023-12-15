package com.inflearn.restAPI.common;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.inflearn.restAPI.index.IndexController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.validation.Errors;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : ErrorsResource
 * @since : 12/13/23
 */
public class ErrorsResource extends EntityModel<Errors> {

        public ErrorsResource(Errors content) {
            super(content);
            add(linkTo(methodOn(IndexController.class).index()).withRel("index"));
        }

}
