package com.mc_b.gestion_eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc_b.gestion_eventos.assembler.EventModelAssembler;
import com.mc_b.gestion_eventos.model.Event;
import com.mc_b.gestion_eventos.model.Participante;
import com.mc_b.gestion_eventos.service.EventService;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventModelAssembler assembler;

    // HATEOAS: Listar todos los eventos
    @GetMapping("/eventos")
    public CollectionModel<EntityModel<Event>> listarEventos() {
        List<EntityModel<Event>> eventos = eventService.getAllEvents().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(eventos,
                linkTo(methodOn(EventController.class).listarEventos()).withSelfRel());
    }

    // HATEOAS: Obtener un evento por ID
    @GetMapping("/eventos/{id}")
    public EntityModel<Event> obtenerEvento(@PathVariable Long id) {
        Event evento = eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        return assembler.toModel(evento);
    }

    @PostMapping("/eventos")
    public Event crearEvento(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/eventos/{id}")
    public Event actualizarEvento(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/eventos/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        return eventService.deleteEvent(id) ? "Evento eliminado." : "Evento no encontrado.";
    }

    @PostMapping("/eventos/{id}/inscribir")
    public String inscribirParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        boolean exito = eventService.inscribirParticipante(id, participante);
        return exito ? "Participante inscrito correctamente." : "Error: Ya inscrito o evento no encontrado.";
    }

    @GetMapping("/eventos/{id}/participantes")
    public List<Participante> listarParticipantesDeEvento(@PathVariable Long id) {
        return eventService.getParticipantesPorEvento(id);
    }

    @PutMapping("/participantes/{id}")
    public Participante actualizarParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        return eventService.actualizarParticipante(id, participante);
    }

    @DeleteMapping("/participantes/{id}")
    public String eliminarParticipante(@PathVariable Long id) {
        return eventService.eliminarParticipante(id) ? "Participante eliminado." : "Participante no encontrado.";  
    }
}
