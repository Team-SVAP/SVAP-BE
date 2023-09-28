FROM openjdk:17-jdk

ARG JAR_FILE=build/libs/*.jar

EXPOSE 8080

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=doker", "-jar", "app.jar"]