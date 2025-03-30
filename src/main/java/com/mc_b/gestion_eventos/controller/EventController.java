package com.mc_b.gestion_eventos.controller;

import com.mc_b.gestion_eventos.model.Event;
import com.mc_b.gestion_eventos.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/eventos")
    public List<Event> listarEventos() {
        return eventService.obtenerEventos();
    }

    @GetMapping("/eventos/{id}")
    public Event obtenerEvento(@PathVariable Long id) {
        return eventService.obtenerEventoPorId(id);
    }

    @GetMapping("/eventos/inscribir")
    public String inscribirParticipante(
            @RequestParam Long eventoId,
            @RequestParam String nombre,
            @RequestParam String tipo
    ) {
        boolean exito = eventService.inscribirParticipante(eventoId, nombre, tipo);
        return exito ? "Participante inscrito correctamente." : "Error: Participante ya inscrito o evento no encontrado.";
    }
}
