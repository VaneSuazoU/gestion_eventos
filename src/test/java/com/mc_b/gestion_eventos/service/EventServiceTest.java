package com.mc_b.gestion_eventos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mc_b.gestion_eventos.model.Event;
import com.mc_b.gestion_eventos.repository.EventRepository;
import com.mc_b.gestion_eventos.repository.ParticipanteRepository;

public class EventServiceTest {

    private EventRepository eventRepository;
    private ParticipanteRepository participanteRepository;
    private EventService eventService;

    @BeforeEach
    void setUp() {
        eventRepository = Mockito.mock(EventRepository.class);
        participanteRepository = Mockito.mock(ParticipanteRepository.class);
        eventService = new EventService(eventRepository, participanteRepository);
    }

    @Test
    void testCreateEvent() {
        Event event = new Event();
        event.setNombre("Feria de Mascotas");
        event.setTipo("feria");
        event.setFecha("2025-06-01");
        event.setUbicacion("Plaza Central");

        when(eventRepository.save(event)).thenReturn(event);

        Event created = eventService.createEvent(event);

        assertNotNull(created);
        assertEquals("Feria de Mascotas", created.getNombre());
        assertEquals("feria", created.getTipo());
    }

    @Test
    void testGetEventById() {
        Event event = new Event();
        event.setId(1L);
        event.setNombre("Concurso de Agilidad");

        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        Optional<Event> found = eventService.getEventById(1L);

        assertTrue(found.isPresent());
        assertEquals("Concurso de Agilidad", found.get().getNombre());
    }

    @Test
    void testGetAllEvents() {
        List<Event> eventos = new ArrayList<>();
        eventos.add(new Event());

        when(eventRepository.findAll()).thenReturn(eventos);

        List<Event> result = eventService.getAllEvents();

        assertEquals(1, result.size());
    }

    @Test
    void testDeleteEvent() {
        when(eventRepository.existsById(1L)).thenReturn(true);
        doNothing().when(eventRepository).deleteById(1L);

        boolean deleted = eventService.deleteEvent(1L);

        assertTrue(deleted);
        verify(eventRepository, times(1)).deleteById(1L);
    }
} 
