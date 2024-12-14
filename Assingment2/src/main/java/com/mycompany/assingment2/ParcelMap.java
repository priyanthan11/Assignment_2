/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author priyanthan
 */
public class ParcelMap {
    private Map<String, Parcel> parcelMap;
    
    // constructor
    public ParcelMap()
    {
        this.parcelMap = new HashMap<>();
    }
    
    // Methods
    public void addParcel(Parcel parcel)
    {
        parcelMap.put(parcel.getParcelID(), parcel);
        Log.getInstance().addEvent("Parcel added: "+ parcel);
    }
    
    public Parcel getParcelByID(String parcelID)
    {
        return parcelMap.get(parcelID);
    }
    
    public boolean removeParcel(String parcelID)
    {
        Parcel removed = parcelMap.remove(parcelID);
        if(removed != null)
        {
            Log.getInstance().addEvent("Parcel removed: "+removed);
            return true;
        }
        return false;
    }
    
    public Map<String, Parcel> getParcelMap()
    {
        return parcelMap;
    }
    
}
