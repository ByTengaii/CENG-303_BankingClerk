package Modules;
import java.util.ArrayList;

public class Unit {
    private String name;
    private int maxWaitingTime;
    private double avgServiceTime;
    private ArrayList<Customer> customers;
    private int clerk = 0;
    //Constructors
    public Unit(String name, int maxWaitingTime, double avgServiceTime)
    {
        this.name = name;
        this.maxWaitingTime = maxWaitingTime;
        this.avgServiceTime = avgServiceTime;
        this.customers = null;
    }
    
    public Unit(String name, int maxWaitingTime, double avgServiceTime, ArrayList<Customer> customers)
    {
        this.name = name;
        this.maxWaitingTime = maxWaitingTime;
        this.avgServiceTime = avgServiceTime;
        this.customers = customers;
    }

    public static Unit toParse(String name, int maxWaitingTime, double avgServiceTime)
    {
    	Unit tempUnit = new Unit(name,maxWaitingTime,avgServiceTime);
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

	public double getAvgServiceTime()
    {
        return this.avgServiceTime;
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

    public boolean setAvgServiceTime(double avgServiceTime)
    {
        try{
            this.avgServiceTime = avgServiceTime;
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