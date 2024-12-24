/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author priya
 */
public class RemovedCustomer {
    
    //private JList<String> removedCustomerList;
    List removedCustomerlList = new List();
    JFrame frame = new JFrame();
    private ArrayList<String> removedCustomers;
    
    public RemovedCustomer(ArrayList<String> removed_cus)
    {
        this.removedCustomers = removed_cus;
        // Set JFrame properties
        frame.setTitle("Removed Customer");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); // Close only this window
        frame.setLayout(null);
        
        
        for(String name : removedCustomers)
        {
            removedCustomerlList.add(name);
        }
        
        
        removedCustomerlList.setBounds(20,100,140,150);
        frame.add(removedCustomerlList);
        
        
        frame.setVisible(true);

    }
    
}
