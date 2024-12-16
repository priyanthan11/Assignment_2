/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assingment2;
import java.time.LocalDate;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author priya
 */
public class Manager {
    
    // Load the data
    public static Queue Load_data(String fileName)
    {
        Log.getInstance().addEvent("System Reading Files...");
        Queue<String[]> cus_queue = new LinkedList<>();
        try(BufferedReader my_reader = new BufferedReader(new FileReader(new File(fileName))))
        {
            String line = " ";
          
            while((line = my_reader.readLine()) != null)
            {
                
                Log.getInstance().addEvent("System Loaded Data: " + line);
                
                // split the line into parts
                String[] details = line.split(",");
                if(details.length >= 4)
                {
                   cus_queue.add(details); 
                }
                else
                {
                    Log.getInstance().addEvent("Missing Details in the Soruce file");
                }
                
                
                
                //System.out.println(line);
            }
        }
        catch(Exception e)
        {
            Log.getInstance().addEvent("Somthing went wrong");
            Log.getInstance().addEvent(e.getMessage());
        }
        return cus_queue;
        
    }

    public static void main(String[] args) {
        // Customer File path
        String cus_fileName = "C:/Users/priya/OneDrive - University of Hertfordshire/Modules/Software Arch/Assignment/Assignment_2/Assingment2/src/main/java/com/mycompany/assingment2/Custs.csv";
        // Parcel File path
        String par_fileName = "C:/Users/priya/OneDrive - University of Hertfordshire/Modules/Software Arch/Assignment/Assignment_2/Assingment2/src/main/java/com/mycompany/assingment2/Parcels.csv";
        
        
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
        // Customer List
        Queue<String[]> customerDetails;
        // Customer Queue
        QueueofCustomers cus_queue = new QueueofCustomers();
        // Get Customer Details from csv file
        customerDetails = Load_data(cus_fileName);
        // Iterate the details till end of the data.
        while(!customerDetails.isEmpty())
        {
            
            String[] cus_det = customerDetails.poll();
            // Create customer
            cus_queue.addCustomerToQueue(new Customer(cus_det[0],cus_det[1],cus_det[2],cus_det[3]));
                     
            
            //System.out.println("Customer Name: "+cus_det[0]);
            //System.out.println("Customer Info: "+cus_det[1]);
            //System.out.println("Customer ID: "+cus_det[2]);
            //System.out.println("Customer ID: "+cus_det[3]);
        }
        
        
        // Create Queue for parcel
        Queue<String[]> parcelDetails;
        // Initialize Parcel
        ParcelMap parcelMap = new ParcelMap();
        // Load the data into Queue
        parcelDetails = Load_data(par_fileName);
       
        while(!parcelDetails.isEmpty())
        {
            String[] par_det = parcelDetails.poll();
            System.out.println("Value: "+Status.valueOf(par_det[1]));
            
            //parcelMap.addParcel(new Parcel(par_det[0],Status.valueOf(par_det[1]),int(par_det[2]),double(par_det[3]),LocalDate.parse(par_det[4])));
            parcelMap.addParcel(new Parcel(par_det[0],Status.valueOf(par_det[1]),Integer.parseInt(par_det[2]),Double.parseDouble(par_det[3]),LocalDate.parse(par_det[4])));
                
         }
            
            
        /*
        Iterator<String> it = parcelDetails.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        */
        
        
        
        
        /*
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
        Log.getInstance().writeLogToFile(file_loc);*/
    }

}
