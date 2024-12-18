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
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author priya
 */
public class Manager {
    // Create Gloabal Customer QUeue
    // Customer Queue
    private static QueueofCustomers cus_queue = new QueueofCustomers();
    //private static CustomerList cus_List = new CustomerList();
    // Initialize Parcel
    private static ParcelMap parcelMap = new ParcelMap();
    
    private static Worker worker = new Worker(cus_queue,parcelMap);
    
     
    
    
   /* 
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
                // Add to the log
                Log.getInstance().addEvent("System Loaded Data: " + line);
                
                // split the line into parts
                String[] details = line.split(",");
                if(details.length >= 4)
                {
                   cus_queue.add(details); 
                }
                else
                {
                    Log.getInstance().addEvent("Missing Details in the Source file");
                }
            }
        }
        catch(Exception e)
        {
            Log.getInstance().addEvent("Somthing went wrong");
            Log.getInstance().addEvent(e.getMessage());
        }
        return cus_queue; 
    }*/
    
    
    public static ArrayList<String[]> Load_data(String fileName) 
    {
        Log.getInstance().addEvent("System Reading Files...");
        ArrayList<String[]> customerList = new ArrayList<>();

        try (BufferedReader my_reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;

            while ((line = my_reader.readLine()) != null) {
                // Add to the log
                Log.getInstance().addEvent("System Loaded Data: " + line);

                // Split the line into parts
                String[] details = line.split(",");
                if (details.length >= 4) {
                    customerList.add(details); // Add the split array to the list
                } else {
                    Log.getInstance().addEvent("Missing Details in the Source file: " + line);
                }
            }
        } catch (Exception e) {
            Log.getInstance().addEvent("Something went wrong");
            Log.getInstance().addEvent(e.getMessage());
        }

        return customerList;
    }
    
    
    
    public static ArrayList<String[]> sortBySurname(ArrayList<String[]> data) {
        data.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] customer1, String[] customer2) {
                String surname1 = customer1[1].trim(); // Extract surname from first customer
                String surname2 = customer2[1].trim(); // Extract surname from second customer
                return surname1.compareTo(surname2);  // Compare surnames alphabetically
            }
        });
        return data;
    }
       
    public static void prerequisite()
    {
        // Customer File path
        String cus_fileName = "C:/Users/priya/OneDrive - University of Hertfordshire/Modules/Software Arch/Assignment/Assignment_2/Assingment2/src/main/java/com/mycompany/assingment2/Custs.csv";
        // Parcel File path
        String par_fileName = "C:/Users/priya/OneDrive - University of Hertfordshire/Modules/Software Arch/Assignment/Assignment_2/Assingment2/src/main/java/com/mycompany/assingment2/Parcels.csv";
        // Staff File Path
        String sta_fileName = "C:/Users/priya/OneDrive - University of Hertfordshire/Modules/Software Arch/Assignment/Assignment_2/Assingment2/src/main/java/com/mycompany/assingment2/Staff.csv";
        // Customer List
        ArrayList<String[]> customerDetails;
        // Get Customer Details from csv file
        customerDetails = sortBySurname(Load_data(cus_fileName));
        // Iterate the details till end of the data.
        Log.getInstance().addEvent("Worker working on customer details...");
        for(String[] data : customerDetails)
        {
            worker.addCustomer(data);
        }
        Log.getInstance().addEvent("Worker done processing customer details");  
        // Create Queue for parcel
        ArrayList<String[]> parcelDetails;
        // Load the data into Queue
        parcelDetails = sortBySurname(Load_data(par_fileName));
        Log.getInstance().addEvent("Worker working on parcel details...");
        for(String[] data : parcelDetails)
        {
            worker.addParcel(data);
        }
        Log.getInstance().addEvent("Worker done processing parcel details");
        
        
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
        worker.processNextCustomer();*/
        
        // Write log to file
    }
    /*
    TODO: Add Customer - X
    TODO: Remove Customer
    TODO: Add Parcel - X
    TODO: Release Parcel and put it in Collected Queue
    
    public static void addCustomer(String[] cus_det)
    {
        // Create customer
        cus_queue.addCustomerToQueue(new Customer(cus_det[0],cus_det[1],cus_det[2],cus_det[3]));  
    }
    
    public static void addParcel(Queue<String[]> parcelDetails)
    {
        String[] par_det = parcelDetails.poll();
        parcelMap.addParcel(new Parcel(par_det[0],Status.valueOf(par_det[1]),Integer.parseInt(par_det[2]),Double.parseDouble(par_det[3]),LocalDate.parse(par_det[4])));
            
    }
    
    public static void addStaff(Queue<String[]> staffDetails)
    {
        String[] Cus_det = staffDetails.poll();
        
        
        
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
    }*/
    
    
    
    public Worker getWorker()
    {
        return worker;
    }
    public static void main(String[] args) 
    {
        // Begin play
        prerequisite();
        
        
           
        
        
        Welcome_Page wp = new Welcome_Page();
        
        String file_loc = "system_log.txt";
        Log.getInstance().writeLogToFile(file_loc);
    }

}
