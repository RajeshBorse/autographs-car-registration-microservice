package com.module.autographs.carregistration.microservice.service;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationBySalesTypeDataModel;

import java.util.List;

public interface NewCarRegistrationBySalesTypeService {

    List<NewCarRegistrationBySalesTypeDataModel> findAll();

    List<NewCarRegistrationBySalesTypeDataModel> addNewCarRegistrationBySalesTypeData(List<NewCarRegistrationBySalesTypeDataModel> newCarRegistrationBySalesTypeDataModelList);


    List<NewCarRegistrationBySalesTypeDataModel> findAllNewCarRegistrationBySalesType(String type);


}
