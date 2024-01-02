package Modules;

import java.time.LocalTime;
import java.util.ArrayList;

public class Customer {
    private int serviceTime;
    private String unit;
    private LocalTime arrivedTime;

    public LocalTime getArrivedTime() {
        return arrivedTime;
    }

    //Setting arrived time for customer by convert given string parameter to localtime object
    public void setArrivedTime(String arrivedTime) {
        String arr[] = arrivedTime.split(":");
        LocalTime temp = LocalTime.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        this.arrivedTime = temp;
    }

    //Constructor
    public Customer( int serviceTime, String unit, String arrivedTime)
    {
        this.serviceTime = serviceTime;
        this.unit = unit;
        String arr[] = arrivedTime.split(":");
        LocalTime temp = LocalTime.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        this.arrivedTime = temp;
    }
    
    public static Customer toParse(int serviceTime, String unit, String arrivedTime) {
    	Customer temp = new Customer(serviceTime, unit, arrivedTime);
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
    
    public static ArrayList<Customer> createCustomers(String unit, int numberOfCustomer, int serviceTime, String arrivedTime){
    	ArrayList <Customer> tempCustomers = new ArrayList<>();
    	for(int i = 0; i < numberOfCustomer; i++ ) {
    		tempCustomers.add(Customer.toParse(serviceTime,unit, arrivedTime));
    	}
    	return tempCustomers;
    }
}

