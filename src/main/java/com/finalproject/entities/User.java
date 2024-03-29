package com.finalproject.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //    @NotBlank(message = "First name is mandatory")
    private String firstName;

    //    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    //    @NotBlank(message = "Password is mandatory")
    private String password;

    //    @NotBlank(message = "Email is mandatory")
    private String email;

    //    @NotBlank(message = "Phome number is mandatory")
    private String phoneNumber;

    //    @NotBlank(message = "Username is mandatory")
    private String userName;

    public String getUpdatedOn() {
        return updatedOn;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }


    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updatedOn;

}