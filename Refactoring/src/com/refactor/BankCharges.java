package com.refactor;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BankCharges {
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
		
						
}
	
