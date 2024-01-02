package Modules;
import java.util.ArrayList;

public class Unit {
    private String name;
    private int maxWaitingTime;
    private double serviceTime;
    private ArrayList<Customer> customers;
    private int clerk = 0;
    //Constructors
    public Unit(String name, int maxWaitingTime, double serviceTime)
    {
        this.name = name;
        this.maxWaitingTime = maxWaitingTime;
        this.serviceTime = serviceTime;
        this.customers = null;
    }
    
    public Unit(String name, int maxWaitingTime, double serviceTime, ArrayList<Customer> customers)
    {
        this.name = name;
        this.maxWaitingTime = maxWaitingTime;
        this.serviceTime = serviceTime;
        this.customers = customers;
    }

    public static Unit toParse(String name, int maxWaitingTime, double serviceTime)
    {
    	Unit tempUnit = new Unit(name,maxWaitingTime,serviceTime);
    	return tempUnit;
    }
    //GET
    public String getName()
    {
        return this.name;
    }

    public int getMaxWaitingTime()
    {
        return this.maxWaitingTime;
    }

	public double getserviceTime()
    {
        return this.serviceTime;
    }
	
	public ArrayList<Customer> getCustomers(){
		return this.customers;
	}
	
    public int getClerk()
    {
    	if(clerk != 0)
    	{
    		return this.clerk;
    	}
    	return 0;
    }

    //wrong!!
    public int getTotalServiceTime() {
    	return this.maxWaitingTime * customers.size();
    }
    
    // SET
    public boolean setName (String name)
    {
        try{
            this.name = name;
            return true;
        }catch (Exception e)
        {
        	System.err.print(e);
            return false;
        }
    }

    public boolean setMaxWaitingTime(int maxWaitingTime)
    {
        try{
            this.maxWaitingTime = maxWaitingTime;
            return true;
        }catch (Exception e)
        {
        	System.err.print(e);
        	return false;
        } 
     }

    public boolean setserviceTime(double serviceTime)
    {
        try{
            this.serviceTime = serviceTime;
            return true;
        }catch (Exception e)
        {
        	System.err.print(e);
            return false;
        }
    }
    
    public boolean setCustomers(ArrayList<Customer> customers){
        try{
            this.customers = customers;
            return true;
        }catch (Exception e)
        {
        	System.err.print(e);
            return false;
        }
    }

    public boolean setClerk(int clerk)
    {
        try{
            this.clerk= clerk;
            return true;
        }catch (Exception e)
        {
        	System.err.print(e);
        	return false;
        } 
     }
}