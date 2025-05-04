
# Microservicio: Gestión de Eventos de Mascotas

Este microservicio permite gestionar eventos relacionados con mascotas como ferias, competencias, desfiles, etc. Puedes listar eventos, ver detalles y registrar participantes.

Primera sumativa Desarrollo FullStack

## 🧱 Tecnologías

- Java 24  
- Spring Boot 3.4.4  
- Maven  
- HATEOAS  
- JUnit 5 + Mockito (para pruebas unitarias)

---

## 🚀 Cómo ejecutar

Desde la raíz del proyecto, ejecuta:

```
./mvnw spring-boot:run
```

> En Windows:  
```
mvnw.cmd spring-boot:run
```

---

## 🌐 Endpoints disponibles

### Obtener todos los eventos (con HATEOAS)
```
GET /api/eventos
```
**Ejemplo:**  
[http://localhost:8080/api/eventos](http://localhost:8080/api/eventos)

---

### Obtener evento por ID (con HATEOAS)
```
GET /api/eventos/{id}
```
**Ejemplo:**  
[http://localhost:8080/api/eventos/1](http://localhost:8080/api/eventos/1)

---

### Crear nuevo evento
```
POST /api/eventos
```
Body:
```json
{
  "nombre": "Desfile de Moda Pet",
  "tipo": "evento social",
  "fecha": "2025-08-05",
  "ubicacion": "Plaza del Sol"
}
```

---

### Inscribir participante
```
POST /api/eventos/{id}/inscribir
```
Body:
```json
{
  "nombre": "Firulais",
  "tipo": "mascota"
}
```

---

### Obtener participantes por evento
```
GET /api/eventos/{id}/participantes
```

---

### Actualizar participante
```
PUT /api/participantes/{id}
```
Body:
```json
{
  "nombre": "Nuevo Nombre",
  "tipo": "persona"
}
```

---

### Eliminar participante
```
DELETE /api/participantes/{id}
```

---

## 🎟️ Eventos precargados

| ID | Nombre               | Tipo          | Fecha        | Ubicación         |
|----|----------------------|---------------|--------------|-------------------|
| 1  | Feria de Mascotas    | feria         | 2025-06-01   | Plaza Central     |
| 2  | Concurso de Agilidad | competencia   | 2025-06-15   | Parque Deportivo  |
| 3  | Desfile Canino       | evento social | 2025-06-25   | Plaza Norte       |

---

## 📂 Estructura del proyecto

```
com.mc_b.gestion_eventos
│
├── assembler
│   └── EventModelAssembler.java
│
├── controller
│   └── EventController.java
│
├── model
│   ├── Event.java
│   └── Participante.java
│
├── repository
│   ├── EventRepository.java
│   └── ParticipanteRepository.java
│
├── service
│   └── EventService.java
│
├── GestionEventosApplication.java
└── resources
    └── application.properties
```

---

## 📎 HATEOAS

Los endpoints `GET /api/eventos` y `GET /api/eventos/{id}` entregan respuestas enriquecidas con enlaces HATEOAS utilizando `EventModelAssembler`, facilitando la navegación entre recursos.

---

## 🧪 Pruebas

Se implementaron pruebas unitarias con **JUnit 5** y **Mockito** para verificar el comportamiento de `EventService`.

📁 Archivo principal:
```
src/test/java/com/mc_b/gestion_eventos/service/EventServiceTest.java
```

Para ejecutar las pruebas:
```
mvn test
```

---

## ✨ Estado actual

✔ Funcionalidad principal implementada  
✔ Endpoints REST y HATEOAS operativos  
✔ Pruebas unitarias del servicio  
✔ Documentación actualizada
