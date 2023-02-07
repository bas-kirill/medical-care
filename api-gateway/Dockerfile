FROM maven:3.8.2-jdk-11 as maven
COPY . /home/maven/project/project
WORKDIR /home/maven/project/project
RUN mvn clean package -Pproduction

FROM openjdk:11-jdk
COPY --from=maven /home/maven/project/project/target/*.jar /project.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/project.jar"]
