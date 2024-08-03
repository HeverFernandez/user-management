FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/usermanagement-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]