FROM openjdk:8
EXPOSE 8080
ADD /target/best-choice-backend.jar best-choice-backend.jar
ENTRYPOINT ["java", "-jar", "best-choice-backend.jar"]