/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

/**
 *
 * @author priya
 */
public class Worker {
    private QueueofCustomers queue;
    private ParcelMap parcelMap;
    
    // constructor
    public Worker(QueueofCustomers queue, ParcelMap parcelMap)
    {
        this.queue = queue;
        this.parcelMap = parcelMap;
    }
    
    // Methods
    public void processNextCustomer()
    {
        if(queue.isEmpty())
        {
            System.out.println("No customers in the queue");
            return;
        }
        Customer customer = queue.getNextCustomer();
        Parcel parcel = parcelMap.getParcelByID(customer.getCustomerID());
    
        if(parcel == null)
        {
            System.out.println("Parcel not found for customer: "+customer.getName());
            Log.getInstance().addEvent("Failed to process customer: "+ customer.getName());
            return;
        }
        double fee = parcel.calculateSorageFee();
        customer.makePayment(fee);
        parcel.updateStatus(Parcel.Status.COLLECTED);
        Log.getInstance().addEvent("Processed customer: " + customer);
        Log.getInstance().addEvent("Parcel collected: " + parcel);
        
        queue.removeCustomerFromQueue();
        
    }
    
    
    
}
