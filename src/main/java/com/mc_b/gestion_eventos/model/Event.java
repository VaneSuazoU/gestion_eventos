package com.mc_b.gestion_eventos.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private Long id;
    private String nombre;
    private String tipo;      // feria, competencia, etc.
    private String fecha;
    private String ubicacion;
    private List<Participante> participantes;

    public Event() {
        this.participantes = new ArrayList<>();
    }

    public Event(Long id, String nombre, String tipo, String fecha, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.participantes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void agregarParticipante(Participante participante) {
        this.participantes.add(participante);
    }
}
