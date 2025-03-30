package com.mc_b.gestion_eventos.repository;

import com.mc_b.gestion_eventos.model.Event;
import com.mc_b.gestion_eventos.model.Participante;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository {

    private final List<Event> eventos = new ArrayList<>();

    public EventRepository() {
        eventos.add(new Event(1L, "Feria Pet Lovers", "feria", "2025-04-10", "Parque Central"));
        eventos.add(new Event(2L, "Carrera de Mascotas", "competencia", "2025-04-20", "Estadio Comunal"));
        eventos.add(new Event(3L, "Desfile de Disfraces", "evento social", "2025-04-30", "Plaza Principal"));
    }

    public List<Event> getAllEvents() {
        return eventos;
    }

    public Event getEventById(Long id) {
        return eventos.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean addParticipant(Long eventoId, Participante participante) {
        Event evento = getEventById(eventoId);
        if (evento == null) return false;

        boolean yaInscrito = evento.getParticipantes().stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(participante.getNombre())
                            && p.getTipo().equalsIgnoreCase(participante.getTipo()));
        if (yaInscrito) return false;

        evento.agregarParticipante(participante);
        return true;
    }
}
