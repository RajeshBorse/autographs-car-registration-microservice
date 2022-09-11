# University of Leicester - Masters Project

Autographs is an application designed and developed as a part of an academic project for the year 2021/22. This is designed and developed by Rajesh Borse (rsb34)

## Requirements
As per the project requirements, we are expected to display the cloud-based data in the form of charts to android mobile users.

## Microservice

Autographs Car Registration Microservice - This is a spring-boot java microservice which has RESTful APIs which will be used by the android mobile application for displaying the charts in the frontend systems based on the service response.

Below are the services that this microservice serves.

- New Car Registrations. 
- New Car Registrations by Fuel Type. 
- New Car Registrations by Sales Type. 

Below are the endpoints that are exposed by this microservice.

- GET API Endpoint - Used for fetching all the car registration data from the MongoDB database.


```bash
/api/v1/newCarRegistrations/getAllNewCarRegistrationsData
```


- POST API Endpoint - Used for inserting all the car registration data in the MongoDB database.

```bash
/api/v1/newCarRegistrations/addNewCarRegistrationsData
```


- DELETE API Endpoint - Used for deleting all the car registrations in the MongoDB database.
```bash
/api/v1/newCarRegistrations/deleteAllNewCarRegistrationsData
```
