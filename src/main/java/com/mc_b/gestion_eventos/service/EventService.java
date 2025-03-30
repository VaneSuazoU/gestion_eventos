package com.mc_b.gestion_eventos.service;

import com.mc_b.gestion_eventos.model.Event;
import com.mc_b.gestion_eventos.model.Participante;
import com.mc_b.gestion_eventos.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> obtenerEventos() {
        return eventRepository.getAllEvents();
    }

    public Event obtenerEventoPorId(Long id) {
        return eventRepository.getEventById(id);
    }

    public boolean inscribirParticipante(Long eventoId, String nombre, String tipo) {
        Participante participante = new Participante(System.currentTimeMillis(), nombre, tipo);
        return eventRepository.addParticipant(eventoId, participante);
    }
}
