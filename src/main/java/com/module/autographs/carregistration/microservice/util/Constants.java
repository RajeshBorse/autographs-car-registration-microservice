package com.module.autographs.carregistration.microservice.util;

public class Constants {

    // HTTP STATUS CODES
    public static final String HTTP_RESPONSE_CODE_OK = "200";
    public static final String HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR = "500";

    // API CONSTANTS ---------------------------------------------------

    // 1 - NEW CAR REGISTRATIONS
    public static final String GET_API_PATH = "/getAllNewCarRegistrationsData";
    public static final String POST_API_PATH = "/addNewCarRegistrationsData";
    public static final String DELETE_ALL_API_PATH = "/deleteAllNewCarRegistrationsData";

    // 2 - NEW CAR REGISTRATIONS BY FUEL TYPE
    public static final String GET_API_PATH_BY_FUEL_TYPE = "/getAllNewCarRegistrationsByFuelTypeData";
    public static final String POST_API_PATH_BY_FUEL_TYPE = "/addNewCarRegistrationsByFuelTypeData";
    public static final String DELETE_ALL_API_PATH_BY_FUEL_TYPE = "/deleteAllNewCarRegistrationsByFuelTypeData";

    // 3 - NEW CAR REGISTRATIONS BY SALES TYPE
    public static final String GET_API_PATH_BY_SALES_TYPE = "/getAllNewCarRegistrationsBySalesTypeData";
    public static final String POST_API_PATH_BY_SALES_TYPE = "/addNewCarRegistrationsBySalesTypeData";
    public static final String DELETE_ALL_API_PATH_BY_SALES_TYPE = "/deleteAllNewCarRegistrationsBySalesTypeData";


    // SWAGGER CONSTANTS ---------------------------------------------------

    // 1 - NEW CAR REGISTRATIONS
    // GET API
    public static final String SWAGGER_GET_API_SUMMARY = "GET API - New Car Registration Data Summary.";
    public static final String SWAGGER_GET_API_SUCCESS = "GET API - New Car Registration Data Fetched Successfully.";
    public static final String SWAGGER_GET_API_NO_DATA_FOUND = "GET API - New Car Registration Data Not Available.";

    // POST API
    public static final String SWAGGER_POST_API_SUMMARY = "POST API - New Car Registration Data Summary.";
    public static final String SWAGGER_POST_API_SUCCESS = "POST API - New Car Registration Data Added Successfully.";
    public static final String SWAGGER_POST_API_FAILURE = "POST API - Failure Occurred While Adding New Car Registration data.";

    // DELETE API
    public static final String SWAGGER_DELETE_API_SUMMARY = "DELETE API - New Car Registration Data Summary.";
    public static final String SWAGGER_DELETE_API_SUCCESS = "DELETE API - New Car Registration Data Deleted Successfully.";
    public static final String SWAGGER_DELETE_API_FAILURE = "DELETE API - Failure occurred while deleting New Car Registration data.";

    // 2 - NEW CAR REGISTRATIONS BY FUEL TYPE
    // GET API
    public static final String SWAGGER_GET_API_BY_FUEL_TYPE_SUMMARY = "GET API - New Car Registration By Fuel Type Data Summary.";
    public static final String SWAGGER_GET_API_BY_FUEL_TYPE_SUCCESS = "GET API - New Car Registration By Fuel Type Data Fetched Successfully.";
    public static final String SWAGGER_GET_API_BY_FUEL_TYPE_NO_DATA_FOUND = "GET API - New Car Registration By Fuel Type Data Not Available.";

    // POST API
    public static final String SWAGGER_POST_API_BY_FUEL_TYPE_SUMMARY = "POST API - New Car Registration By Fuel Type Data Summary.";
    public static final String SWAGGER_POST_API_BY_FUEL_TYPE_SUCCESS = "POST API - New Car Registration By Fuel Type Data Added Successfully.";
    public static final String SWAGGER_POST_API_BY_FUEL_TYPE_FAILURE = "POST API - Failure Occurred While Adding New Car Registration Data By Fuel Type.";

    // DELETE API
    public static final String SWAGGER_DELETE_API_BY_FUEL_TYPE_SUMMARY = "DELETE API - New Car Registration By Fuel Type Data Summary.";
    public static final String SWAGGER_DELETE_API_BY_FUEL_TYPE_SUCCESS = "DELETE API - New Car Registration By Fuel Type Data Deleted Successfully.";
    public static final String SWAGGER_DELETE_API_BY_FUEL_TYPE_FAILURE = "DELETE API - Failure Occurred While Deleting New Car Registration Data By Fuel Type.";

