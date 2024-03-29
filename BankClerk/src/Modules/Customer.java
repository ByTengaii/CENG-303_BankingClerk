package Modules;

import java.time.LocalTime;
import java.util.ArrayList;

public class Customer {
    private int waitingTime;
    private String unit;
    private LocalTime arrivedTime;
    private LocalTime startProcess;
    private LocalTime endProcess;
    private Boolean arrived;
    private Boolean onProcess;
    private int howLongProcess;
    private Boolean isOut;

    public Boolean getIsOut() {
        return isOut;
    }

    public void setIsOut(Boolean isOut) {
        this.isOut = isOut;
    }

    public LocalTime getStartProcess() {
        return startProcess;
    }

    public void setStartProcess(LocalTime startProcess) {
        this.startProcess = startProcess;
    }


    public LocalTime getEndProcess() {
        return endProcess;
    }

    public void setEndProcess(LocalTime endProcess) {
        this.endProcess = endProcess;
    }

    public int getHowLongProcess() {
        return howLongProcess;
    }

    public void setHowLongProcess(int howLongProcess) {
        this.howLongProcess = howLongProcess;
    }

    public Boolean getOnProcess() {
        return onProcess;
    }

    public void setOnProcess(Boolean onProcess) {
        this.onProcess = onProcess;
    }

    public Boolean getArrived() {
        return arrived;
    }

    public void setArrived(Boolean arrived) {
        this.arrived = arrived;
    }

    public LocalTime getArrivedTime() {
        return arrivedTime;
    }

    //Setting arrived time for customer by convert given string parameter to localtime object
    public void setArrivedTime(String arrivedTime) {
        String arr[] = arrivedTime.split(":");
        LocalTime temp = LocalTime.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        this.arrivedTime = temp;
    }

    public void setArrivedTime(LocalTime arrivedTime){
        this.arrivedTime = arrivedTime;
    }

    //Constructor
    public Customer( int serviceTime, String unit, String arrivedTime)
    {
        this.waitingTime = serviceTime;
        this.unit = unit;
        String arr[] = arrivedTime.split(":");
        LocalTime temp = LocalTime.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        this.arrivedTime = temp;
        this.arrived = false;
        this.onProcess = false;
        this.howLongProcess = 0;
        this.isOut = false;
    }

    public Customer(String unit, String arrivedTime){
        this.unit = unit;
        String arr[] = arrivedTime.split(":");
        LocalTime temp = LocalTime.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        this.arrivedTime = temp;
        this.arrived = false;
        this.onProcess = false;
        this.howLongProcess = 0;
        this.isOut = false;
    }
    
    public static Customer toParse(int serviceTime, String unit, String arrivedTime) {
    	Customer temp = new Customer(serviceTime, unit, arrivedTime);
    	return temp;
    }

    public static Customer toParse(String unit, String arrivedTime) {
    	Customer temp = new Customer(unit, arrivedTime);
    	return temp;
    }

    //GET
    public int getWaitingTime()
    {
        return waitingTime;
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
   
    public boolean setWaitingTime(int serviceTime)
    {
    	try {
    		this.waitingTime = serviceTime;
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
