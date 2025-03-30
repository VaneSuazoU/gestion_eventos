# Microservicio: Gestión de Eventos de Mascotas

Este microservicio permite gestionar eventos relacionados con mascotas como ferias, competencias, desfiles, etc. Puedes listar eventos, ver detalles y registrar participantes.

Primera sumativa Desarrollo FullStack

## 🧱 Tecnologías
- Java 24
- Spring Boot 3.4.4
- Maven

## 🚀 Cómo ejecutar

Desde la raíz del proyecto, ejecuta:

```bash
./mvnw spring-boot:run
```

> En Windows:  
```bash
mvnw.cmd spring-boot:run
```

## 🌐 Endpoints disponibles

### Obtener todos los eventos
```http
GET /api/eventos
```
**Ejemplo:**  
[http://localhost:8080/api/eventos](http://localhost:8080/api/eventos)

---

### Obtener evento por ID
```http
GET /api/eventos/{id}
```
**Ejemplo:**  
[http://localhost:8080/api/eventos/1](http://localhost:8080/api/eventos/1)

---

### Inscribir participante
```http
GET /api/eventos/inscribir?eventoId={id}&nombre={nombre}&tipo={tipo}
```
**Ejemplo:**  
[http://localhost:8080/api/eventos/inscribir?eventoId=1&nombre=Firulais&tipo=mascota](http://localhost:8080/api/eventos/inscribir?eventoId=1&nombre=Firulais&tipo=mascota)

---

## 🎟️ Eventos precargados

| ID | Nombre               | Tipo        | Fecha        | Ubicación         |
|----|----------------------|-------------|--------------|-------------------|
| 1  | Feria Pet Lovers     | feria       | 2025-04-10   | Parque Central    |
| 2  | Carrera de Mascotas  | competencia | 2025-04-20   | Estadio Comunal   |
| 3  | Desfile de Disfraces | evento social | 2025-04-30 | Plaza Principal   |

---

## 📂 Estructura del proyecto

```
com.mc_b.gestion_eventos
│
├── model
│   ├── Event.java
│   └── Participante.java
│
├── repository
│   └── EventRepository.java
│
├── service
│   └── EventService.java
│
├── controller
│   └── EventController.java
│
└── GestionEventosApplication.java
```

---

## 🧪 Pruebas

Puedes usar navegador o Postman para probar los endpoints.

---
