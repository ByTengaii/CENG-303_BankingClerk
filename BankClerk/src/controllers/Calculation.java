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
		LocalTime exampleTime = LocalTime.of(11, 20);
		LocalTime diff = Calculation.diffTime(exampleTime, shifList.get(0).getStartTime());
		int diffMinute = Calculation.calculateMinute(diff);
		//these calculations are made for one unit !!! 
		int totalClerk = 0; //total clerk number in unit
		int properClerk = 0; //proper clerk number in unit
		ArrayList<Customer> customersForCommercial = new ArrayList<>(); 
		int a = 0;
		for(int i = 0; i< shifList.size(); i++){
			int shiftTime = shifList.get(i).getWorkMinuteTime();
			LocalTime currentTime = shifList.get(i).getStartTime();//current time
			customersForCommercial = shifList.get(i).getUnitList().get(0).getCustomers(); //shiftListin 0. indexi (commercial)
			int[] customerWaiting = new int[shifList.get(i).getUnitList().get(0).getCustomers().size()];
			System.out.println("shifttime toplam dakika: " + shiftTime);
			//for(int j = 0; j < shiftTime; j++){
			for(int j = 0; j < diffMinute; j++){
				a++;
				for(int k = 0; k < customersForCommercial.size(); k++){
					if(calculateMinute(diffTime(customersForCommercial.get(k).getArrivedTime(), currentTime)) == 0){
						customersForCommercial.get(k).setArrived(true);
					}

				}

				currentTime = Calculation.increaseTime(currentTime);
			}
			System.out.println("guncel saat: " + currentTime);
			System.out.println("bankaya gelen musteri sayisi: " + totalArrivedCustomer(customersForCommercial));
		}
		
		
		return 0;
	}
	
	//time1 - time2
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

	public static int calculateMinute(LocalTime time){
		return (time.getHour() * 60) + time.getMinute();
	}

	public static int totalArrivedCustomer(ArrayList<Customer> customerList){
		int counter = 0;
		for(int i = 0; i < customerList.size(); i++){
			if(customerList.get(i).getArrived())
				counter++;
		}
		return counter;
	}

}
