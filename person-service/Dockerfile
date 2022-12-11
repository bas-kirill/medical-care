FROM openjdk:17
MAINTAINER Kirill B <baskirill.an@gmail.com>
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
COPY target/person-service-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]