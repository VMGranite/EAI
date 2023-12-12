FROM openjdk:16-slim

WORKDIR /app
COPY target/EAI-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
