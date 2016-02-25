package com.refactor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Navigate extends Menu {
	public void nav(){
		f.dispose();
		
		if(customerList.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
			admin();// not quite the same as emptyList()
		}
		else
		{

		JButton first, previous, next, last, cancel;
		JPanel gridPanel, buttonPanel, cancelPanel;			

		Container content = getContentPane();
		
		content.setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		gridPanel = new JPanel(new GridLayout(8, 2));
		cancelPanel = new JPanel();
						
		firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
		surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
		pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
		dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
		customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
		passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
		firstNameTextField = new JTextField(20);
		surnameTextField = new JTextField(20);
		pPSTextField = new JTextField(20);
		dOBTextField = new JTextField(20);
		customerIDTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
		
		first = new JButton("First");
		previous = new JButton("Previous");
		next = new JButton("Next");
		last = new JButton("Last");
		cancel = new JButton("Cancel");
		
		firstNameTextField.setText(customerList.get(0).getFirstName());
		surnameTextField.setText(customerList.get(0).getSurname());
		pPSTextField.setText(customerList.get(0).getPPS());
		dOBTextField.setText(customerList.get(0).getDOB());
		customerIDTextField.setText(customerList.get(0).getCustomerID());
		passwordTextField.setText(customerList.get(0).getPassword());
		
		firstNameTextField.setEditable(false);
		surnameTextField.setEditable(false);
		pPSTextField.setEditable(false);
		dOBTextField.setEditable(false);
		customerIDTextField.setEditable(false);
		passwordTextField.setEditable(false);
		
		gridPanel.add(firstNameLabel);
		gridPanel.add(firstNameTextField);
		gridPanel.add(surnameLabel);
		gridPanel.add(surnameTextField);
		gridPanel.add(pPPSLabel);
		gridPanel.add(pPSTextField);
		gridPanel.add(dOBLabel);
		gridPanel.add(dOBTextField);
		gridPanel.add(customerIDLabel);
		gridPanel.add(customerIDTextField);
		gridPanel.add(passwordLabel);
		gridPanel.add(passwordTextField);
		
		buttonPanel.add(first);
		buttonPanel.add(previous);
		buttonPanel.add(next);
		buttonPanel.add(last);
		
		cancelPanel.add(cancel);

		content.add(gridPanel, BorderLayout.NORTH);
		content.add(buttonPanel, BorderLayout.CENTER);
		content.add(cancelPanel, BorderLayout.AFTER_LAST_LINE);
		first.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				position = 0;
				Summary.navigate(customerList, position, firstNameTextField, surnameTextField, pPSTextField, dOBTextField, customerIDTextField, passwordTextField);				
					}		
			     });
		
		previous.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
				if(position < 1)// look at this
				{
					//don't do anything
				}
				else
				{
					position = position - 1;
					Summary.navigate(customerList, position, firstNameTextField, surnameTextField, pPSTextField, dOBTextField, customerIDTextField, passwordTextField);
				}			
					}		
			     });
		
		next.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			
				if(position == customerList.size()-1)// look at this
				{
					//don't do anything
				}
				else
				{
					position = position + 1;
					
				Summary.navigate(customerList, position, firstNameTextField, surnameTextField, pPSTextField, dOBTextField, customerIDTextField, passwordTextField);
				}		
			}		
			     });
		
		last.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			
				position = customerList.size() - 1;
		
				Summary.navigate(customerList, position, firstNameTextField, surnameTextField, pPSTextField, dOBTextField, customerIDTextField, passwordTextField);								
					}		
			     });
		
		cancel.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {				
				dispose();
				admin();
					}		
			     });			
		setContentPane(content);
		setSize(400, 300);
	       setVisible(true);
			}	
	}

}
