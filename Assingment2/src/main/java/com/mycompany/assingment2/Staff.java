/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

/**
 *
 * @author priyanthan
 */
public class Staff extends Person{
    // Attributes
    private String staffID;
    private String roll; // Could be manager or worker
    
    public Staff(String name, String surname,String contactInfo,String staffID,String roll){
        super(name,surname,contactInfo);
        this.staffID = staffID;
        this.roll = roll;
    }
    
    // Getters
    public String getStaffID(){
        return staffID;
    }
    public String getroll(){
        return roll;
    }
    // setters
    public void setStaffID(String S_ID){
        this.staffID = S_ID;
    }
    public void setRoll(String roll){
        this.roll = roll;
    }
    
        
    // Override Methods
    @Override
    public void requestParcelCollection(){
        System.out.println("Staff" + getName()+" is requesting parcel collection");
    }
    
    @Override
    public void trackParcel(String parcelID){
        System.out.println("Staff "+getName()+ " is tracking parcel with ID"+parcelID);
    }
    
    @Override
    public void visitCollectionCenter(){
        System.out.println("Staff "+getName()+" is visiting the collection center");
    }
    
    public void makePayment(double amount){
        System.out.println("Staff "+ getName()+ " has made a payment of £"+ amount);
    }
    
    //toString
    @Override
    public String toString(){
        return super.toString() + ", Customer ID: " +staffID;
    }
    
}
