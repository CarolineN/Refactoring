package com.refactor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Summary extends Menu {
	
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
	
	public void summaryButton(){
		adminMenu();
		
		JLabel label1 = new JLabel("Summary of all transactions: ");
		
		JPanel returnPanel = new JPanel();
		JButton returnButton = new JButton("Return");
		returnPanel.add(returnButton);
		
		JPanel textPanel = new JPanel();
		
		textPanel.setLayout( new BorderLayout() );
		JTextArea textArea = new JTextArea(40, 20);
		textArea.setEditable(false);
		textPanel.add(label1, BorderLayout.NORTH);
		textPanel.add(textArea, BorderLayout.CENTER);
		textPanel.add(returnButton, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		textPanel.add(scrollPane);
		Summary.displayAll(customerList,acc,textArea);
		textPanel.add(textArea);
		content.removeAll();
		Container content = f.getContentPane();
		content.setLayout(new GridLayout(1, 1));
	//	content.add(label1);
		content.add(textPanel);
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();			
			admin();				
			}		
	     });	
	}	
	
}

