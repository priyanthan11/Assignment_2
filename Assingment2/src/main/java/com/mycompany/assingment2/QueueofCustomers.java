/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author priyanthan
 */
public class QueueofCustomers {
    private  Queue<Customer> customerQueue;
    
    // constructor
    public QueueofCustomers()
    {
        this.customerQueue = new LinkedList<>();
    }
    
    // Methods
    public void addCustomerToQueue(Customer customer)
    {
        customerQueue.add(customer);
        Log.getInstance().addEvent("Customer added to queue: " + customer);
    }
    
    public Customer removeCustomerFromQueue()
    {
        Customer customer = customerQueue.poll();
        if(customer == null)
        {
            Log.getInstance().addEvent("Customer removed from Queue: "+ customer);
        }
        return customer;
    }
    
    public Customer getNextCustomer()
    {
        return customerQueue.peek();
    }
    
    public boolean isEmpty()
    {
        return customerQueue.isEmpty();
    }
    
    public int getQueueSize()
    {
        return customerQueue.size();
    }
    
    
    
    
}
