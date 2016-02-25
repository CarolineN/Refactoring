package com.refactor;

import javax.swing.JOptionPane;

public class LoginAdministrator extends MenuLayout {
	
	public void loginAdministrator(){
		boolean loop = true;
		boolean cont = false;
	    while(loop)
	    {

	        Object adminUsername = JOptionPane.showInputDialog(f, "Enter Administrator Username:");
            Object adminPassword = JOptionPane.showInputDialog(f, "Enter Administrator Password;");
            while(loop){
                if(!adminUsername.equals("admin") || !adminPassword.equals("admin11"))//search admin list for admin with matching admin username
                {
                    int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username or Password. Try again?", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        loop = true;
                    }
                    else if(reply == JOptionPane.NO_OPTION)
                    {
                        //f1.dispose();
                        loop = false;

                        menuStart();
                    }
                }
                else
                {
                    loop = false;
                    cont = true;
                }
            }
            if(cont)
            {
                //f1.dispose();
                loop = false;
                admin();
            }
	    }
	}

}
