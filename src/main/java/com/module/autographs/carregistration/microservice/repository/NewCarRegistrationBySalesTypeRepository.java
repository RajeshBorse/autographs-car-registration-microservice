package com.module.autographs.carregistration.microservice.repository;

import com.module.autographs.carregistration.microservice.model.NewCarRegistrationBySalesTypeDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NewCarRegistrationBySalesTypeRepository extends MongoRepository<NewCarRegistrationBySalesTypeDataModel, String> {

    @Query("{type:'?0'}")
    List<NewCarRegistrationBySalesTypeDataModel> findAllCarRegistrationBySalesTypeByType(String type);
}