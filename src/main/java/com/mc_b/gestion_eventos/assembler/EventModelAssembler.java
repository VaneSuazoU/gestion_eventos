package com.mc_b.gestion_eventos.assembler;

import com.mc_b.gestion_eventos.controller.EventController;
import com.mc_b.gestion_eventos.model.Event;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EventModelAssembler implements RepresentationModelAssembler<Event, EntityModel<Event>> {

    @Override
    public EntityModel<Event> toModel(Event event) {
        return EntityModel.of(event,
                linkTo(methodOn(EventController.class).obtenerEvento(event.getId())).withSelfRel(),
                linkTo(methodOn(EventController.class).listarEventos()).withRel("eventos"));
    }
}
