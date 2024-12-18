/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author priya
 */
public class PackageDetails {
    private Map<String,Parcel> package_details;
    private Customer customer;
    private Parcel parcel;
    
    // Constructor
    public PackageDetails(Customer customer, Parcel parcel)
    {
        this.customer = customer;
        this.parcel = parcel;
        this.package_details = new HashMap<>();
    }
    
    
    // Methods
    public void addParcel(String cus_ID, Parcel parcel)
    {
        String normalizedID = cus_ID.toUpperCase();
        
        package_details.put(normalizedID, parcel);
        Log.getInstance().addEvent("Parcel added: "+ parcel);
    }
    
    public Parcel getParcelByID(String parcelID)
    {
        return package_details.get(parcelID.toUpperCase());
    }
    
    public boolean removeParcel(String parcelID)
    {
        Parcel removed = package_details.remove(parcelID);
        if(removed != null)
        {
            Log.getInstance().addEvent("Parcel removed: "+removed);
            return true;
        }
        return false;
    }
    public boolean isEmpty()
    {
        return package_details.isEmpty();
    }
    
    public Map<String, Parcel> getParcelMap()
    {
        return package_details;
    }
    
}
