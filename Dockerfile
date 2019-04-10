FROM openjdk:8-jre-slim
EXPOSE 8080
COPY /build/libs/kotlin-demo-0.0.1-SNAPSHOT.jar /app/kotlin-demo.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "kotlin-demo.jar"]