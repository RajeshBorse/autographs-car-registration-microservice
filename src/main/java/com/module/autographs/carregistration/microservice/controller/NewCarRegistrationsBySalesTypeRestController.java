package com.module.autographs.carregistration.microservice.controller;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationBySalesTypeDataModel;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationBySalesTypeRepository;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationBySalesTypeService;
import com.module.autographs.carregistration.microservice.util.Constants;
import com.module.autographs.carregistration.microservice.util.ObjectMapperUtils;
import com.module.autographs.carregistration.microservice.dto.NewCarRegistrationBySalesTypeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/newCarRegistrations")
@Tag(name = "NewCarRegistrations")

public class NewCarRegistrationsBySalesTypeRestController {

    @Autowired
    private NewCarRegistrationBySalesTypeService newCarRegistrationBySalesTypeService;

    @Autowired
    private NewCarRegistrationBySalesTypeRepository newCarRegistrationBySalesTypeRepository;

    @GetMapping(value = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_GET_API_PATH)
    @Operation(summary = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_GET_SUMMARY, responses = {@ApiResponse(description = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_SUCCESS, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewCarRegistrationBySalesTypeDTO.class))), @ApiResponse(description = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_NO_DATA_FOUND, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content)})
    public List<NewCarRegistrationBySalesTypeDTO> getNewCarRegistrationBySalesTypeData() {
        List<NewCarRegistrationBySalesTypeDTO> newCarRegistrationBySalesTypeDTOList = ObjectMapperUtils.mapAll(newCarRegistrationBySalesTypeService.findAll(), NewCarRegistrationBySalesTypeDTO.class);
        if (newCarRegistrationBySalesTypeDTOList.size() > 0) {
            return ResponseEntity.ok(newCarRegistrationBySalesTypeDTOList).getBody();
        } else {
            throw new ResponseStatusException(HttpStatus.OK, Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_NO_DATA_FOUND);
        }
    }

    @PostMapping(value = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_POST_API_PATH)
    @Operation(summary = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_POST_SUMMARY, responses = {@ApiResponse(description = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_ADD_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationBySalesTypeDTO.class))), @ApiResponse(description = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_ADD_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> addCarBySalesTypeData(@RequestBody List<NewCarRegistrationBySalesTypeDTO> newCarRegistrationBySalesTypeDTOList) {
        List<NewCarRegistrationBySalesTypeDataModel> newCarRegistrationBySalesTypeDataModelsList = newCarRegistrationBySalesTypeService.addNewCarRegistrationBySalesTypeData(ObjectMapperUtils.mapAll(newCarRegistrationBySalesTypeDTOList, NewCarRegistrationBySalesTypeDataModel.class));
        if (newCarRegistrationBySalesTypeDataModelsList.size() > 0) {
            return ResponseEntity.ok(Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_ADD_SUCCESS);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_ADD_FAILURE);
        }
    }

    @DeleteMapping(value = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_DELETE_ALL_API_PATH)
    @Operation(summary = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_DELETE_ALL_SUMMARY, responses = {@ApiResponse(description = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_DELETE_ALL_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = NewCarRegistrationBySalesTypeDTO.class))), @ApiResponse(description = Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_DELETE_ALL_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> deleteAllCarBySalesTypeData() {
        newCarRegistrationBySalesTypeRepository.deleteAll();
        return ResponseEntity.ok(Constants.NEW_CAR_REGISTRATION_BY_SALES_TYPE_DELETE_ALL_SUCCESS);
    }

}
