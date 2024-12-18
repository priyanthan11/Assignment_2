/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author priya
 */
public class CustomerList implements Iterable<Customer>{
    private ArrayList<Customer> customerList;

    
    // Constructor 
    public CustomerList()
    {
        this.customerList = new ArrayList<>();
    }
    
    public Customer removeCustomerFromQueue() {
        if (!customerList.isEmpty()) {
            Customer customer = customerList.remove(0); // Removes the first customer
            Log.getInstance().addEvent("Customer removed from queue: " + customer);
            return customer;
        } else {
            Log.getInstance().addEvent("Attempted to remove customer, but queue is empty");
            return null;
        }
    }

    public Customer getNextCustomer() {
        if (!customerList.isEmpty()) {
            return customerList.get(0); // Returns the first customer without removing
        }
        return null;
    }

    public boolean isEmpty() {
        return customerList.isEmpty();
    }

    public int getQueueSize() {
        return customerList.size();
    }

    public Customer peek() {
        return getNextCustomer(); // Same as getNextCustomer()
    }

    public Customer poll() {
        return removeCustomerFromQueue(); // Removes and returns the first customer
    }

    
    // Methods
    public void addCustomerToQueue(Customer customer) {
        customerList.add(customer); // Adds to the end of the ArrayList
        Log.getInstance().addEvent("Customer added to queue: " + customer);
    }
    
  
    @Override
    public Iterator<Customer> iterator() {
        return customerList.iterator();
    }
    
}
