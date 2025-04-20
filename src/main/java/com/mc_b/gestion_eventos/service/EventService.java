package com.mc_b.gestion_eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc_b.gestion_eventos.model.Event;
import com.mc_b.gestion_eventos.model.Participante;
import com.mc_b.gestion_eventos.repository.EventRepository;
import com.mc_b.gestion_eventos.repository.ParticipanteRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id).map(event -> {
            event.setNombre(updatedEvent.getNombre());
            event.setTipo(updatedEvent.getTipo());
            event.setFecha(updatedEvent.getFecha());
            event.setUbicacion(updatedEvent.getUbicacion());
            return eventRepository.save(event);
        }).orElse(null);
    }

    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean inscribirParticipante(Long eventoId, Participante participante) {
        Optional<Event> optionalEvento = eventRepository.findById(eventoId);
        if (optionalEvento.isEmpty()) return false;

        Event evento = optionalEvento.get();
        boolean yaExiste = evento.getParticipantes().stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(participante.getNombre())
                        && p.getTipo().equalsIgnoreCase(participante.getTipo()));

        if (yaExiste) return false;

        participante.setEvento(evento);
        participanteRepository.save(participante);
        return true;
    }
    public List<Participante> getParticipantesPorEvento(Long eventoId) {
        Optional<Event> evento = eventRepository.findById(eventoId);
        return evento.map(Event::getParticipantes).orElseGet(List::of);
    }
    
    public Participante actualizarParticipante(Long id, Participante participanteActualizado) {
        return participanteRepository.findById(id).map(p -> {
            p.setNombre(participanteActualizado.getNombre());
            p.setTipo(participanteActualizado.getTipo());
            return participanteRepository.save(p);
        }).orElse(null);
    }
    
    public boolean eliminarParticipante(Long id) {
        if (participanteRepository.existsById(id)) {
            participanteRepository.deleteById(id);
            return true;
        }
        return false;
    }
   
    
}
