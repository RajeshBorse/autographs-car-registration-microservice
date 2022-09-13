package com.module.autographs.carregistration.microservice.controller;

import com.module.autographs.carregistration.microservice.AutographsCarRegistrationApplication;
import com.module.autographs.carregistration.microservice.dto.NewCarRegistrationByFuelTypeDTO;
import com.module.autographs.carregistration.microservice.model.NewCarRegistrationByFuelTypeDataModel;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationByFuelTypeRepository;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationByFuelTypeService;
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

import static com.module.autographs.carregistration.microservice.util.Constants.*;

@RestController
@RequestMapping("/api/v1/newCarRegistrations")
@Tag(name = "NewCarRegistrationsByFuelTypeRestController")

public class NewCarRegistrationsByFuelTypeRestController {

    @Autowired
    private NewCarRegistrationByFuelTypeService newCarRegistrationByFuelTypeService;

    @Autowired
    private NewCarRegistrationByFuelTypeRepository newCarRegistrationByFuelTypeRepository;

    private static final Logger logger = LogManager.getLogger(AutographsCarRegistrationApplication.class);

    @GetMapping(value = Constants.GET_API_PATH_BY_FUEL_TYPE)
    @Operation(summary = Constants.SWAGGER_GET_API_BY_FUEL_TYPE_SUMMARY, responses = {@ApiResponse(description = Constants.SWAGGER_GET_API_BY_FUEL_TYPE_SUCCESS, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewCarRegistrationByFuelTypeDTO.class))), @ApiResponse(description = Constants.SWAGGER_GET_API_BY_FUEL_TYPE_NO_DATA_FOUND, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content)})
    public List<NewCarRegistrationByFuelTypeDTO> getNewCarRegistrationByFuelTypeData() {
        List<NewCarRegistrationByFuelTypeDTO> newCarRegistrationByFuelTypeDTOList = ObjectMapperUtils.mapAll(newCarRegistrationByFuelTypeService.findAll(), NewCarRegistrationByFuelTypeDTO.class);
        if (newCarRegistrationByFuelTypeDTOList.size() > 0) {
            logger.info(LOGGER_GET_API_BY_FUEL_TYPE_SUCCESS);
            return ResponseEntity.ok(newCarRegistrationByFuelTypeDTOList).getBody();
        } else {
            logger.info(LOGGER_GET_API_BY_FUEL_TYPE_FAILURE);
            throw new ResponseStatusException(HttpStatus.OK, Constants.SWAGGER_GET_API_BY_FUEL_TYPE_NO_DATA_FOUND);
        }
    }

    @PostMapping(value = Constants.POST_API_PATH_BY_FUEL_TYPE)
    @Operation(summary = Constants.SWAGGER_POST_API_BY_FUEL_TYPE_SUMMARY, responses = {@ApiResponse(description = Constants.SWAGGER_POST_API_BY_FUEL_TYPE_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationByFuelTypeDTO.class))), @ApiResponse(description = Constants.SWAGGER_POST_API_BY_FUEL_TYPE_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> addCarByFuelTypeData(@RequestBody List<NewCarRegistrationByFuelTypeDTO> newCarRegistrationByFuelTypeDTOList) {
        List<NewCarRegistrationByFuelTypeDataModel> newCarRegistrationByFuelTypeDataModelsList = newCarRegistrationByFuelTypeService.addNewCarRegistrationByFuelTypeData(ObjectMapperUtils.mapAll(newCarRegistrationByFuelTypeDTOList, NewCarRegistrationByFuelTypeDataModel.class));
        if (newCarRegistrationByFuelTypeDataModelsList.size() > 0) {
            logger.info(LOGGER_POST_API_BY_FUEL_TYPE_SUCCESS);
            return ResponseEntity.ok(Constants.SWAGGER_POST_API_BY_FUEL_TYPE_SUCCESS);
        } else {
            logger.info(LOGGER_POST_API_BY_FUEL_TYPE_FAILURE);

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.SWAGGER_POST_API_BY_FUEL_TYPE_FAILURE);
        }
    }

    @DeleteMapping(value = Constants.DELETE_ALL_API_PATH_BY_FUEL_TYPE)
    @Operation(summary = Constants.SWAGGER_DELETE_API_BY_FUEL_TYPE_SUMMARY, responses = {@ApiResponse(description = Constants.SWAGGER_DELETE_API_BY_FUEL_TYPE_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationByFuelTypeDTO.class))), @ApiResponse(description = Constants.SWAGGER_DELETE_API_BY_FUEL_TYPE_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> deleteAllCarByFuelTypeData() {
        logger.info(LOGGER_DELETE_API_BY_FUEL_TYPE_SUCCESS);

        newCarRegistrationByFuelTypeRepository.deleteAll();
        return ResponseEntity.ok(Constants.SWAGGER_DELETE_API_BY_FUEL_TYPE_SUCCESS);
    }

}