# === Build stage ===
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# First copy pom.xml and resolve dependencies (better caching)
COPY pom.xml .
RUN mvn -q -DskipTests=true dependency:go-offline

# Now copy source code and build the jar
COPY src ./src
RUN mvn -q -DskipTests=true package

# === Run stage ===
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/demowarranty-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENV PORT=8080

ENTRYPOINT ["java","-jar","app.jar"]
