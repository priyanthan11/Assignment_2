/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;


/**
 *
 * @author priya
 */
public class ManageCustomer implements ActionListener{
    
    private ArrayList<Customer> customerList; // Stores customers
    private JFrame parentFrame; // Reference to the parent frame
    JDialog dialog;
    private JComboBox<String> CustomerCombo;
     private JComboBox<String> parcelCombo;
    
        
    
    // Create input fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        
        JLabel surnameLabel = new JLabel("Surname:");
        JTextField surnameField = new JTextField();
        
        JLabel contactLabel = new JLabel("Contact Info:");
        JTextField contactField = new JTextField();
        
        JLabel customerIDLabel = new JLabel("Customer ID:");
        JTextField customerIDField = new JTextField();
        
        JLabel parcelIDLabel = new JLabel("Parcel ID:");
        JTextField parcelIDField = new JTextField();
        
        JLabel pIDLabel = new JLabel("P_ID:");
        JTextField pIDField = new JTextField();
        
        JLabel statusLabel = new JLabel("Status:");
        JComboBox<String> statusCombo = new JComboBox<>();
        
        JLabel dimensionsLabel = new JLabel("Dimensions (int):");
        JTextField dimensionsField = new JTextField();
        
        JLabel weightLabel = new JLabel("Weight (double):");
        JTextField weightField = new JTextField();
        
        JLabel daysInDepotLabel = new JLabel("Days in Depot:");
        JTextField daysInDepotField = new JTextField();
        
        
        // Add and Delete buttons
        JButton addButton = new JButton("Add Customer");
        JButton deleteButton = new JButton("Delete Customer");
    

    public ManageCustomer(JComboBox<String> customerCombo1,JComboBox<String> parcelCombo1) {
        this.customerList = new ArrayList<>();
        //this.parentFrame = parentFrame;
        this.CustomerCombo = customerCombo1;
        this.parcelCombo = parcelCombo1;
        
        this.parentFrame = new JFrame();
        
        Manager manager = new Manager();
        statusCombo.addItem("Select Status");
        for(Status stat : Status.values())
        {
            statusCombo.addItem(stat.toString());
        }
       
    }

    // Show the popup to manage customer details
    public void show() {
        dialog = new JDialog(this.parentFrame, "Manage Customer Details", true);
        nameLabel.setBounds(50,60,150,25);
        nameField.setBounds(150, 60, 140, 25);
        
        surnameLabel.setBounds(50,100,150,25);
        surnameField.setBounds(150,100,140,25);
        
        contactLabel.setBounds(50, 140, 150, 25);
        contactField.setBounds(150, 140, 140, 25);
        
        customerIDLabel.setBounds(50,180,150,25);
        customerIDField.setBounds(150, 180, 140, 25);
        
        parcelIDLabel.setBounds(350, 60, 150, 25);
        parcelIDField.setBounds(450, 60, 140, 25);
        
        statusLabel.setBounds(350, 60,150,25);
        statusCombo.setBounds(450,60,140,25);
        
        dimensionsLabel.setBounds(350,100,150,25);
        dimensionsField.setBounds(450,100,140,25);
        
        weightLabel.setBounds(350,140,150,25);
        weightField.setBounds(450, 140, 140, 25);
        
        daysInDepotLabel.setBounds(350, 180, 150, 25);
        daysInDepotField.setBounds(450, 180, 150, 25);
        
        
        addButton.setBounds(150,260,150,25);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        parentFrame.add(addButton);
        
        deleteButton.setBounds(350, 260, 150, 25);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        //parentFrame.add(deleteButton);
        
        
        
       // Add components to the dialog
        parentFrame.add(nameLabel);
        parentFrame.add(nameField);
        parentFrame.add(surnameLabel);
        parentFrame.add(surnameField);
        parentFrame.add(contactLabel);
        parentFrame.add(contactField);
        //parentFrame.add(customerIDLabel);
        //parentFrame.add(customerIDField);
        //parentFrame.add(parcelIDLabel);
        //parentFrame.add(parcelIDField);
        parentFrame.add(pIDLabel);
        parentFrame.add(pIDField);
        parentFrame.add(statusLabel);
        parentFrame.add(statusCombo);
        parentFrame.add(dimensionsLabel);
        parentFrame.add(dimensionsField);
        parentFrame.add(weightLabel);
        parentFrame.add(weightField);
        //parentFrame.add(daysInDepotLabel);
        //parentFrame.add(daysInDepotField);

        

        //dialog.add(addButton);
       // dialog.add(deleteButton);


       // Center the dialog relative to the parent
        //parentFrame.setLocationRelativeTo(this.parentFrame);

        // Make the dialog visible
        //dialog.setVisible(true);
        
        //parentFrame.dispatchEvent(new WindowEvent(parentFrame, WindowEvent.WINDOW_CLOSING));
        parentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentFrame.setSize(900, 500);
        parentFrame.setLayout(null);
        parentFrame.setVisible(true);
        
    }
    
    public void addCustomer()
    {
        if(!nameField.getText().trim().isEmpty() && 
                !surnameField.getText().trim().isEmpty()&& 
                !contactField.getText().trim().isEmpty() && 
                !dimensionsField.getText().trim().isEmpty()&&
                !weightField.getText().trim().isEmpty()&&
                !statusCombo.getSelectedItem().equals("Select Status"))
        {
            
            Manager manager = new Manager();
            String[] customerDetail = new String[5];
            String[] parcelDetail = new String[9];
        
            customerDetail[0] = nameField.getText();
            customerDetail[1] = surnameField.getText();
            customerDetail[2] = contactField.getText();
            customerDetail[3] = manager.getWorker().getUniqueCustomerID();
            customerDetail[4] = manager.getWorker().getUniqueParcelID();
            // add parcel
            parcelDetail[0] = customerDetail[4]; // Parcel ID associate with Customer
            parcelDetail[1] = (String)statusCombo.getSelectedItem();
            parcelDetail[2] = dimensionsField.getText();
            parcelDetail[3] = weightField.getText();
            parcelDetail[4] = LocalDate.now().toString();
            
            this.CustomerCombo.removeAll();
            manager.getWorker().addCustomer(customerDetail);
            manager.getWorker().addParcel(parcelDetail);
            for(Customer customer : manager.getWorker().getCustomers())
            {
                this.CustomerCombo.addItem(customer.getFullName());
            }
            this.parcelCombo.removeAll();
            ArrayList<String> parcelID = manager.getWorker().getParcelID();
            for(String parID : parcelID)
            {
                parcelCombo.addItem(parID);
            }
            //manager.getWorker().update( manager.getWorker().getComboBox());
        }
        System.out.println("Field Cannot be empty");
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton)
        {
            addCustomer();
            
        }
    }
}

