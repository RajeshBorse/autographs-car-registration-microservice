package com.module.autographs.carregistration.microservice.service.impl;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationByFuelTypeDataModel;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationByFuelTypeRepository;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationByFuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewCarRegistrationByFuelTypeServiceImpl implements NewCarRegistrationByFuelTypeService {

    @Autowired
    NewCarRegistrationByFuelTypeRepository newCarRegistrationByFuelTypeRepository;

    @Override
    public List<NewCarRegistrationByFuelTypeDataModel> findAll() {
        return newCarRegistrationByFuelTypeRepository.findAll();
    }

    @Override
    public List<NewCarRegistrationByFuelTypeDataModel> addNewCarRegistrationByFuelTypeData(List<NewCarRegistrationByFuelTypeDataModel> newCarRegistrationDataModelList) {
        return newCarRegistrationByFuelTypeRepository.saveAll(newCarRegistrationDataModelList);
    }

    public List<NewCarRegistrationByFuelTypeDataModel> findAllNewCarRegistrationsByType(String type) {
        List<NewCarRegistrationByFuelTypeDataModel> newCarRegistrationByFuelTypeDataModelsList = newCarRegistrationByFuelTypeRepository.findAllCarRegistrationByFuelTypeByType(type);
        return newCarRegistrationByFuelTypeDataModelsList;
    }

}