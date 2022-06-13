package net.javaguides.springboot.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserLocationDTO {
    private long userId;
//    private String userEmail;
    private String userFirstName;
//    private String userLastName;
    private String userPassword;

//    private long locationId;
    private String locationPlace;
//    private String locationDescription;
    private double locationLongitude;
//    private double locationLatitude;

    private String occupationName;
    private String occupationDescription;

}
