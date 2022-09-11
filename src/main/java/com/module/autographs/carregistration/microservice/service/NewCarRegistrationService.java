package com.module.autographs.carregistration.microservice.service;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationDataModel;

import java.util.List;

public interface NewCarRegistrationService {

    List<NewCarRegistrationDataModel> findAll();

    List<NewCarRegistrationDataModel> addNewCarRegistrationData(List<NewCarRegistrationDataModel> newCarRegistrationDataModelList);

    List<NewCarRegistrationDataModel> findAllNewCarRegistrationsByType(String type);
}