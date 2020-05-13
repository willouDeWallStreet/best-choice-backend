FROM openjdk:8
EXPOSE 8080
ADD /target/best-choice-backend-0.0.1-SNAPSHOT.jar best-choice-backend
ENTRYPOINT ["java", "-jar", "/best-choice-backend"]
