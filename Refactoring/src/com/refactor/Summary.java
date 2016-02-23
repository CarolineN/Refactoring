package com.refactor;

import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Summary {
	
	public static void displayAll(ArrayList<Customer>customerList, CustomerAccount acc,JTextArea textArea){
		for (int a = 0; a < customerList.size(); a++)//For each customer, for each account, it displays each transaction.
		{
			for (int b = 0; b < customerList.get(a).getAccounts().size(); b ++ )
			{
				acc = customerList.get(a).getAccounts().get(b);
				for (int c = 0; c < customerList.get(a).getAccounts().get(b).getTransactionList().size(); c++)
				{
					
					textArea.append(acc.getTransactionList().get(c).toString());
					//Int total = acc.getTransactionList().get(c).getAmount(); //I was going to use this to keep a running total but I couldnt get it  working.
					
				}				
			}				
		}
	

	}
	public static void navigate(ArrayList<Customer>customerList,int position,JTextField firstNameTextField,JTextField surnameTextField, JTextField pPSTextField,JTextField dOBTextField,JTextField customerIDTextField,JTextField passwordTextField){
		
		firstNameTextField.setText(customerList.get(position).getFirstName());
		surnameTextField.setText(customerList.get(position).getSurname());
		pPSTextField.setText(customerList.get(position).getPPS());
		dOBTextField.setText(customerList.get(position).getDOB());
		customerIDTextField.setText(customerList.get(position).getCustomerID());
		passwordTextField.setText(customerList.get(position).getPassword());
	}
}

