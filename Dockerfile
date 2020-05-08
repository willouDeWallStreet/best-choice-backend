FROM openjdk:8
ADD /target/best-choice-backend.jar best-choice-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "best-choice-backend.jar"]