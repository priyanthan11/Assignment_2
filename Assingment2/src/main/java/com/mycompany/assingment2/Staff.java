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
    
    /*
    Process a customer's parcel by validationg the rquest
    * calculating fees, and updating the parcel's statis.
    *@param customer the customer whose parcel is being processed
    *@param parcel the parcel being proccessed at the moment.
    */
    public void processParcel(Customer customer,Parcel parcel)
    {
        if(parcel.validRequest())
        {
            System.out.println("The parcel processing for customer: "+ customer.getName());
            double fee = parcel.calculateSorageFee();
            System.out.println("Storage fee: £"+fee);
            
            customer.makePayment(fee);
            parcel.updateStatus(Parcel.Status.COLLECTED);
        }
        else
        {
            System.out.println("Parcel"+parcel.getParcelID()+" cannot be processed. Current Status: "+parcel.getStatus());
            
        }
    }
    /*
    *Add a parcel to the collection list
    *@param parcel The parcel to be added to the list
    */
    public void addToCollection(Parcel parcel)
    {
        System.out.println("Staff"+getName()+"add parcel "+ parcel.getParcelID()+" to the collection list");
    }
    
    /*
    *view details of a specific parcel.
    *@param parcel  The parcel whose details are to be viewed
    */
    public void viewParcelDetails(Parcel parcel)
    {
        System.out.println("Parcel Details: "+parcel.toString());
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