    // 3 - NEW CAR REGISTRATIONS BY SALES TYPE
    // GET API
    public static final String SWAGGER_GET_API_BY_SALES_TYPE_SUMMARY = "GET API - New Car Registration By Sales Type Data Summary.";
    public static final String SWAGGER_GET_API_BY_SALES_TYPE_SUCCESS = "GET API - New Car Registration By Sales Type Data Fetched Successfully.";
    public static final String SWAGGER_GET_API_BY_SALES_TYPE_NO_DATA_FOUND = "GET API - New Car Registration By Sales Type Data Not Available.";

    // POST API
    public static final String SWAGGER_POST_API_BY_SALES_TYPE_SUMMARY = "POST API - New Car Registration By Sales Type Data Summary.";
    public static final String SWAGGER_POST_API_BY_SALES_TYPE_SUCCESS = "POST API - New Car Registration By Sales Type Data Added Successfully.";
    public static final String SWAGGER_POST_API_BY_SALES_TYPE_FAILURE = "POST API - Failure Occurred While Adding New Car Registration Data By Sales Type.";

    // DELETE API
    public static final String SWAGGER_DELETE_API_BY_SALES_TYPE_SUMMARY = "DELETE API - New Car Registration By Sales Type Data Summary.";
    public static final String SWAGGER_DELETE_API_BY_SALES_TYPE_SUCCESS = "DELETE API - New Car Registration By Sales Type Data Deleted Successfully.";
    public static final String SWAGGER_DELETE_API_BY_SALES_TYPE_FAILURE = "DELETE API - Failure Occurred While Deleting New Car Registration Data By Sales Type.";

    // LOGGER CONSTANTS ---------------------------------------------------
    public static final String LOGGER_GET_API_SUCCESS = "NewCarRegistrationsRestController : LOGGER : GET API : Data Fetch Success";
    public static final String LOGGER_GET_API_FAILURE = "NewCarRegistrationsRestController : LOGGER : GET API : Data Fetch Failure";
    public static final String LOGGER_POST_API_SUCCESS = "NewCarRegistrationsRestController : LOGGER : POST API : Data Adding Success";
    public static final String LOGGER_POST_API_FAILURE = "NewCarRegistrationsRestController : LOGGER : POST API : Data Adding Failure";
    public static final String LOGGER_DELETE_API_SUCCESS = "NewCarRegistrationsRestController : LOGGER : DELETE API : Data Deleting Success";

    public static final String LOGGER_GET_API_BY_FUEL_TYPE_SUCCESS = "NewCarRegistrationsByFuelTypeRestController : LOGGER : GET API : Data Fetch Success";
    public static final String LOGGER_GET_API_BY_FUEL_TYPE_FAILURE = "NewCarRegistrationsByFuelTypeRestController : LOGGER : GET API : Data Fetch Failure";
    public static final String LOGGER_POST_API_BY_FUEL_TYPE_SUCCESS = "NewCarRegistrationsByFuelTypeRestController : LOGGER : POST API : Data Adding Success";
    public static final String LOGGER_POST_API_BY_FUEL_TYPE_FAILURE = "NewCarRegistrationsByFuelTypeRestController : LOGGER : POST API : Data Adding Failure";
    public static final String LOGGER_DELETE_API_BY_FUEL_TYPE_SUCCESS = "NewCarRegistrationsByFuelTypeRestController : LOGGER : DELETE API : Data Deleting Success";

    public static final String LOGGER_GET_API_BY_SALES_TYPE_SUCCESS = "NewCarRegistrationsBySalesTypeRestController : LOGGER : GET API : Data Fetch Success";
    public static final String LOGGER_GET_API_BY_SALES_TYPE_FAILURE = "NewCarRegistrationsBySalesTypeRestController : LOGGER : GET API : Data Fetch Failure";
    public static final String LOGGER_POST_API_BY_SALES_TYPE_SUCCESS = "NewCarRegistrationsBySalesTypeRestController : LOGGER : POST API : Data Adding Success";
    public static final String LOGGER_POST_API_BY_SALES_TYPE_FAILURE = "NewCarRegistrationsBySalesTypeRestController : LOGGER : POST API : Data Adding Failure";
    public static final String LOGGER_DELETE_API_BY_SALES_TYPE_SUCCESS = "NewCarRegistrationsBySalesTypeRestController : LOGGER : DELETE API : Data Deleting Success";

}