package com.module.autographs.carregistration.microservice.controller;

import com.module.autographs.carregistration.microservice.AutographsCarRegistrationApplication;
import com.module.autographs.carregistration.microservice.dto.NewCarRegistrationDTO;
import com.module.autographs.carregistration.microservice.model.NewCarRegistrationDataModel;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationRepository;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationService;
import com.module.autographs.carregistration.microservice.util.Constants;
import com.module.autographs.carregistration.microservice.util.ObjectMapperUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/newCarRegistrations")
@Tag(name = "NewCarRegistrations")

public class NewCarRegistrationsRestController {

    @Autowired
    private NewCarRegistrationService newCarRegistrationService;

    @Autowired
    private NewCarRegistrationRepository newCarRegistrationRepository;

    private static final Logger logger = LogManager.getLogger(AutographsCarRegistrationApplication.class);


    @GetMapping(value = Constants.NEW_CAR_REGISTRATION_GET_API_PATH)
    @Operation(summary = Constants.NEW_CAR_REGISTRATION_GET_SUMMARY, responses = {@ApiResponse(description = Constants.NEW_CAR_REGISTRATION_SUCCESS, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewCarRegistrationDTO.class))), @ApiResponse(description = Constants.NEW_CAR_REGISTRATION_NO_DATA_FOUND, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content)})
    public List<NewCarRegistrationDTO> getNewCarRegistrationData() {
        List<NewCarRegistrationDTO> newCarRegistrationDTOList = ObjectMapperUtils.mapAll(newCarRegistrationService.findAll(), NewCarRegistrationDTO.class);
        if (newCarRegistrationDTOList.size() > 0) {
            logger.info("NewCarRegistrationsRestController : GET API : Data Fetched Successfully");
            System.out.println(newCarRegistrationDTOList);
            return ResponseEntity.ok(newCarRegistrationDTOList).getBody();
        } else {
            logger.info("NewCarRegistrationsRestController : GET API : Data Not Found");
            throw new ResponseStatusException(HttpStatus.OK, Constants.NEW_CAR_REGISTRATION_NO_DATA_FOUND);
        }
    }

    @PostMapping(value = Constants.NEW_CAR_REGISTRATION_POST_API_PATH)
    @Operation(summary = Constants.NEW_CAR_REGISTRATION_POST_SUMMARY, responses = {@ApiResponse(description = Constants.NEW_CAR_REGISTRATION_ADD_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationDTO.class))), @ApiResponse(description = Constants.NEW_CAR_REGISTRATION_ADD_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> addCarData(@RequestBody List<NewCarRegistrationDTO> newCarRegistrationDTOList) {
        List<NewCarRegistrationDataModel> newCarRegistrationDataModelList = newCarRegistrationService.addNewCarRegistrationData(ObjectMapperUtils.mapAll(newCarRegistrationDTOList, NewCarRegistrationDataModel.class));
        if (newCarRegistrationDataModelList.size() > 0) {
            return ResponseEntity.ok(Constants.NEW_CAR_REGISTRATION_ADD_SUCCESS);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.NEW_CAR_REGISTRATION_ADD_FAILURE);
        }
    }

    @DeleteMapping(value = Constants.NEW_CAR_REGISTRATION_DELETE_ALL_API_PATH)
    @Operation(summary = Constants.NEW_CAR_REGISTRATION_DELETE_ALL_SUMMARY, responses = {@ApiResponse(description = Constants.NEW_CAR_REGISTRATION_DELETE_ALL_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationDTO.class))), @ApiResponse(description = Constants.NEW_CAR_REGISTRATION_DELETE_ALL_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> deleteAllCarData() {
        newCarRegistrationRepository.deleteAll();
        return ResponseEntity.ok(Constants.NEW_CAR_REGISTRATION_DELETE_ALL_SUCCESS);
    }

}
