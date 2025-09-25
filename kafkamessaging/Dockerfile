# Stage 1: build jar
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /workspace
# copy maven wrapper and project files
COPY . .
# Use wrapper if you prefer; if mvnw is present use it. Here we use mvn directly (maven image has mvn)
RUN mvn -B -DskipTests package

# Stage 2: runtime
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copy jar from build stage (assumes artifact is target/*.jar)
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
