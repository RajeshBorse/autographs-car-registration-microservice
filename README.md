# University of Leicester - Masters Project

Autographs is an application designed and developed as a part of an academic project for the year 2021/22. This is designed and developed by Rajesh Borse (rsb34)

## Requirements
As per the project requirements, we are expected to display the cloud-based data in the form of charts to android mobile users.

## Microservice

Autographs CAR Registration Microservice - This is a spring-boot java microservice which has RESTful APIs which will be used by the android mobile application for displaying the charts in the frontend systems based on the service response.

Below are the services that this microservice serves.

- New CAR Registrations.
- New CAR Registrations by Fuel Type.
- New CAR Registrations by Sales Type.

Below are the endpoints that are exposed by this microservice.

## New CAR Registrations

- GET API Endpoint - Used for fetching all the CAR registration data from the MongoDB database.


```bash
/api/v1/newCarRegistrations/getAllNewCarRegistrationsData
```


- POST API Endpoint - Used for inserting all the CAR registration data in the MongoDB database.

```bash
/api/v1/newCarRegistrations/addNewCarRegistrationsData
```


- DELETE API Endpoint - Used for deleting all the CAR registrations in the MongoDB database.
```bash
/api/v1/newCarRegistrations/deleteAllNewCarRegistrationsData
```


## New CAR Registrations by Fuel Type

- GET API Endpoint - Used for fetching all the CAR Registrations by Fuel Type data from the MongoDB database.

```bash
/api/v1/newCarRegistrations/getAllNewCarRegistrationsByFuelTypeData
```

- POST API Endpoint - Used for inserting all the CAR Registrations by Fuel Type data in the MongoDB database.

```bash
/api/v1/newCarRegistrations/addNewCarRegistrationsByFuelTypeData
```

- DELETE API Endpoint - Used for deleting all the CAR Registrations by Fuel Type data in the MongoDB database.
```bash
/api/v1/newCarRegistrations/deleteAllNewCarRegistrationsByFuelTypeData
```

## New CAR Registrations by Sales Type
- GET API Endpoint - Used for fetching all the CAR Registrations by Sales Type data from the MongoDB database.

```bash
/api/v1/newCarRegistrations/getAllNewCarRegistrationsBySalesTypeData
```

- POST API Endpoint - Used for inserting all the CAR Registrations by Sales Type data in the MongoDB database.

```bash
/api/v1/newCarRegistrations/addNewCarRegistrationsBySalesTypeData
```

- DELETE API Endpoint - Used for deleting all the CAR Registrations by Sales Type data in the MongoDB database.
```bash
/api/v1/newCarRegistrations/deleteAllNewCarRegistrationsBySalesTypeData
