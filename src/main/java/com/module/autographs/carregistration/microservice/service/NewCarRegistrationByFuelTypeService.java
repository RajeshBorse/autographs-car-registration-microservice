package com.module.autographs.carregistration.microservice.service;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationByFuelTypeDataModel;

import java.util.List;

public interface NewCarRegistrationByFuelTypeService {

    List<NewCarRegistrationByFuelTypeDataModel> findAll();

    List<NewCarRegistrationByFuelTypeDataModel> addNewCarRegistrationByFuelTypeData(List<NewCarRegistrationByFuelTypeDataModel> newCarRegistrationByFuelTypeDataModelsList);


    List<NewCarRegistrationByFuelTypeDataModel> findAllNewCarRegistrationsByType(String type);


}
