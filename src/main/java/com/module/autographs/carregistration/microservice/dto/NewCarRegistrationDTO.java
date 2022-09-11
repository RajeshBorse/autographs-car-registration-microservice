package com.module.autographs.carregistration.microservice.dto;

import org.springframework.data.annotation.Id;

/**
 * rsb34
 */

public class NewCarRegistrationDTO {

    @Id
    private String id;
    private String year;
    private String month;
    private String newCarRegistrationCount;

    public NewCarRegistrationDTO() {
    }

    public NewCarRegistrationDTO(String id, String year, String month, String newCarRegistrationCount) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.newCarRegistrationCount = newCarRegistrationCount;

    }

    @Override
    public String toString() {
        return "NewCarRegistrationDTO{" + "id='" + id + '\'' + ", year='" + year + '\'' + ", month='" + month + '\'' + ", newCarRegistrationCount='" + newCarRegistrationCount + '\'' + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNewCarRegistrationCount() {
        return newCarRegistrationCount;
    }

    public void setNewCarRegistrationCount(String newCarRegistrationCount) {
        this.newCarRegistrationCount = newCarRegistrationCount;
    }

}