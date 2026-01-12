package org.example.library.models.responseModels.parties;

import lombok.Data;

@Data
public class PostalAddress {
    private int id;
    private String houseNumber;
    private String houseNumberSuffix;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private String searchableString;
    private String validFrom;
    private String validTo;

    private Party party;
}
