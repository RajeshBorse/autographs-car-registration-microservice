package com.module.autographs.carregistration.microservice.service.impl;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationBySalesTypeDataModel;
import com.module.autographs.carregistration.microservice.service.NewCarRegistrationBySalesTypeService;
import com.module.autographs.carregistration.microservice.repository.NewCarRegistrationBySalesTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewCarRegistrationBySalesTypeServiceImpl implements NewCarRegistrationBySalesTypeService {

    @Autowired
    NewCarRegistrationBySalesTypeRepository newCarRegistrationBySalesTypeRepository;

    @Override
    public List<NewCarRegistrationBySalesTypeDataModel> findAll() {
        return newCarRegistrationBySalesTypeRepository.findAll();
    }

    @Override
    public List<NewCarRegistrationBySalesTypeDataModel> addNewCarRegistrationBySalesTypeData(List<NewCarRegistrationBySalesTypeDataModel> newCarRegistrationBySalesTypeDataModelsList) {
        return newCarRegistrationBySalesTypeRepository.saveAll(newCarRegistrationBySalesTypeDataModelsList);
    }

    public List<NewCarRegistrationBySalesTypeDataModel> findAllNewCarRegistrationBySalesType(String type) {
        List<NewCarRegistrationBySalesTypeDataModel> newCarRegistrationBySalesTypeDataModelsList = newCarRegistrationBySalesTypeRepository.findAllCarRegistrationBySalesTypeByType(type);
        return newCarRegistrationBySalesTypeDataModelsList;
    }

}
