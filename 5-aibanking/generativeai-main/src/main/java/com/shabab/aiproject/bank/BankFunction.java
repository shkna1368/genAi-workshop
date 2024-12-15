package com.shabab.aiproject.bank;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.List;
import java.util.function.Function;


@Configuration(proxyBeanMethods = false)

public class BankFunction {

    @Bean
    @Description("Open bank account with name and phone and balance")
    public Function<BankService.OpenBankAccount, String> openBankAccount(BankService bankService) {


        return bankService::openAccount;
    }


    @Bean
    @Description("fund transfer with source and target and amount")
    public Function<BankService.TransferMoney, String> fundTransfer(BankService bankService) {


        return bankService::transfer;
    }



}
