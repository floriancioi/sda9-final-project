package com.finalproject.entities;


import org.iban4j.Iban;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserAccount implements Serializable {

    private String ibanBankAcount;
    private String Sold;

    public String getBankAccount() {
        return ibanBankAcount;
    }

    public void setBankAccount(String bankAccount) {
        this.ibanBankAcount= bankAccount;
    }

    public String getSold() {
        return Sold;
    }

    public void setSold(String sold) {
        Sold = sold;
    }



}
