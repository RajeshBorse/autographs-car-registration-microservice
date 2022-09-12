FROM openjdk:15
ADD target/autographs-car-registration-microservice.jar autographs-car-registration-microservice.jar
ENTRYPOINT [ "java", "-jar",  "autographs-car-registration-microservice.jar"]
EXPOSE 8001