
# Microservicio: Gestión de Eventos

Este microservicio forma parte de una aplicación de viajes con mascotas. Permite registrar eventos pet-friendly como ferias, competencias, desfiles, e inscribir participantes (mascotas o personas).

Primera sumativa Desarrollo FullStack

## 🧱 Tecnologías
- Java 24
- Spring Boot 3.4.4
- Maven
- HATEOAS
- JUnit 5 + Mockito

## 🚀 Cómo ejecutar

Desde la raíz del proyecto, ejecuta:

```bash
./mvnw spring-boot:run
```

> En Windows:  
```bash
mvnw.cmd spring-boot:run
```

---

## 🐳 Docker y despliegue remoto

Este microservicio puede ejecutarse también directamente desde DockerHub:

```bash
docker run -p 8080:8080 vanesuazou/gestion_eventos
```

👉 Imagen publicada: [https://hub.docker.com/r/vanesuazou/gestion_eventos](https://hub.docker.com/r/vanesuazou/gestion_eventos)

---

## 🌐 Endpoints disponibles

### Obtener todos los eventos
```http
GET /api/eventos
```

### Obtener evento por ID
```http
GET /api/eventos/{id}
```

### Crear nuevo evento
```http
POST /api/eventos
Content-Type: application/json
```
```json
{
  "nombre": "Desfile de Moda Pet",
  "tipo": "evento social",
  "fecha": "2025-08-05",
  "ubicacion": "Plaza del Sol"
}
```

### Inscribir participante
```http
POST /api/eventos/{id}/inscribir
Content-Type: application/json
```
```json
{
  "nombre": "Firulais",
  "tipo": "mascota"
}
```

### Obtener participantes por evento
```http
GET /api/eventos/{id}/participantes
```

### Actualizar participante
```http
PUT /api/participantes/{id}
Content-Type: application/json
```
```json
{
  "nombre": "Nuevo Nombre",
  "tipo": "persona"
}
```

### Eliminar participante
```http
DELETE /api/participantes/{id}
```

---

## 🐾 Eventos precargados

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
├── repository
│   ├── EventRepository.java
│   └── ParticipanteRepository.java
├── service
│   └── EventService.java
├── controller
│   └── EventController.java
└── GestionEventosApplication.java
```

---

## 🧪 Pruebas

Puedes usar navegador o Postman para probar los endpoints.

Incluye pruebas unitarias con JUnit 5 + Mockito en:

```
src/test/java/com/mc_b/gestion_eventos/service/EventServiceTest.java
```
