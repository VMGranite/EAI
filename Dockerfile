FROM amazoncorretto:17-alpine3.17-full

WORKDIR /app
COPY target/EAI-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
