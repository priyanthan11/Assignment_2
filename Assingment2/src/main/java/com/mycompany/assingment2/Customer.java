/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author priyanthan
 */
public class Customer extends Person{
    // Attributes 
    private String customerID;
    // Tracks parcel IDs the customer interacted with
    private ArrayList<String> parcelHistory; 
    private String parcelID;
    // Customer Constructor
    public Customer(String name,String surname,String contactInfo, String customerID,String parcelID){
        super(name,surname,contactInfo);
        this.customerID = customerID;
        this.parcelHistory = new ArrayList<>();
        this.parcelID = parcelID; 
    }
    // Getters and setters
    public String getCustomerID(){
        Log.getInstance().addEvent("Customer Id requested");
        return this.customerID;
    }
    public ArrayList<String> getParcelHistory(){
        Log.getInstance().addEvent("Parcel History requested");
        return this.parcelHistory;
    }
    
    // Setters
    public void setCustomerID(String C_ID){
        
        this.customerID = C_ID;
    }
    
    public String getParcelID()
    {
        Log.getInstance().addEvent("Parcel Id requested");
        return this.parcelID;
    }
       
    // Override Methods
    @Override
    public void requestParcelCollection(){
        System.out.println("Customer" + getName()+" is requesting parcel collection");
    }
    
    @Override
    public void trackParcel(String parcelID){
        System.out.println("Customer "+getName()+ " is tracking parcel with ID"+parcelID);
    }
    
    @Override
    public void visitCollectionCenter(){
        System.out.println("Customer "+getName()+" is visiting the collection center");
    }
    
    public void makePayment(double amount){
        System.out.println("Customer "+ getName()+ " has made a payment of £"+ amount);
    }
    
    //toString
    @Override
    public String toString(){
        return super.toString() + ", Customer ID: " + customerID;
    }
}
