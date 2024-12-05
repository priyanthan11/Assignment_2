/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

/**
 *
 * @author priyanthan
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
    public String getName() { 
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getContectInfo() {
        return this.contectInfo;
    }
    
    // Setters
    public void setName(String Name)
    {
        this.name = Name;
    }
    public void setSurename(String SurName){
        this.surname = SurName;
    }
    public void setContectInfo(String ContactInfo){
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
