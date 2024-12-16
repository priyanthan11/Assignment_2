/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author priyanthan
 */
public class Parcel {
    /*
// Enum 
    public enum Status  {
    PENDING(0),
    COLLECTED(1),
    IN_TRANSIT(2),
    LOST(3);
    
    private final int value;
    
    Status(int val)
    {
        this.value = val;
    }
    
    // Method to get an enum from an integer
    public static Status fromInt(int value)
    {
        for(Status sat :Status.values() )
        {
            if(sat.value == value)
            {
                return sat;
            }
        }
        throw new IllegalArgumentException("No enum constant for values: " + value);
        //Log.getInstance().addEvent("No enum constant for values: " + value);
    }
    
    }
    */
    //Attributes
    private String parcelID;
    private Status status;
    private int dimensions; //  cm³
    private double weight; // in KG
    private LocalDate daysInDepot; // Date that pacel arrived
    
    // constructor
    public Parcel(String p_ID, Status status, int dimensions, double weight, LocalDate daysinDepot){
        this.parcelID = p_ID;
        this.status = status;
        this.dimensions = dimensions;
        this.weight = weight;
        this.daysInDepot = daysinDepot;
    }
    
    // Getters and Setters
    public String getParcelID() {
        return parcelID;
    }
    public Status getStatus() {
        return status;
    }
    public int getDimensions() {
        return dimensions;
    }
    public double getWeight() {
        return weight;
    }   
     public LocalDate getDaysInDepot() {
        return daysInDepot;
    }
    
    public void setParcelID(String parcelID) {
        this.parcelID = parcelID;
    }
    public void setStatus(Status status) {
        this.status = status;
    }  
    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setDaysInDepot(LocalDate daysInDepot) {
        this.daysInDepot = daysInDepot;
    }
    
    
    // Methods
    /*
    *Update the status of the parcel.
    * newState the new status of the parcel
    */
    public void updateStatus(Status newState){
        this.status = newState;
        System.out.println("Parcel "+parcelID+"status updated to " + newState);
    }
    
    // valid a parcel request.
    // return true if the parcel can collected, false otherwise
    public boolean validRequest(){
        return this.status == Status.PENDING;
    }
    /*
    calculate the sorage fee based on the parcel's time in the depot and weight.
    * return the calculated storage fee
    */
    public double calculateSorageFee()
    {
        long daysStored = ChronoUnit.DAYS.between(daysInDepot, LocalDate.now());
        double baseFee = 2.0; // Base fee per day
        double weightSurcharge = 0.5 * weight; // Additional fee based on weight
        return daysStored * baseFee + weightSurcharge;
    }
    
    /*
    * Update the number of days the parcel has been in the deport
    */
    public void updateDaysInDepot()
    {
        System.out.println("Parcel"+ parcelID + "has been in the depot for" + ChronoUnit.DAYS.between(daysInDepot,LocalDate.now())+ "days.");   
    }
    
    // toString for better representation
    @Override
    public String toString()
    {
        return "Parce ID" + parcelID +
                ", Status: " + status +
                ", Dimensions: " + dimensions + " cm³" +
                ", Weight: " + weight + "Kg" +
                ", Days in Deport: " + daysInDepot;
    }
    
}
