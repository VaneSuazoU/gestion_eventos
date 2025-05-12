FROM openjdk:24-jdk-slim
WORKDIR /app
COPY target/gestion_eventos-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/wallet /app/wallet
ENV TNS_ADMIN=/app/wallet
ENTRYPOINT ["java", "-jar", "app.jar"]
