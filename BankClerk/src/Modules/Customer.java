package Modules;

import java.util.ArrayList;

public class Customer {
    private int serviceTime;
    private String unit;

    //Constructor
    public Customer( int serviceTime, String unit)
    {
        this.serviceTime = serviceTime;
        this.unit = unit;
    }
    
    public static Customer toParse(int serviceTime, String unit) {
    	Customer temp = new Customer(serviceTime, unit);
    	return temp;
    }

    //GET
    public int getServiceTime()
    {
        return serviceTime;
    }

    public String getUnit()
    {
        return unit;
    }

    // SET
    public boolean setArrivalTime(int arrivalTime)
    {
    	try {
    		return true;
    	}catch(Exception e) {
        	System.err.print(e);
    		return false;
    	}
    }
   
    public boolean setServiceTime(int serviceTime)
    {
    	try {
    		this.serviceTime = serviceTime;
    		return true;
    	}catch(Exception e) {
        	System.err.print(e);
    		return false;
    	}
    }

    public boolean setUnit(String unit)
    {
    	try {
    		this.unit = unit;
    		return true;
    	}catch(Exception e) {
        	System.err.print(e);
    		return false;
    	}
    }
    
    public static ArrayList<Customer> createCustomers(String unit, int numberOfCustomer, int serviceTime){
    	ArrayList <Customer> tempCustomers = new ArrayList<>();
    	for(int i = 0; i < numberOfCustomer; i++ ) {
    		tempCustomers.add(Customer.toParse(serviceTime,unit));
    	}
    	return tempCustomers;
    }
}

