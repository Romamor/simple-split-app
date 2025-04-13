FROM openjdk:11-jre-slim

WORKDIR /app

COPY build/libs/backend-fat.jar /app/backend.jar

EXPOSE 8080

CMD ["java", "-jar", "backend.jar"]
