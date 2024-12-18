/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.List;

/**
 *
 * @author priya
 */
public class Welcome_Page implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Rest");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("UserID");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();
    
    // Customer List
    JLabel CustomerNames = new JLabel("Customer Name List");
    List customerList = new List();
    //HashMap<String, String> loginInfo = new HashMap<String,String>();
    
    // Parcel List
    JLabel parcel_Names = new JLabel("Parcel Name List");
    List parcelList = new List();
    
    // Show Customer Details
    
    JButton showButton = new JButton("Show Details");
    JLabel customer_ID = new JLabel("Customer ID: ");
    JLabel show_customer_ID = new JLabel("N/A");
    JLabel fname = new JLabel("First Name: ");
    JLabel show_fname = new JLabel("N/A");
    JLabel lname = new JLabel("Last Name: ");
    JLabel show_lname = new JLabel("N/A");
    JLabel customer_info = new JLabel("Customer Info: ");
    JLabel show_customer_info = new JLabel("N/A");
    
    // Show Customer Details
    JLabel parcel_ID = new JLabel("Parcel_ID: ");
    JLabel show_parcel_ID = new JLabel("N/A");
    JLabel status = new JLabel("Parcel Status: ");
    JLabel show_status = new JLabel("N/A");
    JLabel Dimention = new JLabel("Dimention cm³: ");
    JLabel show_Dimention = new JLabel("N/A");
    JLabel weight = new JLabel("Weight Info: ");
    JLabel show_weight_info = new JLabel("N/A");
    JLabel depositDate = new JLabel("Depo Date: ");
    JLabel show_depositDate = new JLabel("N/A");
    JLabel fee = new JLabel("Total Fee: ");
    JLabel show_fee = new JLabel("N/A");
    
    
    Manager manager = new Manager();
    
    /*
    @TODO: List of still to be processed Parcels - done 
    @TODO: Current Queue of Customers 
    @TODO: Details of parcel corrently working with worker
    @TODO: Each pannel should be update when data added or removed
    
    */
      
    
    Welcome_Page()
    {
        //userIDLabel.setBounds(50,100,75,25);
        //userPasswordLabel.setBounds(50,150,75,25);
        
        
        
        
        //customerList.
        CustomerNames.setBounds(50,60,150,25);
        customerList.setBounds(50,100,100,100);
        getCustomerNames();
        frame.add(CustomerNames);
        frame.add(customerList);
        
        
        //customerList.
        parcel_Names.setBounds(50,260,150,25);
        parcelList.setBounds(50,300,100,100);
        getParcelsID();
        frame.add(parcel_Names);
        frame.add(parcelList);
        
        
        // Show the details of selected customer from the list
        // Button
        showButton.setBounds(200,150,110,25);
        showButton.setFocusable(false);
	showButton.addActionListener(this);
        frame.add(showButton);
        // lables
        customer_ID.setBounds(350,60,100,25);
        show_customer_ID.setBounds(450,60,100,25);
        frame.add(customer_ID);
        frame.add(show_customer_ID);
        
        fname.setBounds(350,80,100,25);
        show_fname.setBounds(450,80,100,25);
        frame.add(fname);
        frame.add(show_fname);
        
        lname.setBounds(350,100,100,25);
        show_lname.setBounds(450,100,100,25);
        frame.add(lname);
        frame.add(show_lname);
        
        customer_info.setBounds(350,120,100,25);
        show_customer_info.setBounds(450,120,100,25);
        frame.add(customer_info);
        frame.add(show_customer_info);
        
        // Show the details of parcel associate with selected customer from the list
        
        // Parcels
        parcel_ID.setBounds(350,140,100,25);
        show_parcel_ID.setBounds(450,140,100,25);
        frame.add(parcel_ID);
        frame.add(show_parcel_ID);
        
        status.setBounds(350,160,100,25);
        show_status.setBounds(450,160,100,25);
        frame.add(status);
        frame.add(show_status);
        
        Dimention.setBounds(350,180,100,25);
        show_Dimention.setBounds(450,180,100,25);
        frame.add(Dimention);
        frame.add(show_Dimention);
        
        weight.setBounds(350,200,100,25);
        show_weight_info.setBounds(450,200,100,25);
        frame.add(weight);
        frame.add(show_weight_info);
        
        depositDate.setBounds(350,220,100,25);
        show_weight_info.setBounds(450,220,100,25);
        frame.add(depositDate);
        frame.add(show_depositDate);
        
        fee.setBounds(350,240,100,25);
        show_fee.setBounds(450,240,100,25);
        frame.add(fee);
        frame.add(show_fee);
        
        
        //messageLabel.setBounds(125,250,250,35);
        //messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
	//userIDField.setBounds(125,100,200,25);
        
	//userPasswordField.setBounds(125,150,200,25);
		
	//loginButton.setBounds(125,200,100,25);
	//loginButton.setFocusable(false);
	//loginButton.addActionListener(this);
		
	//resetButton.setBounds(225,200,100,25);
	//resetButton.setFocusable(false);
	//resetButton.addActionListener(this);
        
        
        
	//frame.add(messageLabel);
	//frame.add(userIDField);
	//frame.add(userPasswordField);
	//frame.add(loginButton);
	//frame.add(resetButton);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(620,620);
	frame.setLayout(null);
	frame.setVisible(true);
    }
    
   public void getCustomerNames()
    {
        customerList.removeAll();
        for(String cus : manager.getWorker().getCustomerName())
            customerList.add(cus);
    }
   
   public void getParcelsID()
    {
        parcelList.removeAll();
        for(String parcelID : manager.getWorker().getParcelID())
        {
            System.out.println(parcelID);
            parcelList.add(parcelID);
        }
    }
   
   public void getCustomerDetails()
   {
       // Get the selected customer
            String SelectedName = customerList.getSelectedItem();
            // Null check
            if(SelectedName != null)
            {
                // Get the details of Customer
                Customer selectedCustomer = manager.getWorker().getCustomerDetails(SelectedName);
                show_customer_ID.setText(selectedCustomer.getCustomerID());
                show_fname.setText(selectedCustomer.getName());
                show_lname.setText(selectedCustomer.getSurname());
                show_customer_info.setText(selectedCustomer.getContectInfo()); 
                
                // Get parcel details associate with customer ID
                getParcelDetails();
            }
            
            System.out.println(SelectedName);
   }
    
   public void getParcelDetails()
   {
      
   }
    
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {   
        // Show details
        if(e.getSource() == showButton)
        {
            getCustomerDetails();
        }
    }
     
        
}
