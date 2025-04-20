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

### Crear nuevo evento
```http
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
```http
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
```http
GET /api/eventos/{id}/participantes
```

---

### Actualizar participante
```http
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
```http
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
├── controller
│   ├── EventController.java
│   └── ParticipanteController.java
│
└── GestionEventosApplication.java
```

---

## 🧪 Pruebas

Puedes usar navegador o Postman para probar los endpoints.
