package com.shabab.aiproject.bank;

import java.security.SecureRandom;

public class BankAccount {

    private String name;
    private Long balance;
    private String accountNumber;

    private String mobileNumber;



    public BankAccount(String name, Long balance, String mobileNumber) {
        this.name = name;
        this.balance = balance;
        SecureRandom secureRandom = new SecureRandom();
        this.accountNumber = String .valueOf(secureRandom.nextInt(100000000 - 1000000) + 1000000);


        this.mobileNumber = mobileNumber;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }




    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


}
