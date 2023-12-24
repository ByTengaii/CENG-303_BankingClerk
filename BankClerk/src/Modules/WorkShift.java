package Modules;
import java.util.ArrayList;

public class WorkShift{
	private String name;
	private int startTime;
	private int endTime;
	private ArrayList<Unit> unitList;

	//Constructor
	public WorkShift(String name, int startTime, int endTime)
	{
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.unitList = null;
	}
	
	public WorkShift(String name, int startTime, int endTime, ArrayList<Unit> unitList)
	{
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.unitList = unitList;
	}

	public static WorkShift toParse(String name, int startTime, int endTime)
	{
		WorkShift temp = new WorkShift(name, startTime, endTime);
		return temp;
	}

	//GET
	public String getName() {
		return this.name;
	}
	
	public int getStartTime() {
		return this.startTime;
	}
	
	public int getEndTime() {
		return this.endTime;
	}
	
	public ArrayList<Unit> getUnitList (){
		if(this.unitList != null)
		{
			return this.unitList;
		}else {
			System.err.print("UnitList is null of "+this.name+" workShift");
			return null;
		}
	}

	//TO-DO: Integrate service time 
	public int getWorkMinuteTime() {
		return (this.endTime - this.startTime) * 60;
	}
	
	//SET
	public boolean setName(String name) {
		try {
			this.name = name;
			return true;
		}catch(Exception e) {
			System.err.print(e);
			return false;
		}
	}
	public boolean setStartTime(int startTime) {
		try {
			this.startTime = startTime;
			return true;
		}catch(Exception e) {
			System.err.print(e);
			return false;
		}
	}

	public boolean setEndTime(int endTime) {
		try {
			this.endTime = endTime;
			return true;
		}catch(Exception e) {
			System.err.print(e);
			return false;
		}
	}
	
	public boolean setUnitList(ArrayList<Unit> unitList) {
		try {
			if (this.unitList != null) {
				System.out.println("You making an overwrite for "+this.name+" workshift units");
				this.unitList = unitList;
			}else {
				this.unitList = unitList;
			}
			return true;
		}catch(Exception e) {
			System.err.print(e);
			return false;
		}
		
	}
}