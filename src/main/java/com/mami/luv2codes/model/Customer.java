package com.mami.luv2codes.model;


import javax.validation.constraints.*;

public class Customer {


    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is requiered")
    @Min(value = 0 , message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}" , message = "only 5 chrs/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
