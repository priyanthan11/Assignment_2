/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author priya
 */
public class Worker {
    private QueueofCustomers cus_queue;
    private ParcelMap parcelMap;
    private double calculatedFee;
    
    // constructor
    public Worker(QueueofCustomers List, ParcelMap parcelMap)
    {
        this.cus_queue = List;
        this.parcelMap = parcelMap;
    }
    
    // Methods
    public void processNextCustomer()
    {
        if(cus_queue.isEmpty())
        {
            System.out.println("No customers in the queue");
            return;
        }
        Customer customer = cus_queue.getNextCustomer();
        Parcel parcel = parcelMap.getParcelByID(customer.getCustomerID());
    
        if(parcel == null)
        {
            System.out.println("Parcel not found for customer: "+customer.getName());
            Log.getInstance().addEvent("Failed to process customer: "+ customer.getName());
            return;
        }
        calculatedFee = parcel.calculateSorageFee();
        customer.makePayment(calculatedFee);
        parcel.updateStatus(Status.valueOf("COLLECTED"));
        Log.getInstance().addEvent("Processed customer: " + customer);
        Log.getInstance().addEvent("Parcel collected: " + parcel);
        
        cus_queue.removeCustomerFromQueue();
        
    }
    
    public void addCustomer(String[] cus_det)
    {
        // Create customer
        cus_queue.addCustomerToQueue(new Customer(cus_det[0],cus_det[1],cus_det[2],cus_det[3],cus_det[4]));  
    }
    
    public void addParcel(String[] par_det)
    {
        //String[] par_det = parcelDetails.poll();
        parcelMap.addParcel(new Parcel(par_det[0],Status.valueOf(par_det[1]),Integer.parseInt(par_det[2]),Double.parseDouble(par_det[3]),LocalDate.parse(par_det[4])));
            
    }
    
    public ArrayList<String> getCustomerName()
    {
      ArrayList<String> cus_name = new ArrayList<>();
        for(Customer costomer : cus_queue)
        {
            cus_name.add(costomer.getName());
        }
        return cus_name;
    }
    
    public Customer getCustomerDetails(String Name)
    {
        
        for(Customer customer : cus_queue)
        {
            if(customer.getName() == Name)
            {
                return customer;
            }
        }
        return null;
    }
    
    
    // Parcels
    public ArrayList<String> getParcelID()
    {
      ArrayList<String> cus_name = new ArrayList<>();
      for(Map.Entry<String, Parcel> entry : parcelMap.entrySet())
      {
          cus_name.add(entry.getKey());
      }
        return cus_name;
    }
    
    public Parcel getParcel(String key)
    {
        return parcelMap.getParcelByID(key);
    }
    
}
