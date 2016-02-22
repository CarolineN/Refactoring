package com.refactor;
/**
 * Created by Caroline on 2/21/2016.
 */

import java.util.ArrayList;

public class CustomerDepositAccount extends CustomerAccount
{
    double interestRate;

    public CustomerDepositAccount()
    {
        super();
        this.interestRate = 0;
    }

    public CustomerDepositAccount(double interestRate, String number, double balance, ArrayList<AccountTransaction> transactionList)
    {
        super(number, balance, transactionList);
        this.interestRate = interestRate;
    }
    public static void addDepositAccount(Customer customer, ArrayList<Customer>customerList){
    	double balance = 0, interest = 0;
    	String number = String.valueOf("D" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
        	
    	CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance, transactionList);
    	
    	customer.getAccounts().add(deposit);
    	
    }

    public double getInterestRate()
    {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }



}