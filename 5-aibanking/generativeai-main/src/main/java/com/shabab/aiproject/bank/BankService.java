package com.shabab.aiproject.bank;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankService {

    public static List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    static List<BankAccount> bankAccountList=new ArrayList<>();



public String openAccount(OpenBankAccount openBankAccount){



BankAccount bankAccount=new BankAccount(openBankAccount.name,openBankAccount.amount(),openBankAccount.phone);
    bankAccountList.add(bankAccount);
    System.out.println("");
    return "done";
}




public String transfer(TransferMoney transferMoney){

var source=bankAccountList.stream().filter(bankAccount -> bankAccount.getAccountNumber().equals(transferMoney.source)).findFirst().get();
var target=bankAccountList.stream().filter(bankAccount -> bankAccount.getAccountNumber().equals(transferMoney.target)).findFirst().get();
source.setBalance(source.getBalance()-transferMoney.amount);
target.setBalance(target.getBalance()+transferMoney.amount);


    return transferMoney.toString();
}




    record OpenBankAccount(String name,String family,String phone,Long amount) {}
    record TransferMoney(String source,String target,Long amount) {}



}

