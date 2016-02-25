package com.refactor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewCustomer extends MenuLayout {
	
	public void newCustomer(){
		f.dispose();		
		f1 = new JFrame("Create New Customer");
		f1.setSize(400, 300);
		f1.setLocation(200, 200);
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});
			Container content = f1.getContentPane();
			content.setLayout(new BorderLayout());
			
			firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
			surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
			pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
			dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
			firstNameTextField = new JTextField(20);
			surnameTextField = new JTextField(20);
			pPSTextField = new JTextField(20);
			dOBTextField = new JTextField(20);
			JPanel panel = new JPanel(new GridLayout(6, 2));
			panel.add(firstNameLabel);
			panel.add(firstNameTextField);
			panel.add(surnameLabel);
			panel.add(surnameTextField);
			panel.add(pPPSLabel);
			panel.add(pPSTextField);
			panel.add(dOBLabel);
			panel.add(dOBTextField);
				
			panel2 = new JPanel();
			add = new JButton("Add");
			
			 add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					
		PPS = pPSTextField.getText();
		firstName = firstNameTextField.getText();
		surname = surnameTextField.getText();
		DOB = dOBTextField.getText();
		password = "";
	
		CustomerID = "ID"+PPS ;
		
	add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f1.dispose();
				
				boolean loop = true;
				while(loop){
				 password = JOptionPane.showInputDialog(f, "Enter 7 character Password;");
				
				 if(password.length() != 7)//Making sure password is 7 characters
				    {
				    	JOptionPane.showMessageDialog(null, null, "Password must be 7 charatcers long", JOptionPane.OK_OPTION);
				    }
				 else
				 {
					 loop = false;
				 }
				}
				ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();
				addCustomers(PPS,surname,firstName,DOB,CustomerID,password,accounts);//this is new
				JOptionPane.showMessageDialog(f, "CustomerID = " + CustomerID +"\n Password = " + password  ,"Customer created.",  JOptionPane.INFORMATION_MESSAGE);
				menuStart();
				
			}
		});	
				}
			});						
			JButton cancel = new JButton("Cancel");					
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f1.dispose();
					menuStart();
				}
			});	
			panel2.add(add);
			panel2.add(cancel);
			content.add(panel, BorderLayout.CENTER);
			content.add(panel2, BorderLayout.SOUTH);
			f1.setVisible(true);		
	}
public void editCustomer(){
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
    Object customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");
    
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
    }
   
    }
	
	f.dispose();
	
	adminMenu();     
	
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
	
	JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	JPanel cancelPanel = new JPanel();
	
	textPanel.add(firstNameLabel);
	textPanel.add(firstNameTextField);
	textPanel.add(surnameLabel);
	textPanel.add(surnameTextField);
	textPanel.add(pPPSLabel);
	textPanel.add(pPSTextField);
	textPanel.add(dOBLabel);
	textPanel.add(dOBTextField);
	textPanel.add(customerIDLabel);
	textPanel.add(customerIDTextField);
	textPanel.add(passwordLabel);
	textPanel.add(passwordTextField);

	firstNameTextField.setText(customer.getFirstName());
	surnameTextField.setText(customer.getSurname());
	pPSTextField.setText(customer.getPPS());
	dOBTextField.setText(customer.getDOB());
	customerIDTextField.setText(customer.getCustomerID());
	passwordTextField.setText(customer.getPassword());	
	
	JButton saveButton = new JButton("Save");
	JButton cancelButton = new JButton("Exit");
	
	cancelPanel.add(cancelButton, BorderLayout.SOUTH);
	cancelPanel.add(saveButton, BorderLayout.SOUTH);
//	content.removeAll();
	Container content = f.getContentPane();
	content.setLayout(new GridLayout(2, 1));
	content.add(textPanel, BorderLayout.NORTH);
	content.add(cancelPanel, BorderLayout.SOUTH);
	
	f.setContentPane(content);
	f.setSize(340, 350);
	f.setLocation(200, 200);
	f.setVisible(true);
	f.setResizable(false);
	
	saveButton.addActionListener(new ActionListener(  ) {
		public void actionPerformed(ActionEvent ae) {
		
			customer.setFirstName(firstNameTextField.getText());
			customer.setSurname(surnameTextField.getText());
			customer.setPPS(pPSTextField.getText());
			customer.setDOB(dOBTextField.getText());
			customer.setCustomerID(customerIDTextField.getText());
			customer.setPassword(passwordTextField.getText());		
			
			JOptionPane.showMessageDialog(null, "Changes Saved.");
				}		
		     });
	
	cancelButton.addActionListener(new ActionListener(  ) {
		public void actionPerformed(ActionEvent ae) {
			f.dispose();
			
			admin();				
		}		
     });		
	}
}
public void deleteCustomer(){
	boolean found = true, loop = true;
	
	if(customerList.isEmpty())
	{
		emptyList();
	}
	else
	{
		 {
			    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Delete:");
			    
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
			    	if(customer.getAccounts().size()>0)
			    	{
			    		JOptionPane.showMessageDialog(f, "This customer has accounts. \n You must delete a customer's accounts before deleting a customer " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			    	}
			    	else
			    	{
			    		Customer.deleteCustomer(customerList,customer,f);
			    	}
			    }
			    }}
}
}
