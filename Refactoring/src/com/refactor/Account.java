package com.refactor;

import javax.swing.JOptionPane;

public class Account extends Menu {
	
	public void account(){
		f.dispose();
		
		if(customerList.isEmpty())
		{
			emptyList();
		}
		else
		{
		boolean loop = true;
		
		boolean found = false;
	
	    while(loop)
	    {
	    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Add an Account to:");
	    
	    for (Customer aCustomer: customerList){
	    	
	    	if(aCustomer.getCustomerID().equals(customerID))
	    	{
	    		found = true;
	    		customer = aCustomer; 	
	    	}					    	
	    }
	    
	    if(found == false)
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    		loop = true;
	    	}
	    	else if(reply == JOptionPane.NO_OPTION)
	    	{
	    		f.dispose();
	    		loop = false;
	    	
	    		admin();
	    	}
	    }
	    else
	    {
	    	loop = false;
	    	//a combo box in an dialog box that asks the admin what type of account they wish to create (deposit/current)
		    String[] choices = { "Current Account", "Deposit Account" };
		    String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
		        "Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]); 
		    
		    if(account.equals("Current Account"))
		    {
		    	//create current account
		    	
		    	CustomerCurrentAccount.addCurrentAccount(customer,customerList);
		    	//JOptionPane.showMessageDialog(f, "Account number = " + number +"\n PIN = " + pin  ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
		    	JOptionPane.showInputDialog(f, "Current Account created.",  JOptionPane.INFORMATION_MESSAGE);
		    	f.dispose();
		    	admin();
		    }
		    
		    if(account.equals("Deposit Account"))
		    {
		    	CustomerDepositAccount.addDepositAccount(customer,customerList);
		    	JOptionPane.showInputDialog(f, "Deposit Account created.",  JOptionPane.INFORMATION_MESSAGE);
		    	
		    	f.dispose();
		    	admin();
		    }
	    
	    }			   
	    }
		}
	}
	public void deleteAccount(){
		boolean found = true, loop = true;
		{
				    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer from which you wish to delete an account");
				    
				    for (Customer aCustomer: customerList){
				    	
				    	if(aCustomer.getCustomerID().equals(customerID))
				    	{
				    		found = true;
				    		customer = aCustomer; 
				    		loop = false;
				    	}					    	
				    }
				    
				    if(found == false)
				    {
				    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
				    	if (reply == JOptionPane.YES_OPTION) {
				    		loop = true;
				    	}
				    	else if(reply == JOptionPane.NO_OPTION)
				    	{
				    		f.dispose();
				    		loop = false;
				    	
				    		admin();
				    	}
				    }  
				    else
				    {
				    	//Here I would make the user select a an account to delete from a combo box. If the account had a balance of 0 then it would be deleted. (I do not have time to do this)
				    }
			}
	}

}
