package com.module.autographs.carregistration.microservice.service.impl;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationDataModel;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationService;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewCarRegistrationServiceImpl implements NewCarRegistrationService {

    @Autowired
    NewCarRegistrationRepository newCarRegistrationRepository;

    @Override
    public List<NewCarRegistrationDataModel> findAll() {
        return newCarRegistrationRepository.findAll();
    }

    @Override
    public List<NewCarRegistrationDataModel> addNewCarRegistrationData(List<NewCarRegistrationDataModel> newCarRegistrationDataModelList) {
        return newCarRegistrationRepository.saveAll(newCarRegistrationDataModelList);
    }

    public List<NewCarRegistrationDataModel> findAllNewCarRegistrationsByType(String type) {
        List<NewCarRegistrationDataModel> newCarRegistrationDataModelList = newCarRegistrationRepository.findAllNewCarRegistrationsByType(type);
        return newCarRegistrationDataModelList;
    }

}