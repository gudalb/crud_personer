package com.example.crud_personer.domain;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person extends RepresentationModel<Person> {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String address;
    private String email;
    private String socialSecurityNumber;
    private String phoneNumber;

    public Person() {
    }

    public Person(String fullName, String address, String email, String socialSecurityNumber, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
