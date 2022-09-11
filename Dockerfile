FROM --platform=linux/amd64 openjdk:15
COPY  target/autographs-car-registration-microservice.jar autographs-car-registration-microservice.jar
ENTRYPOINT [ "java", "-jar",  "autographs-car-registration-microservice.jar"]
EXPOSE 8001