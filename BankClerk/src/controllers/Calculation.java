package controllers;

import java.time.LocalTime;
import java.util.ArrayList;
import Modules.*;
public class Calculation {
	

	public static int calculateClerk(ArrayList<WorkShift> shifList){
		//LocalTime exampleTime = LocalTime.of(17, 20);
		//LocalTime diff = Calculation.diffTime(exampleTime, shifList.get(i).getStartTime());
		//int diffMinute = Calculation.calculateMinute(diff);
		//these calculations are made for one unit !!! 
		
		ArrayList<Customer> customersForCommercial = new ArrayList<>(); 
		//shifList.size()
		for(int i = 0; i< 1; i++){
			
			//shifList.get(i).getUnitList().size()
			for(int u = 0; u < 1; u++){
				int totalClerk = 1; //total clerk number in unit
				int properClerk = 1; //proper clerk number in unit	
				
				
				int shiftTime = shifList.get(i).getWorkMinuteTime();
				LocalTime currentTime = shifList.get(i).getStartTime();//current time
				customersForCommercial = shifList.get(i).getUnitList().get(u).getCustomers(); //shiftListin 0. indexi (commercial)
				//System.out.println("------------------------------");				
				for(int j = 0; j < shiftTime; j++){
					for(int k = 0; k < customersForCommercial.size(); k++){
						if(calculateMinute(diffTime(customersForCommercial.get(k).getArrivedTime(), currentTime)) == 0){
							customersForCommercial.get(k).setArrived(true);
						}

					}
					for(int y = 0; y < customersForCommercial.size(); y++){
					if(customersForCommercial.get(y).getArrived() && !customersForCommercial.get(y).getOnProcess() && !customersForCommercial.get(y).getIsOut()){
						if(properClerk > 0){
							properClerk--;
							customersForCommercial.get(y).setOnProcess(true);
							customersForCommercial.get(y).setStartProcess(currentTime);
						}
						int howLong = calculateMinute(diffTime(currentTime,customersForCommercial.get(y).getArrivedTime()));
						customersForCommercial.get(y).setWaitingTime(howLong);
						if(howLong >= shifList.get(i).getUnitList().get(u).getMaxWaitingTime()){
							if(properClerk > 0){
								properClerk--;
								customersForCommercial.get(y).setOnProcess(true);
								customersForCommercial.get(y).setStartProcess(currentTime);
							}else{
								totalClerk++;
								customersForCommercial.get(y).setOnProcess(true);
								customersForCommercial.get(y).setStartProcess(currentTime);
							}
						}
						}else if(customersForCommercial.get(y).getArrived() && customersForCommercial.get(y).getOnProcess()){
							int tempA = calculateMinute(diffTime(currentTime, customersForCommercial.get(y).getStartProcess())); 
							if(tempA == shifList.get(i).getUnitList().get(u).getserviceTime()){
								properClerk++;
								customersForCommercial.get(y).setEndProcess(currentTime);
								customersForCommercial.get(y).setOnProcess(false);
								System.out.println("musterinin islemi bitti saat: " + currentTime);
								System.out.println("guncel toplam clerk sayisi: " + totalClerk);
								System.out.println("guncel proper clerk sayisi: " + properClerk);
								customersForCommercial.get(y).setIsOut(true);
							}else{
							customersForCommercial.get(y).setHowLongProcess(tempA + 1);
							}
						}
				}
		
				currentTime = Calculation.increaseTime(currentTime);
			}
			System.out.println();
			System.out.println("Current time: " + currentTime);

			for(int l = 0; l < customersForCommercial.size(); l++){
				System.out.println("musteriler su saatler arasinda isleme girip cikti:");
				System.out.println(customersForCommercial.get(l).getStartProcess() + " - " + customersForCommercial.get(l).getEndProcess());
				System.out.println("musterinin bekledigi sure ve islem suresi:");
				System.out.println(customersForCommercial.get(l).getWaitingTime() + " - " + shifList.get(i).getUnitList().get(i).getserviceTime());
				System.out.println();
			}

			System.out.println("Nubmer of customer arrived unit: " + totalArrivedCustomer(customersForCommercial));
			System.out.println("total clerk for unit: " + totalClerk);
			System.out.println("proper clerk for unit: " + properClerk);
			//System.out.println("-----------------------------------");
		}
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
