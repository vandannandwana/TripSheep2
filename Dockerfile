
FROM maven:4.0.0-openjdk-17 AS build

EXPOSE 8080
ENTRYPOINT ["java","-jar","/out/TripSheep_jar/TripSheep_jar"]