/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assingment2;
import java.time.LocalDate;

/**
 *
 * @author priya
 */
public class Manager {

    public static void main(String[] args) {
        /*
        System.out.println("Hello World!");
        
        // Create a parcel
        Parcel parcel = new Parcel("P001", Parcel.Status.PENDING,500,10.5,LocalDate.of(2024,12,14));
        
        // Display parcel details
        System.out.println(parcel);
        
        // Check if the parcel is valid
        System.out.println("Valid Request: "+ parcel.validRequest());
        
        // Update Parcel Status
        parcel.setStatus(Parcel.Status.COLLECTED);
        
        // Calculate storage fee
        System.out.println("Storage Fee: £" + parcel.calculateSorageFee());
        */
        
        // Ini componennts
        QueueofCustomers customerQueue = new QueueofCustomers();
        ParcelMap parcelMap = new ParcelMap();
        Worker worker = new Worker(customerQueue,parcelMap);
        
        // load data
        parcelMap.addParcel(new Parcel("P001",Parcel.Status.PENDING,500,10,java.time.LocalDate.now().minusDays(5)));
        parcelMap.addParcel(new Parcel("P002",Parcel.Status.PENDING,500,5,java.time.LocalDate.now().minusDays(2)));
        customerQueue.addCustomerToQueue(new Customer("Jhon","Doe","jh.doe@mama.com","C123"));
        customerQueue.addCustomerToQueue(new Customer("Jane","Smith","jane.smith@mama.com","C124"));
        
        
        System.out.println(parcelMap.getParcelByID("P001"));
        
        worker.processNextCustomer();
        worker.processNextCustomer();
        
        // Write log to file
        String file_loc = "system_log.txt";
        Log.getInstance().writeLogToFile(file_loc);
    }
}
