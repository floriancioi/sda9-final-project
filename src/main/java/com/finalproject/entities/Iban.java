package com.finalproject.entities;



public class Iban {

     private String countryCode;
     private String bankCode;
     private String accountNumber;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Iban(String countryCode, String bankCode, String accountNumber) {
        this.countryCode = countryCode;
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Iban{" +
                 countryCode +
                 bankCode +
                 accountNumber  +
                '}';
    }
}
