package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public class AUserDto {
    // aUser
    private long aUserId;
//    private String aUserEmail;
    private String aUserFirstName;
//    private String aUserLastName;
    private String aUserPassword;

    // bLocation
//    private long bLocationId;
    private String bLocationPlace;
//    private String bLocationDescription;
    private double bLocationLongitude;
//    private double bLocationLatitude;

    // cOccupation
    private String cOccupationName;
    private String cOccupationDescription;

}
