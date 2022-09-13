package com.module.autographs.carregistration.microservice.controller;

import com.module.autographs.carregistration.microservice.AutographsCarRegistrationApplication;
import com.module.autographs.carregistration.microservice.dto.NewCarRegistrationDTO;
import com.module.autographs.carregistration.microservice.model.NewCarRegistrationDataModel;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationRepository;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationService;
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

import static com.module.autographs.carregistration.microservice.util.Constants.*;

@RestController
@RequestMapping("/api/v1/newCarRegistrations")
@Tag(name = "NewCarRegistrationsRestController")

public class NewCarRegistrationsRestController {

    @Autowired
    private NewCarRegistrationService newCarRegistrationService;

    @Autowired
    private NewCarRegistrationRepository newCarRegistrationRepository;

    private static final Logger logger = LogManager.getLogger(AutographsCarRegistrationApplication.class);


    @GetMapping(value = GET_API_PATH)
    @Operation(summary = SWAGGER_GET_API_SUMMARY, responses = {@ApiResponse(description = SWAGGER_GET_API_SUCCESS, responseCode = HTTP_RESPONSE_CODE_OK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewCarRegistrationDTO.class))), @ApiResponse(description = SWAGGER_GET_API_NO_DATA_FOUND, responseCode = HTTP_RESPONSE_CODE_OK, content = @Content)})
    public List<NewCarRegistrationDTO> getNewCarRegistrationData() {
        List<NewCarRegistrationDTO> newCarRegistrationDTOList = ObjectMapperUtils.mapAll(newCarRegistrationService.findAll(), NewCarRegistrationDTO.class);
        if (newCarRegistrationDTOList.size() > 0) {
            logger.info(LOGGER_GET_API_SUCCESS);
            return ResponseEntity.ok(newCarRegistrationDTOList).getBody();
        } else {
            logger.info(LOGGER_GET_API_FAILURE);
            throw new ResponseStatusException(HttpStatus.OK, SWAGGER_GET_API_NO_DATA_FOUND);
        }
    }

    @PostMapping(value = POST_API_PATH)
    @Operation(summary = SWAGGER_POST_API_SUMMARY, responses = {@ApiResponse(description = SWAGGER_POST_API_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationDTO.class))), @ApiResponse(description = SWAGGER_POST_API_FAILURE, responseCode = HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> addCarData(@RequestBody List<NewCarRegistrationDTO> newCarRegistrationDTOList) {
        List<NewCarRegistrationDataModel> newCarRegistrationDataModelList = newCarRegistrationService.addNewCarRegistrationData(ObjectMapperUtils.mapAll(newCarRegistrationDTOList, NewCarRegistrationDataModel.class));
        if (newCarRegistrationDataModelList.size() > 0) {
            logger.info(LOGGER_POST_API_SUCCESS);
            return ResponseEntity.ok(SWAGGER_POST_API_SUCCESS);
        } else {
            logger.info(LOGGER_POST_API_FAILURE);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, SWAGGER_POST_API_FAILURE);
        }
    }

    @DeleteMapping(value = DELETE_ALL_API_PATH)
    @Operation(summary = SWAGGER_DELETE_API_SUMMARY, responses = {@ApiResponse(description = SWAGGER_DELETE_API_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationDTO.class))), @ApiResponse(description = SWAGGER_DELETE_API_FAILURE, responseCode = HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> deleteAllCarData() {
        logger.info(LOGGER_DELETE_API_SUCCESS);

        newCarRegistrationRepository.deleteAll();
        return ResponseEntity.ok(SWAGGER_DELETE_API_SUCCESS);
    }
}