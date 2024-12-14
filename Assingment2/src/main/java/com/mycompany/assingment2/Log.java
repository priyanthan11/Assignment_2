/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

/**
 *
 * @author priya
 */
public class Log {
    private static Log instance;
    private StringBuffer logBuffer;
    
    // Private constructor
    private Log()
    {
        logBuffer = new StringBuffer();
    }
    
    // Get Instance 
    public static synchronized Log getInstance()
    {
        if(instance == null)
        {
            instance = new Log();
        }
        return instance;
    }
    
    // Methpds
    public void addEvent(String event)
    {
        logBuffer.append(event).append("\n");
        System.out.println(event);
    }
    
    public void writeLogToFile(String fileName)
    {
        try(java.io.FileWriter writer = new java.io.FileWriter(fileName))
        {
            writer.write(logBuffer.toString());
            System.out.println("Log written to "+ fileName);
            
        }catch (Exception e)
                {
                    System.out.println("Error writing log to file: "+e.getMessage());
                }
    }
}
