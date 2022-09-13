package com.module.autographs.carregistration.microservice.controller;

import com.module.autographs.carregistration.microservice.AutographsCarRegistrationApplication;
import com.module.autographs.carregistration.microservice.dto.NewCarRegistrationBySalesTypeDTO;
import com.module.autographs.carregistration.microservice.model.NewCarRegistrationBySalesTypeDataModel;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationBySalesTypeRepository;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationBySalesTypeService;
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
@Tag(name = "NewCarRegistrationsBySalesTypeRestController")

public class NewCarRegistrationsBySalesTypeRestController {

    @Autowired
    private NewCarRegistrationBySalesTypeService newCarRegistrationBySalesTypeService;

    @Autowired
    private NewCarRegistrationBySalesTypeRepository newCarRegistrationBySalesTypeRepository;

    private static final Logger logger = LogManager.getLogger(AutographsCarRegistrationApplication.class);

    @GetMapping(value = Constants.GET_API_PATH_BY_SALES_TYPE)
    @Operation(summary = Constants.SWAGGER_GET_API_BY_SALES_TYPE_SUMMARY, responses = {@ApiResponse(description = Constants.SWAGGER_GET_API_BY_SALES_TYPE_SUCCESS, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewCarRegistrationBySalesTypeDTO.class))), @ApiResponse(description = Constants.SWAGGER_GET_API_BY_SALES_TYPE_NO_DATA_FOUND, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content)})
    public List<NewCarRegistrationBySalesTypeDTO> getNewCarRegistrationBySalesTypeData() {
        List<NewCarRegistrationBySalesTypeDTO> newCarRegistrationBySalesTypeDTOList = ObjectMapperUtils.mapAll(newCarRegistrationBySalesTypeService.findAll(), NewCarRegistrationBySalesTypeDTO.class);
        if (newCarRegistrationBySalesTypeDTOList.size() > 0) {
            logger.info(LOGGER_GET_API_BY_SALES_TYPE_SUCCESS);
            return ResponseEntity.ok(newCarRegistrationBySalesTypeDTOList).getBody();
        } else {
            logger.info(LOGGER_GET_API_BY_SALES_TYPE_FAILURE);
            throw new ResponseStatusException(HttpStatus.OK, Constants.SWAGGER_GET_API_BY_SALES_TYPE_NO_DATA_FOUND);
        }
    }

    @PostMapping(value = Constants.POST_API_PATH_BY_SALES_TYPE)
    @Operation(summary = Constants.SWAGGER_POST_API_BY_SALES_TYPE_SUMMARY, responses = {@ApiResponse(description = Constants.SWAGGER_POST_API_BY_SALES_TYPE_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationBySalesTypeDTO.class))), @ApiResponse(description = Constants.SWAGGER_POST_API_BY_SALES_TYPE_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> addCarBySalesTypeData(@RequestBody List<NewCarRegistrationBySalesTypeDTO> newCarRegistrationBySalesTypeDTOList) {
        List<NewCarRegistrationBySalesTypeDataModel> newCarRegistrationBySalesTypeDataModelsList = newCarRegistrationBySalesTypeService.addNewCarRegistrationBySalesTypeData(ObjectMapperUtils.mapAll(newCarRegistrationBySalesTypeDTOList, NewCarRegistrationBySalesTypeDataModel.class));
        if (newCarRegistrationBySalesTypeDataModelsList.size() > 0) {
            logger.info(LOGGER_POST_API_BY_SALES_TYPE_SUCCESS);

            return ResponseEntity.ok(Constants.SWAGGER_POST_API_BY_SALES_TYPE_SUCCESS);
        } else {
            logger.info(LOGGER_POST_API_BY_SALES_TYPE_FAILURE);

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.SWAGGER_POST_API_BY_SALES_TYPE_FAILURE);
        }
    }

    @DeleteMapping(value = Constants.DELETE_ALL_API_PATH_BY_SALES_TYPE)
    @Operation(summary = Constants.SWAGGER_DELETE_API_BY_SALES_TYPE_SUMMARY, responses = {@ApiResponse(description = Constants.SWAGGER_DELETE_API_BY_SALES_TYPE_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationBySalesTypeDTO.class))), @ApiResponse(description = Constants.SWAGGER_DELETE_API_BY_SALES_TYPE_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> deleteAllCarBySalesTypeData() {
        logger.info(LOGGER_DELETE_API_BY_SALES_TYPE_SUCCESS);

        newCarRegistrationBySalesTypeRepository.deleteAll();

        return ResponseEntity.ok(Constants.SWAGGER_DELETE_API_BY_SALES_TYPE_SUCCESS);
    }

}
