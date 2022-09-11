FROM --platform=linux/amd64 openjdk:15
COPY  target/autographs-car-registration-microservice.jar autographs-car-registration-microservice.jar
ENTRYPOINT [ "java", "-jar",  "autographs-car-registration-microservice.jar"]
EXPOSE 8001
## docker build command
## docker buildx build --platform=linux/amd64 -t autographs-car-registration-microservice .