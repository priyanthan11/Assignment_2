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
        Log.getInstance().addEvent("A Worker has been created");
    }
    
    // Methods
    public void processNextCustomer()
    {
        if(cus_queue.isEmpty())
        {
            Log.getInstance().addEvent("No customers in the queue");
            
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
        Log.getInstance().addEvent("A new customer: "+cus_det[1] +" has been added");
        cus_queue.addCustomerToQueue(new Customer(cus_det[0],cus_det[1],cus_det[2],cus_det[3],cus_det[4]));  
    }
    
    public void addParcel(String[] par_det)
    {
        //String[] par_det = parcelDetails.poll();
        Log.getInstance().addEvent("A new parcel: "+par_det[0] +" has been added");
        parcelMap.addParcel(new Parcel(par_det[0],Status.valueOf(par_det[1]),Integer.parseInt(par_det[2]),Double.parseDouble(par_det[3]),LocalDate.parse(par_det[4])));
            
    }
    
    public ArrayList<String> getCustomerName()
    {
      ArrayList<String> cus_name = new ArrayList<>();
        for(Customer costomer : cus_queue)
        {
            cus_name.add(costomer.getName());
        }
        Log.getInstance().addEvent("Gethered all getCustomerName");
        return cus_name;
    }
    
    public Customer getCustomerDetails(String Name)
    {
        
        for(Customer customer : cus_queue)
        {
            if(customer.getName() == Name)
            {
                Log.getInstance().addEvent("Customer: "+Name+" has been requested ");
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
      Log.getInstance().addEvent("Gethered all parcelID");
      return cus_name;
    }
    
    public Parcel getParcel(String key)
    {
        Log.getInstance().addEvent("Parcel ID:"+key+" has been Requested:");
        return parcelMap.getParcelByID(key);
    }
    
    public void removeCustomer()
    {
        Customer done_cus;
        done_cus =cus_queue.poll(); 
        String parcel_ID = done_cus.getParcelID();
        removeParcel(parcel_ID);
        addCollectedDetails(done_cus);
        Log.getInstance().addEvent("Customer: "+done_cus+ " Has been remove from waiting Queue" );  
    }
    public void removeParcel(String key)
    {
        parcelMap.removeParcel(key);
        Log.getInstance().addEvent("Parcel: "+key+" has been removed");
    }
    public void addCollectedDetails(Customer colleced_cus)
    {
        Log.getInstance().addEvent("Customer: "+colleced_cus.getFullName()+" Collected his/her's parcel: "+colleced_cus.getParcelID());
    }
    
    
}
