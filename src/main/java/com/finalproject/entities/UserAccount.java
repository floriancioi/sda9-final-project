package com.finalproject.entities;



import javax.persistence.*;
import java.io.Serializable;

@Entity(name="userAccount")
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private long sold;
    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

}
