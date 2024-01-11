package controllers;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import Modules.*;
public class Calculation {
	
	// TO-DO: Integrate service time calculation.
	public static void calculateClerksHeuristic(ArrayList<WorkShift> shiftList) {
	    for (WorkShift shift : shiftList) {
	        for (Unit unit : shift.getUnitList()) {
		            int clerksForUnit = (int) Math.ceil(shift.getWorkMinuteTime()/ (unit.getTotalServiceTime()));
		            unit.setClerk(clerksForUnit);
	        }
	    }
	}

	public static int calculateClerk(ArrayList<WorkShift> shifList){
		//these calculations are made for one unit !!! 
		int totalClerk = 0; //total clerk number in unit
		int properClerk = 0; //proper clerk number in unit
		ArrayList<Customer> customersForCommercial = new ArrayList<>(); 
		int a = 0;
		for(int i = 0; i< shifList.size(); i++){
			int shiftTime = shifList.get(i).getWorkMinuteTime();
			LocalTime workShiftStart = shifList.get(i).getStartTime();
			customersForCommercial = shifList.get(i).getUnitList().get(0).getCustomers(); //shiftListin 0. indexi (commercial)
			
			for(int j = 0; j < shiftTime; j++){
				a++;
			}
			System.out.println(i+1 + ". shift icin toplam dakika: " + a);
		}
		
		
		return 0;
	}
	
	public static LocalTime diffTime(LocalTime time1, LocalTime time2){
		int hour = time2.getHour();
		int minute = time2.getMinute();
		
		time1 = time1.minusMinutes(minute);
		time1 = time1.minusHours(hour);

		return time1; 
	}

	public static LocalTime increaseTime(LocalTime time){
		return time.plusMinutes(1);
	}

}
