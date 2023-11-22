FROM openjdk:17-oracle
VOLUME /tmp
ARG JAR_FILE
COPY target/todo-0.0.1-SNAPSHOT.jar todo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar","/todo-0.0.1-SNAPSHOT.jar"]