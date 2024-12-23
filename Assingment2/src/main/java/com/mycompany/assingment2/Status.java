/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

/**
 *
 * @author priya
 */
public enum Status {
        // Enum 
    PROCESSING,
    PENDING,
    COLLECTED,
    IN_TRANSIT,
    LOST;
    /*
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
    */
}
