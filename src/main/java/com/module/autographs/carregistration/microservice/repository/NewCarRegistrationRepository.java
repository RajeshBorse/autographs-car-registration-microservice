package com.module.autographs.carregistration.microservice.repository;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NewCarRegistrationRepository extends MongoRepository<NewCarRegistrationDataModel, String> {

    @Query("{type:'?0'}")
    List<NewCarRegistrationDataModel> findAllNewCarRegistrationsByType(String type);
}