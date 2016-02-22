package com.refactor;


import java.util.ArrayList;

public class CustomerCurrentAccount extends CustomerAccount
{
    ATMCard atm;
    Customer customer;

    public CustomerCurrentAccount()
    {
        super();
        this.atm = null;

    }

    public CustomerCurrentAccount(ATMCard atm, String number, double balance, ArrayList<AccountTransaction> transactionList)
    {
        super(number, balance, transactionList);
        this.atm = atm;
    }
    public static void addCurrentAccount(Customer customer, ArrayList<Customer>customerList){
    	boolean valid = true;
    	double balance = 0;
    	String number = String.valueOf("C" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
    	int randomPIN = (int)(Math.random()*9000)+1000;
           String pin = String.valueOf(randomPIN);
    
           ATMCard atm = new ATMCard(randomPIN, valid);
    	
    	CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance, transactionList);
    	
    	customer.getAccounts().add(current);
    }

    public ATMCard getAtm()
    {
        return this.atm;
    }

    public void setAtm(ATMCard atm)
    {
        this.atm = atm;
    }

}