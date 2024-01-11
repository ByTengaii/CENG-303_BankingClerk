package Modules;
import java.time.LocalTime;
import java.util.ArrayList;

import controllers.Calculation;

public class WorkShift{
	private String name;
	private LocalTime startTime;
	private LocalTime endTime;
	private ArrayList<Unit> unitList;

	//Constructor
	public WorkShift(String name, LocalTime startTime, LocalTime endTime)
	{
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.unitList = null;
	}
	
	public WorkShift(String name, LocalTime startTime, LocalTime endTime, ArrayList<Unit> unitList)
	{
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.unitList = unitList;
	}

	public static WorkShift toParse(String name, LocalTime startTime, LocalTime endTime)
	{
		WorkShift temp = new WorkShift(name, startTime, endTime);
		return temp;
	}

	//GET
	public String getName() {
		return this.name;
	}
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public LocalTime getEndTime() {
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
		LocalTime newTime = Calculation.diffTime(endTime, startTime);
		return (newTime.getHour() * 60) + newTime.getMinute();
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
	public boolean setStartTime(LocalTime startTime) {
		try {
			this.startTime = startTime;
			return true;
		}catch(Exception e) {
			System.err.print(e);
			return false;
		}
	}

	public boolean setEndTime(LocalTime endTime) {
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