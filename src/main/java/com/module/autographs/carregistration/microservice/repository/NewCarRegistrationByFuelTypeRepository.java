package com.module.autographs.carregistration.microservice.repository;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationByFuelTypeDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NewCarRegistrationByFuelTypeRepository extends MongoRepository<NewCarRegistrationByFuelTypeDataModel, String> {

    @Query("{type:'?0'}")
    List<NewCarRegistrationByFuelTypeDataModel> findAllCarRegistrationByFuelTypeByType(String type);
}