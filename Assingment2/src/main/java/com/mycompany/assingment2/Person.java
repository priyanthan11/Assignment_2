/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

/**
 *
 * @author priya
 */
public abstract class Person {
    
    /*
    This is the person class which will be serve as a parent class for customer
    and staff sub-classes. This class will be responsivle for storing customer
    /staff personal details
    */
    
    
    // Attributes
    private String name;
    private String surname;
    private String contectInfo;
    
    // Constructor
    public Person(String name,String surname,String contactInfo)
    {
        this.name = name;
        this.surname = surname;
        this.contectInfo = contactInfo;
    }
    
    
    
    // Getters
    public String GetName() { 
        return this.name;
    }
    public String GetSurname(){
        return this.surname;
    }
    public String GetContectInfo() {
        return this.contectInfo;
    }
    
    // Setters
    public void SetName(String Name)
    {
        this.name = Name;
    }
    public void SetSurename(String SurName){
        this.surname = SurName;
    }
    public void SetContectInfo(String ContactInfo){
        this.contectInfo = ContactInfo;
    }
    
    // Abstract fucntions
    public abstract void requestParcelCollection();
    public abstract void trackParcel(String ParcelID);
    public abstract void visitCollectionCenter();
    
    // toString method for log
    @Override
    public String toString(){
        return "Name: "+this.name+", Surname: "+this.surname+", Contect Info: "+this.contectInfo;
    }
}
