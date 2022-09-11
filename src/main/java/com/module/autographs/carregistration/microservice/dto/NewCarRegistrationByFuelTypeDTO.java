package com.module.autographs.carregistration.microservice.dto;

import org.springframework.data.annotation.Id;

/**
 * rsb34
 */

public class NewCarRegistrationByFuelTypeDTO {

    @Id
    private String id;
    private String year;
    private String month;
    private String newCarRegistrationByFuelTypeCount;
    private String type;

    private String percentage;

    public NewCarRegistrationByFuelTypeDTO() {
    }

    public NewCarRegistrationByFuelTypeDTO(String id, String year, String month, String newCarRegistrationByFuelTypeCount, String type, String percentage) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.newCarRegistrationByFuelTypeCount = newCarRegistrationByFuelTypeCount;
        this.type = type;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "NewCarRegistrationByFuelTypeDTO{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", newCarRegistrationByFuelTypeCount='" + newCarRegistrationByFuelTypeCount + '\'' +
                ", type='" + type + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
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

    public String getNewCarRegistrationByFuelTypeCount() {
        return newCarRegistrationByFuelTypeCount;
    }

    public void setNewCarRegistrationByFuelTypeCount(String newCarRegistrationByFuelTypeCount) {
        this.newCarRegistrationByFuelTypeCount = newCarRegistrationByFuelTypeCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}