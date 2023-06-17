FROM maven:3.8.4 as builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn install -DDB_URL=jdbc:postgresql://db:5432/polisportiva -DskipTests=true -f pom.xml

FROM openjdk:17

WORKDIR /deployments

COPY --from=builder /app/target/quarkus-app/ /deployments/

EXPOSE 8080

CMD ["java", "-jar", "/deployments/quarkus-run.jar"]
