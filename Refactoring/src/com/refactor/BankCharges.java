package com.refactor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BankCharges extends Menu  {
	public static void bankChargesCalculation(CustomerAccount acc, JFrame f){
		String euro = "\u20ac";
	 	if(acc instanceof CustomerDepositAccount)
		{
		JOptionPane.showMessageDialog(f, "25" + euro + " deposit account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
		acc.setBalance(acc.getBalance()-25);
		JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
		}

		if(acc instanceof CustomerCurrentAccount)
		{
		JOptionPane.showMessageDialog(f, "15" + euro + " current account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
		acc.setBalance(acc.getBalance()-25);
		JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void interest(){
		boolean loop = true;
		boolean found = false;
	if(customerList.isEmpty())
		{
		emptyList();	
	}
		else
		{
	    while(loop)
	    {
	    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Apply Interest to:");
	    
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
	    	adminMenu();
	    	JComboBox<String> box = new JComboBox<String>();
		    for (int i =0; i < customer.getAccounts().size(); i++)
		    {
		    	box.addItem(customer.getAccounts().get(i).getNumber());
		    }
			box.getSelectedItem();
			JPanel boxPanel = new JPanel();
			JLabel label = new JLabel("Select an account to apply interest to:");
			boxPanel.add(label);
			boxPanel.add(box);
			JPanel buttonPanel = new JPanel();
			JButton continueButton = new JButton("Apply Interest");
			JButton returnButton = new JButton("Return");
			buttonPanel.add(continueButton);
			buttonPanel.add(returnButton);
			Container content = f.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			
			content.add(boxPanel);
			content.add(buttonPanel);
			if(customer.getAccounts().isEmpty())
				{
					JOptionPane.showMessageDialog(f, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					f.dispose();
					admin();
				}
				else
				{
				
			for(int i = 0; i < customer.getAccounts().size(); i++)
		    {
		    	if(customer.getAccounts().get(i).getNumber() == box.getSelectedItem() )
		    	{
		    		acc = customer.getAccounts().get(i);
		    	}
		    }
			continueButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					String euro = "\u20ac";
				 	double interest = 0;
				 	boolean loop = true;
				 	
				 	while(loop)
				 	{
					String interestString = JOptionPane.showInputDialog(f, "Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");//the isNumeric method tests to see if the string entered was numeric. 
					if(isNumeric(interestString))
					{
						
						interest = Double.parseDouble(interestString);
						loop = false;
						
						acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest/100)));
						
						JOptionPane.showMessageDialog(f, interest + "% interest applied. \n new balance = " + acc.getBalance() + euro ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
					}else
					{
						JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					}
					}
					
					f.dispose();				
				admin();				
				}		
		     });
			
			returnButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();		
					menuStart();				
				}
		     });	
			
				}}}}
	}
	public void bankCharges(){
		boolean loop = true;
		boolean found = false;
	if(customerList.isEmpty())
		{
			emptyList();
		}else{
	    while(loop)
	    {
	    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Apply Charges to:");
	    
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
	    	adminMenu();
	    	JComboBox<String> box = new JComboBox<String>();
		    for (int i =0; i < customer.getAccounts().size(); i++)
		    {
		    box.addItem(customer.getAccounts().get(i).getNumber());
		    }
			box.getSelectedItem();
			JPanel boxPanel = new JPanel();
			boxPanel.add(box);
			JPanel buttonPanel = new JPanel();
			JButton continueButton = new JButton("Apply Charge");
			JButton returnButton = new JButton("Return");
			buttonPanel.add(continueButton);
			buttonPanel.add(returnButton);
			Container content = f.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			
			content.add(boxPanel);
			content.add(buttonPanel);
			if(customer.getAccounts().isEmpty())
				{
					emptyList();
				}
				else
				{
				
			for(int i = 0; i < customer.getAccounts().size(); i++)
		    {
		    	if(customer.getAccounts().get(i).getNumber() == box.getSelectedItem() )
		    	{
		    		acc = customer.getAccounts().get(i);
		    	}
		    }
				continueButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					BankCharges.bankChargesCalculation(acc,f);// The new class BankCharges handles this bit
					f.dispose();				
					admin();				
				}		
		     });
				
			
			returnButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();		
					menuStart();				
				}});	
			}}}}
	}
	public void lodgement(){
		boolean loop = true;
		boolean on = true;
		double balance = 0;

		if(acc instanceof CustomerCurrentAccount)
		{
			int count = 3;
			int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
			loop = true;
			
			while(loop)
			{
				if(count == 0)
				{
					JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
					((CustomerCurrentAccount) acc).getAtm().setValid(false);
					customer(e); 
					loop = false;
					on = false;
				}
				
				String Pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
				int i = Integer.parseInt(Pin);
				
			   if(on)
			   {
				if(checkPin == i)
				{
					loop = false;
					JOptionPane.showMessageDialog(f, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else
				{
					count --;
					JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);					
				}
			
			}
			}
	
			
		}		if(on == true)
				{
			String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to lodge:");//the isNumeric method tests to see if the string entered was numeric. 
			if(isNumeric(balanceTest))
			{
				
				balance = Double.parseDouble(balanceTest);
				loop = false;
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			}
			
		
		String euro = "\u20ac";
		 acc.setBalance(acc.getBalance() + balance);
		// String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		 Date date = new Date();
		 String date2 = date.toString();
		 String type = "Lodgement";
			double amount = balance;
			AccountTransaction transaction = new AccountTransaction(date2, type, amount);
			acc.getTransactionList().add(transaction);
			
		 JOptionPane.showMessageDialog(f, balance + euro + " added do you account!" ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
		 JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
		}

	}
	public void withdraw(){
		boolean loop = true;
		boolean on = true;
		double withdraw = 0;

		if(acc instanceof CustomerCurrentAccount)
		{
			int count = 3;
			int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
			loop = true;
			
			while(loop)
			{
				if(count == 0)
				{
					JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
					((CustomerCurrentAccount) acc).getAtm().setValid(false);
					customer(e); 
					loop = false;
					on = false;
				}
				
				String Pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
				int i = Integer.parseInt(Pin);
				
			   if(on)
			   {
				if(checkPin == i)
				{
					loop = false;
					JOptionPane.showMessageDialog(f, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else
				{
					count --;
					JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);		
				
				}
			
			}
			}
}		if(on == true)
				{
			String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to withdraw (max 500):");//the isNumeric method tests to see if the string entered was numeric. 
			if(isNumeric(balanceTest))
			{
				
				withdraw = Double.parseDouble(balanceTest);
				loop = false;
			}
			else
			{
				JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			}
			if(withdraw > 500)
			{
				JOptionPane.showMessageDialog(f, "500 is the maximum you can withdraw at a time." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				withdraw = 0;
			}
			if(withdraw > acc.getBalance())
			{
				JOptionPane.showMessageDialog(f, "Insufficient funds." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				withdraw = 0;					
			}
		
		String euro = "\u20ac";
		 acc.setBalance(acc.getBalance()-withdraw);
		  Date date = new Date();
		 String date2 = date.toString();
		 String type = "Withdraw";
		double amount = withdraw;
		AccountTransaction transaction = new AccountTransaction(date2, type, amount);
		acc.getTransactionList().add(transaction);
		 JOptionPane.showMessageDialog(f, withdraw + euro + " withdrawn." ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
		 JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
		}
	}
		public void statement(){
			f.dispose();
			f = new JFrame("Customer Menu");
			f.setSize(400, 600);
			f.setLocation(200, 200);
			f.addWindowStateListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) { System.exit(0); }
			});          
			f.setVisible(true);
			
			JLabel label1 = new JLabel("Summary of account transactions: ");
			
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
			
			for (int i = 0; i < acc.getTransactionList().size(); i ++)
			{
				textArea.append(acc.getTransactionList().get(i).toString());
				
			}
			
			textPanel.add(textArea);
			content.removeAll();
			Container content = f.getContentPane();
			content.setLayout(new GridLayout(1, 1));
			content.add(textPanel);
			returnButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();			
				customer(e);				
				}		
		     });	
		}
}
	
